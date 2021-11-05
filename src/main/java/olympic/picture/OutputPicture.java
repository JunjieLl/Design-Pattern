package olympic.picture;

import olympic.main.director.Mode;
import olympic.main.director.Sleep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 输出图片
 */
public class OutputPicture {
    public static void main(String[] args) {
        printPictureOf(12);
    }

    /**
     *
     * @param index 图片编号 1-16
     */
    public static void printPictureOf(int index) {
        String template = "./src/main/resources/picture/%d.txt";
        String path = String.format(template, index);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String str;
            System.out.println("\033[1;" + 34+"m");
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println("\033[0m \n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if (Mode.getNeedDetail()) {
//            Scanner scanner = new Scanner(System.in);
//            scanner.nextLine();
//        }
        Sleep.sleep("short");
    }
}
