package olympic.picture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutputPicture {
    public static void main(String[] args) {
        /**
         *  demo
         */
        printPictureOf(12);
    }

    /**
     *
     * @param index 图片编号 1- 16
     */
    public static void printPictureOf(int index) {
        String template = "./src/picture/%d.txt";
        String path = String.format(template, index);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String str;
            System.out.println("\033[1;" + 35+"m");
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println("\033[0m \n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
