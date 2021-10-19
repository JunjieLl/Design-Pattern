package director.olympic;

public class Main {
    public static void main(String[] args) {
        Director.getInstance().nextScene(new Scene() {
            @Override
            void play() {
                System.out.println("奥林匹克运动会开始了！");
            }
        });
    }
}
