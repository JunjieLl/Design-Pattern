package olympic.scene.MonitorSite;
/**
 * 设计模式：备忘录模式
 * 管理者：命令栈
 */
public class CommandStack {
    private Command command[];
    private int top;
    public CommandStack(){
        command=new Command[100];
        top=-1;
    }
    public boolean push(Command p){
        if(top>=100){
            System.out.println("classname: (CommandStack) method: (push) action: (命令过多，输入错误！)");
            return false;
        }	  else{
            command[++top]=p;
            return true;
        }
    }
    public Command pop(){
        if(top<=0) {
            System.out.println("classname: (CommandStack) method: (pop) action: (Warning:没有上一条命令，继续检查当前场地)");
            return command[0];
        }
        else return command[--top];
    }
}
