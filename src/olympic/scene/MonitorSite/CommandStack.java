package olympic.scene.MonitorSite;

//管理者：命令栈
class CommandStack {
    private Command command[];
    private int top;
    CommandStack(){
        command=new Command[5];
        top=-1;
    }
    public boolean push(Command p){
        if(top>=4){
            System.out.println("你太花心了，变来变去的！");
            return false;
        }	  else{
            command[++top]=p;
            return true;
        }
    }
    public Command pop(){
        if(top<=0) {
            System.out.println("命令栈空了！");
            return command[0];
        }
        else return command[top--];
    }
}
