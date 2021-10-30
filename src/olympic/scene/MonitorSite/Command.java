package olympic.scene.MonitorSite;

public abstract class Command {
    //命令接收者：监视器
    protected Monitor monitor;

    public Command(Monitor monitor) {
        this.monitor = monitor;
    }

    //命令执行
    abstract void execute();

    public Command getCommand(){
        return this;
    }

}

//播放cctv1的命令
class CCTV1Command extends Command {
    public CCTV1Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playCctv1();
    }
}

//播放cctv2的命令
class CCTV2Command extends Command {
    public CCTV2Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playCctv2();
    }
}

//播放cctv3的命令
class CCTV3Command extends Command {
    public CCTV3Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playCctv3();
    }
}

//播放cctv4的命令
class CCTV4Command extends Command {
    public CCTV4Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playCctv4();
    }
}

//播放cctv5的命令
class CCTV5Command extends Command {
    public CCTV5Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playCctv5();
    }
}

//播放cctv6的命令
class CCTV6Command extends Command {
    public CCTV6Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playCctv6();
    }
}
