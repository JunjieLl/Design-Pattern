package olympic.voiceover;

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
        String template = "./src/voiceover/%d.txt";
        String path = String.format(template, index);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
