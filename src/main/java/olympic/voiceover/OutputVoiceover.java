package olympic.voiceover;

import olympic.main.director.Sleep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutputVoiceover {
    public static void main(String[] args) {
        /**
         *  demo
         */
        printVoiceoverOf(1);
    }

    /**
     *
     * @param index 旁白 1- 18
     */
    public static void printVoiceoverOf(int index) {
        String template = "./src/main/resources/voiceover/%d.txt";
        String path = String.format(template, index);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String str;
//            System.out.println("\033[1;" + 33);
            System.out.println("\033[1;33m");
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println("\033[0m \n");
//            System.out.println("\033[0m \n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sleep.sleep("short");
    }
}
