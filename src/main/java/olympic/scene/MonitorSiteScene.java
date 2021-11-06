package olympic.scene;

import olympic.main.postgame.monitorsite.Command;
import olympic.main.postgame.monitorsite.CommandStack;
import olympic.main.postgame.monitorsite.Monitor;
import olympic.main.postgame.monitorsite.MonitorController;

import java.util.Scanner;

/**
 * 设计模式：命令模式、备忘录模式
 * 场地回检
 */
public class MonitorSiteScene implements Scene {

    /**
     * 运行场景
     */
    @Override
    public void play() {
        /**
         * 创建监视器、遥控器、栈
         */
        Monitor tv = new Monitor();
        MonitorController teleController = new MonitorController();
        CommandStack stack = new CommandStack();

        System.out.println("是否要继续检查下一个场地？[-1:退出，0:返回，1:继续]");
        Scanner sc = new Scanner(System.in);
        int cur = 1;
        String key = sc.next();

        while (!(key.equals("-1")) && cur <= 6) {
            if (cur == 6 && key.equals("1"))
                break;
            if (key.equals("0")) {

                if (cur > 1) {

                    teleController.restoreMemento(stack.pop());
                    if (cur > 2)
                        cur -= 1;
                } else {
                    System.out.println("Error:没有上一条命令，输入错误!");
                }
            }
            else if (key.equals("1")) {
                Command now_command = teleController.createMemento(cur, tv);
                teleController.switchCommand(now_command);
                stack.push(now_command);
                cur += 1;
            } else {
                System.out.println("输入错误!请重新输入!");
            }

            System.out.println("是否要继续检查下一个场地？[-1:退出，0:返回，1:继续]");
            sc = new Scanner(System.in);
            key = sc.next();
        }
        System.out.println("检查场地完毕！");

    }
}
