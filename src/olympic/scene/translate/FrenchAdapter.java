package olympic.scene.translate;

class FrenchAdapter implements Translator{
    private Speaker speaker;
    public FrenchAdapter(Speaker speaker){
        this.speaker =speaker;
    }
    @Override
    public void translate() {
        String result = speaker.speak();
        String frenchResult="主持人说话内容为：Bienvenue aux Jeux olympiques!";
        System.out.println(frenchResult);
    }
}
