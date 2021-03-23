package DataWork;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Stat {
    private String startDate;
    private String endDate;

    public static Stat parseStat(String inputString) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(inputString, Stat.class);
        } catch (JsonSyntaxException ex) {
            return null;
        }

    }

    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
}
