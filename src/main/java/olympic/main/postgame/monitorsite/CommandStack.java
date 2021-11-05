package olympic.main.postgame.monitorsite;

/**
 * 设计模式：备忘录模式
 * 管理者：命令栈
 */
public class CommandStack {
    /**
     * 命令数组、栈顶指针
     */
    private Command[] command;
    private int top;

    public CommandStack() {
        command = new Command[100];
        top = -1;
    }

    /**
     * 增添命令，体现备忘录的记录功能
     * @param p 1
     * @return 1
     */
    public boolean push(Command p) {
        if (top >= 100) {
            System.out.println("classname: (CommandStack) method: (push) action: (命令过多，输入错误！)");
            return false;
        } else {
            command[++top] = p;
            return true;
        }
    }

    /**
     * 弹出当前命令，返回上一条命令，进行备忘录的撤销功能
     * @return 返回上一条命令
     */
    public Command pop() {
        if (top <= 0) {
            System.out.println("classname: (CommandStack) method: (pop) action: (Warning:没有上一条命令，继续检查当前场地)");
            return command[0];
        } else return command[--top];
    }
}
