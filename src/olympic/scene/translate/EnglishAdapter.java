package olympic.scene.translate;

class EnglishAdapter implements Translator{
    private Speaker speaker;
    public EnglishAdapter(Speaker speaker){
        this.speaker =speaker;
    }
    @Override
    public void translate() {
        String result = speaker.speak();
        String englishResult="主持人说话内容为：Welcome to the Olympic Games! ";
        System.out.println(englishResult);
    }
}