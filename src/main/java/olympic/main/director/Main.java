package olympic.main.director;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 测试的时候将下面这行注释打开，也就是把sleep关掉，就不用等了
         *
         */
//        Sleep.setNeedSleep(false);

        /**
         * 在需要停顿的地方加下面这句
         */
        Sleep.sleep("short");
        
        /**
         * 可以把这行注释掉测试自己的东西
         *
         */
        Director.getInstance().start();

    }
}