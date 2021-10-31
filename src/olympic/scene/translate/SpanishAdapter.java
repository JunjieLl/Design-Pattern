package olympic.scene.translate;

class SpanishAdapter implements Translator{
    private Speaker speaker;
    public SpanishAdapter(Speaker speaker){
        this.speaker =speaker;
    }
    @Override
    public void translate() {
        String result = speaker.speak();
        String spanishResult="主持人说话内容为：Bienvenidos a los Juegos Olímpicos";
        System.out.println(spanishResult);
    }
}
