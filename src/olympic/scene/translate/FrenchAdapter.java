package olympic.scene.translate;

class FrenchAdapter implements Translator{
    private Speaker speaker;
    public FrenchAdapter(Speaker speaker){
        this.speaker =speaker;
    }
    @Override
    public void translate() {
        String result = speaker.speak();
        String frenchResult="主持人说话内容为："+result+"\n"+"正在转换为法语翻译...";
        System.out.println(frenchResult);
    }
}
