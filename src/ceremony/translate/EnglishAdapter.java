package ceremony.translate;

class EnglishAdapter implements Translator{
    private Speaker speaker;
    public EnglishAdapter(Speaker speaker){
        this.speaker =speaker;
    }
    @Override
    public void translate() {
        String result = speaker.speak();
        String englishResult="主持人说话内容为："+result+"\n"+"正在转换为英文翻译...";
        System.out.println(englishResult);

    }
}