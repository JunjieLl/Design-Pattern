package olympic.scene;

import olympic.main.opening.translate.EnglishAdapter;
import olympic.main.opening.translate.FrenchAdapter;
import olympic.main.opening.translate.SpanishAdapter;
import olympic.main.opening.translate.Speaker;

import java.util.Scanner;

public class TranslateScene implements Scene{
    @Override
    public void play() {
        System.out.println("classname:(TranslateScene) method:(Speaker) action:(生成主持人)");
        Speaker a = new Speaker();
        System.out.println("请问您是否需要外文翻译[是/否]？");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if(option.equals("是")) {

            System.out.println("请问您是否需要的是[英文/法语/西班牙语]的翻译？");
            sc = new Scanner(System.in);
            option = sc.next();
            if(option.equals("英文")){
                System.out.println("classname:(EnglishAdapter) method:(translate) action:(生成英语主持人适配器)");
                EnglishAdapter englishAdapter=new EnglishAdapter(a);
                englishAdapter.translate();
            }
            else if(option.equals("法语"))
            {
                System.out.println("classname:(FrenchAdapter) method:(translate) action:(生成法语主持人适配器)");
                FrenchAdapter frenchAdapter=new FrenchAdapter(a);
                frenchAdapter.translate();
            }
            else if(option.equals("西班牙语"))
            {
                System.out.println("classname:(SpanishAdapter) method:(translate) action:(生成西班牙语主持人适配器)");
                SpanishAdapter spanishAdapter=new SpanishAdapter(a);
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