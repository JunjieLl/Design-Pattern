package olympic.main.postgame.monitor_site;
/**
 * 设计模式：命令模式
 * 命令类
 */
public abstract class Command {
    /**
     * 设计模式：命令模式
     * 命令接收者：监视器
     */
    protected Monitor monitor;
    public Command(Monitor monitor) {
        this.monitor = monitor;
    }

    /**
     * 设计模式：命令模式
     * 命令执行函数
     */
    abstract void execute();

    public Command getCommand(){
        return this;
    }

}
/**
 * 检查1号场地的命令
 */

class Site1Command extends Command {
    public Site1Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playSite1();
    }
}
/**
 * 检查2号场地的命令
 */
class Site2Command extends Command {
    public Site2Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playSite2();
    }
}

/**
 * 检查3号场地的命令
 */
class Site3Command extends Command {
    public Site3Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playSite3();
    }
}
/**
 * 检查4号场地的命令
 */
class Site4Command extends Command {
    public Site4Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playSite4();
    }
}
/**
 * 检查5号场地的命令
 */
class Site5Command extends Command {
    public Site5Command(Monitor monitor) {
        super(monitor);
    }

    @Override
    void execute() {
        monitor.playSite5();
    }
}

