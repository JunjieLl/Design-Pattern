package ceremony.translate;

class SpanishAdapter implements Translator{
    private Speaker speaker;
    public SpanishAdapter(Speaker speaker){
        this.speaker =speaker;
    }
    @Override
    public void translate() {
        String result = speaker.speak();
        String spanishResult="主持人说话内容为："+result+"\n"+"正在转换为西班牙语翻译...";
        System.out.println(spanishResult);
    }
}
