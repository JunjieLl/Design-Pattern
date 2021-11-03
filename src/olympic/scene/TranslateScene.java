package olympic.scene;

import olympic.main.opening.translate.EnglishAdapter;
import olympic.main.opening.translate.FrenchAdapter;
import olympic.main.opening.translate.SpanishAdapter;
import olympic.main.opening.translate.Speaker;

import java.util.Scanner;

public class TranslateScene implements Scene {


    @Override
    public void play() {
        Speaker a = new Speaker();
        System.out.println("请问您是否需要外文翻译[是/否]？");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equals("是")) {

            System.out.println("请问您是否需要的是[英文/法语/西班牙语]的翻译？");
            sc = new Scanner(System.in);
            option = sc.next();
            if (option.equals("英文")) {
                EnglishAdapter englishAdapter = new EnglishAdapter(a);
                englishAdapter.translate();
            } else if (option.equals("法语")) {
                FrenchAdapter frenchAdapter = new FrenchAdapter(a);
                frenchAdapter.translate();
            } else if (option.equals("西班牙语")) {
                SpanishAdapter spanishAdapter = new SpanishAdapter(a);
                spanishAdapter.translate();
            }
        }
    }

//    public static void main(String[] args) {
//        TranslateScene translateScene=new TranslateScene();
//        translateScene.play();
//
//    }
}
