package olympic.picture;

import olympic.main.director.Mode;
import olympic.main.director.Sleep;
import olympic.voiceover.OutputVoiceover;

import java.io.*;
import java.util.Scanner;

/**
 * 输出图片
 */
public class OutputPicture {


    /**
     * @param index 图片编号 1-16
     */
    public static void printPictureOf(int index) {
        String template = "/picture/%d.txt";
        String path = String.format(template, index);
        InputStream inputStream = OutputVoiceover.class.getResourceAsStream(path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            System.out.println("\033[1;" + 34 + "m");
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
