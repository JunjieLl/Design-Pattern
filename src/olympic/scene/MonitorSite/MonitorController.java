package olympic.scene.MonitorSite;
/**
 * 设计模式：命令模式
 * 命令调用者：显示屏幕遥控器
 */
public class MonitorController {

    private Command currentCommand;

    public void switchCommand(Command com) {
        /**
         * currentCommand：当前命令
         * 具体的命令实现
         */
        currentCommand = com;
        com.execute();
    }

    public Command getCommand() {
        return currentCommand;
    }
    /**
     * 设计模式：备忘录模式、命令模式
     * 创建备忘条目
     * @param num 检查场地的序号
     * @param mt 监视屏幕(receiver)
     * @return command
     */
    public Command createMemento(int num,Monitor mt){
        Command mycommand = new Site1Command(mt);
        switch(num){
            case 1:mycommand = new Site1Command(mt);break;
            case 2:mycommand = new Site2Command(mt);break;
            case 3:mycommand = new Site3Command(mt);break;
            case 4:mycommand = new Site4Command(mt);break;
            case 5:mycommand = new Site5Command(mt);break;
            default:{};break;
        }

        return mycommand;
    }
    /**
     * 设计模式：备忘录模式
     * 恢复备忘条目
     * @param p command
     */
    public void restoreMemento(Command p){
        switchCommand(p.getCommand());
    }

}

