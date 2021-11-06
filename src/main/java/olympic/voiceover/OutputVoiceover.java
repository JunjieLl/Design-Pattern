package olympic.voiceover;

import olympic.main.director.Sleep;

import java.io.*;

/**
 * 旁白
 */
public class OutputVoiceover {
    /**
     * @param index 旁白 1- 18
     */
    public static void printVoiceoverOf(int index) {
        String template = "/voiceover/%d.txt";
        String path = String.format(template, index);
        InputStream inputStream = OutputVoiceover.class.getResourceAsStream(path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
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
