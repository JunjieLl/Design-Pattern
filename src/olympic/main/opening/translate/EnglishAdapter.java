package olympic.main.opening.translate;

public class EnglishAdapter implements Translator{
    private Speaker speaker;
    public EnglishAdapter(Speaker speaker){
        this.speaker =speaker;
    }

    /**
     * 设计模式：适配器模式
     * 接口重写为英文翻译
     */
    @Override
    public void translate() {
        String result = speaker.speak();
        String englishResult="主持人说话内容为：Welcome to the Olympic Games! ";
        System.out.println(englishResult);
    }
}