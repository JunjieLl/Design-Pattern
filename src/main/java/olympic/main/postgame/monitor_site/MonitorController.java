package olympic.main.postgame.monitor_site;

/**
 * 设计模式：命令模式
 * 命令调用者：显示屏幕遥控器
 */
public class MonitorController {
    /**
     * 记录当前命令
     */
    private Command currentCommand;

    /**
     * 更换命令的执行
     * @param com 1
     */
    public void switchCommand(Command com) {

        currentCommand = com;
        com.execute();
    }

    /**
     * 设计模式：备忘录模式、命令模式
     * 创建备忘条目
     *
     * @param num 检查场地的序号
     * @param mt  监视屏幕(receiver)
     * @return command
     */
    public Command createMemento(int num, Monitor mt) {
        Command mycommand = new Site1Command(mt);
        switch (num) {
            case 1:
                mycommand = new Site1Command(mt);
                break;
            case 2:
                mycommand = new Site2Command(mt);
                break;
            case 3:
                mycommand = new Site3Command(mt);
                break;
            case 4:
                mycommand = new Site4Command(mt);
                break;
            case 5:
                mycommand = new Site5Command(mt);
                break;
            default: {
            }

            break;
        }

        return mycommand;
    }

    /**
     * 设计模式：备忘录模式
     * 恢复备忘条目
     *
     * @param p command
     */
    public void restoreMemento(Command p) {
        switchCommand(p.getCommand());
    }

}

