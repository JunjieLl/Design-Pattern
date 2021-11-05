package olympic.scene;

import olympic.main.opening.translate.EnglishAdapter;
import olympic.main.opening.translate.FrenchAdapter;
import olympic.main.opening.translate.SpanishAdapter;
import olympic.main.opening.translate.Speaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("主持人翻译场景")
class TranslateSceneTest {
    /**
     * 测试TranslateScene.play()方法
     */
    @Test
    void test() {
        System.out.println("classname:(TranslateScene) method:(Speaker) action:(生成主持人)");
        Speaker a = new Speaker();
        System.out.println("classname:(EnglishAdapter) method:(translate) action:(生成英语主持人适配器)");
        EnglishAdapter englishAdapter = new EnglishAdapter(a);
        englishAdapter.translate();
        System.out.println("classname:(FrenchAdapter) method:(translate) action:(生成法语主持人适配器)");
        FrenchAdapter frenchAdapter = new FrenchAdapter(a);
        frenchAdapter.translate();
        System.out.println("classname:(SpanishAdapter) method:(translate) action:(生成西班牙语主持人适配器)");
        SpanishAdapter spanishAdapter = new SpanishAdapter(a);
        spanishAdapter.translate();
    }


}
