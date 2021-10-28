package olympic.scene;

import olympic.main.game.football.Test;

public class Main {
    public static void main(String[] args) {
        Director.getInstance().nextScene(new Scene() {
            @Override
            public void play() {
                System.out.println("奥林匹克运动会开始了！");
            }
        });
        new Test().start();
    }
}