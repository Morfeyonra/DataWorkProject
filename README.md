## DataWorkProject

- Исполняемый jar:  
DataWorkProject\out\artifacts\DataWorkProject_jar\DataWorkProject.jar

- Дамп БД:  
DataWorkProject\test_DB.sql

- Файлы для теста БД:  
DataWorkProject\TestFiles

- Для работы необходимо разместить дамп БД в директории исполняемого jar файла.

- запуск программы:  
`java -jar -Dfile.encoding=UTF-8 DataWorkProject.jar {X} {Y} {Z}`

где {X}, {Y}, {Z}:   
{X} - search или stat   
{Y} - входной файл   
{Z} - выходной файл   
