package olympic.scene.MonitorSite;

import java.util.ArrayList;
import java.util.List;

// 发起人，监视器
class MonitorController {

    private Command currentCommand;

    public void setCommand(Command com) {
        currentCommand = com;
    }
    public Command getCommand() {
        return currentCommand;
    }
    public Command createMemento(int num,Monitor mt){
        Command mycommand = new CCTV1Command(mt);
        switch(num){
            case 1:mycommand = new CCTV1Command(mt);break;
            case 2:mycommand = new CCTV2Command(mt);break;
            case 3:mycommand = new CCTV3Command(mt);break;
            case 4:mycommand = new CCTV4Command(mt);break;
            case 5:mycommand = new CCTV5Command(mt);break;
            case 6:mycommand = new CCTV6Command(mt);break;
            default:{};break;
        }
        return mycommand;
    }
    public void restoreMemento(Command p){
        setCommand(p.getCommand());
    }

    //播放记录
    List<Command> historyCommand = new ArrayList<Command>();

    //切换卫视
    public void switchCommand(Command command) {
        historyCommand.add(command);
        command.execute();
    }

    //遥控器返回命令
    public void back() {
        if (historyCommand.isEmpty()) {
            return;
        }
        int size = historyCommand.size();
        int preIndex = size-2<=0?0:size-2;

        //获取上一个播放某卫视的命令
        Command preCommand = historyCommand.remove(preIndex);

        preCommand.execute();
    }

}

