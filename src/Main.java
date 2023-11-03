import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File fileGo = new File("C:\\papka\\file\\gogo.txt"); //прикрепили файл с компа
        File fileCo = new File("data\\coco.txt"); //разместили файл с компа в проект
        System.out.println(fileGo.length()); //длинну текста посмотрели в файле
        System.out.println(fileCo.length());

        File filePapk = new File("C:\\Users\\Хомякмен\\Desktop\\календари");
        File[] files = filePapk.listFiles();
        System.out.println(filePapk.isDirectory()); //посмотрели, является ли папкой

        for (File file : files) {
            System.out.println(file.getAbsolutePath()); //посмотрели содержимое папки
        }
        File fileGa = new File("C:\\papka\\file\\gaga.txt");
        fileGa.mkdir();  //создали новую папку на компе


        //Чтение файлов:
        // способ 1: FileInputStream - не печатает буквы русс. Алфавита
        StringBuilder builder1 = new StringBuilder();
        try {
            FileInputStream is = new FileInputStream("data\\coco.txt");
            for (;;) {
                int code = is.read();
                if (code < 0) {
                  break;
                }
                char ch = (char) code;
                builder1.append(ch);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(builder1.toString());


        // способ 2: BufferedReader
        StringBuilder builder2 = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data\\coco.txt"));
            for (;;) {
                String line = br.readLine();
                if (line == null){
                    break;
                }
                builder2.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(builder2.toString());

        // способ 3: File Класс
        StringBuilder builder3 = new StringBuilder();
        try {
            List<String>  lines = Files.readAllLines(Paths.get("data\\coco.txt"));
            lines.forEach(line -> builder3.append(line + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(builder3.toString());


        // Записи в файлы:
        // способ 1: FileOutputStream - НЕУДОБНО. ТАК НЕ ДЕЛАЕМ
        try {
            FileOutputStream os = new FileOutputStream("data\\koko.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // способ 2: PrintWriter
        try {
            PrintWriter  writ = new PrintWriter("data\\koko.txt");
            for (int i = 0; i <= 100; i++) { //записываем числа в файл
                writ.write(i + ", ");
            }
            writ.flush(); // сброс буфера - обязательно
            writ.close(); // закрываем файл - ОБЯЗАТЕЛЬНО
        }
        catch (FileNotFoundException exe) {
            exe.printStackTrace();
        }

        // способ 3: File Класс
        try {
            ArrayList <String>  string = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                string.add(Integer.toString(i));
            }
            Files.write(Paths.get("data\\koko.txt"), string);

        } catch (Exception i) {
            i.printStackTrace();
        }
    }
}