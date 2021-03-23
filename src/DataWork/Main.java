package DataWork;

import DataWork.PogoClasses.ExceptionPogo;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        if (!checkCMDArgs(args)) {
            System.out.println("Ошибка в аргументах командной строки");
            return;
        }

        String inputJson;

        try {
            inputJson = readFileAsString(args[1]);
        } catch (IOException exception) {
            sendExceptionToServer("Неувязочка вышла, не удалось прочесть файл", args[2]);
            return;
        }

        DataBase dataBase = new DataBase();

        if (args[0].equals("search")) {

            Search search = new Search();

            if (search.parseSearch(inputJson)) {
                sendExceptionToServer("Ууупс, неправильный формат входных данных", args[2]);
                return;
            }

            StringBuilder result = new StringBuilder();
            result.append("{\"type\":\"search\",\"results\":[");

            String names = dataBase.getNames(search.getLastNames());
            if (names != null) {
                result.append(names);
            } else {
                sendExceptionToServer("Неувязочка вышла, проблема связана с БД (подключение/данные)", args[2]);
                return;
            }

            String namesFromGoods = dataBase.getNamesFromGoods(search.getGoods());
            if (namesFromGoods != null) {
                result.append(namesFromGoods);
            } else {
                sendExceptionToServer("Неувязочка вышла, проблема связана с БД (подключение/данные)", args[2]);
                return;
            }

            String namesFromExpenses = dataBase.getNamesFromExpenses(search.getExpenses());
            if (namesFromExpenses != null) {
                result.append(namesFromExpenses);
            } else {
                sendExceptionToServer("Неувязочка вышла, проблема связана с БД (подключение/данные)", args[2]);
                return;
            }

            String namesOfBaddies = dataBase.getNamesOfBaddies(search.getBadCustomers());
            if (namesOfBaddies != null) {
                result.append(namesOfBaddies);
            } else {
                sendExceptionToServer("Неувязочка вышла, проблема связана с БД (подключение/данные)", args[2]);
                return;
            }

            result.deleteCharAt(result.length() - 1);
            result.append("]}");

            if (result.toString().equals("{\"type\":\"search\",\"results\":]}")) {
                sendExceptionToServer("Вот незадача, ни одного аргуента criterias для режима search", args[2]);
                return;
            }

            writeFile(result.toString(), args[2]);

        } else if (args[0].equals("stat")) {

            Stat stat = Stat.parseStat(inputJson);

            if (stat == null) {
                sendExceptionToServer("Вот незадача, ни одного верного аргуента json для режима stat", args[2]);
                return;
            }

            writeFile(dataBase.getStatistics(stat), args[2]);
        }
    }

    private static boolean checkCMDArgs(String[] args) {
        if (args.length != 3) {
            return false;
        }
        if (!args[0].equals("search") && !args[0].equals("stat")) {
            return false;
        }
        if (!isFileNameValid(args[1])) {
            return false;
        }
        if (!isFileNameValid(args[2])) {
            return false;
        }
        return true;
    }

    private static boolean isFileNameValid(String file) {
        File f = new File(file);
        try {
            f.getCanonicalPath();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static void sendExceptionToServer(String message, String fileName) {
        Gson gson = new Gson();
        ExceptionPogo exceptionPogo = new ExceptionPogo();
        exceptionPogo.setMessage(message);
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(gson.toJson(exceptionPogo));
        } catch (IOException e) {
            System.out.println("Ошибка, не удалось создать выходной файл");
            System.out.println(gson.toJson(exceptionPogo));
        }
    }

    private static void writeFile(String message, String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(message);
        } catch (IOException e) {
            System.out.println("Ошибка, не удалось создать выходной файл");
            System.out.println(message);
        }
    }
}