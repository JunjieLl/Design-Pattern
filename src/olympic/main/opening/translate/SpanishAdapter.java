package olympic.main.opening.translate;

public class SpanishAdapter implements Translator{
    private Speaker speaker;
    public SpanishAdapter(Speaker speaker){
        this.speaker =speaker;
    }

    /**
     * 设计模式：适配器模式
     * 接口重写为西班牙语翻译
     */
    @Override
    public void translate() {
        String result = speaker.speak();
        String spanishResult="主持人说话内容为：Bienvenidos a los Juegos Olímpicos";
        System.out.println(spanishResult);
    }
}
