package olympic.scene;

import olympic.main.postgame.monitorsite.Command;
import olympic.main.postgame.monitorsite.CommandStack;
import olympic.main.postgame.monitorsite.Monitor;
import olympic.main.postgame.monitorsite.MonitorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("检查场地场景")
public class MonitorSiteSceneTest {

    /**
     * 检查场地函数
     */
    @Test
    void test()
    {
        String[] testString = new String[] {"1","1","1","0","1","1","1","1"};

        /**
         * 创建监视器、遥控器、栈
         */
        Monitor tv = new Monitor();
        MonitorController teleController = new MonitorController();
        CommandStack stack = new CommandStack();

        System.out.println("是否要继续检查下一个场地？[-1:退出，0:返回，1:继续]");
        int cur = 1;
        int i =0;
        String key;
        key = testString[0];
        while (!(key.equals("-1")) && cur <= 6) {
            if (cur == 6 && key.equals("1"))
                break;
            if (key.equals("0")) {

                if (cur > 1) {
                    /**
                     * 恢复状态
                     */
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
            i+=1;
            key = testString[i];
        }
        System.out.println("检查场地完毕！");
    }
}
