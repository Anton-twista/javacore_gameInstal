import java.io.*;


public class Main {
    public static StringBuilder sb = new StringBuilder("Журнал: \n");
    public static final String gamePath = "E://Java_Game";


    public static void makeDir(String childDirectory) {

        File dir = new File(gamePath + childDirectory);
        if (dir.mkdir()) {
            sb.append("Каталог успешно создан: ")
                    .append(dir)
                    .append(" \n");
        } else if (dir.equals(dir.getAbsoluteFile())) {
            System.out.print("");
        } else
            sb.append("Каталог не был создан!!!")
                    .append(dir)
                    .append(" \n");
    }

    public static void makeFile(String pathToFile) {

        try {
            File file = new File(gamePath, pathToFile);
            if (file.createNewFile()) {
                sb.append("Файл успешно создан: ")
                        .append(file)
                        .append(" \n");
            } else if (file.equals(file.getAbsoluteFile())) {
                System.out.print("");
            } else
                sb.append("Файл не был создан!!! ")
                        .append(file)
                        .append(" \n");
        } catch (IOException ex) {
            sb.append(ex.getMessage());
            sb.append(" \n");
        }
    }

    public static void main(String[] args) {

        makeDir("//src");
        makeDir("//src//test");
        makeDir("//src//main");
        makeDir("//res");
        makeDir("//res//drawables");
        makeDir("//res//vectors");
        makeDir("//res//icon");
        makeDir("//temp");
        makeDir("//saves");

        makeFile("//temp//temp.txt");
        makeFile("src/main/Main.java");
        makeFile("src/main/Util.java");
        makeFile("saves/save.dat");


        try (FileWriter writer = new FileWriter("E://Java_Game/temp/temp.txt", true)) {
            writer.write(sb.toString());
            writer.append(" \n");
            writer.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage())
                    .append(" \n");
        }
        System.out.println(sb.toString());
    }
}