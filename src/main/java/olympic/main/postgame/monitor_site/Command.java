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

    /**
     * 命令构造函数
     * @param monitor 1
     */
    public Command(Monitor monitor) {
        this.monitor = monitor;
    }

    /**
     * 设计模式：命令模式
     * 命令执行函数
     */
    abstract void execute();

    /**
     * 获取命令
     * @return this
     */
    public Command getCommand() {
        return this;
    }

}

/**
 * 检查1号场地的命令封装
 */
class Site1Command extends Command {
    /**
     * 1号场地监视命令
     * @param monitor 1
     */
    public Site1Command(Monitor monitor) {
        super(monitor);
    }

    /**
     * 命令执行函数
     */
    @Override
    void execute() {
        monitor.playSite1();
    }
}

/**
 * 检查2号场地的命令封装
 */
class Site2Command extends Command {
    /**
     * 2号场地监视命令
     * @param monitor 1
     */
    public Site2Command(Monitor monitor) {
        super(monitor);
    }
    /**
     * 命令执行函数
     */
    @Override
    void execute() {
        monitor.playSite2();
    }
}

/**
 * 检查3号场地的命令封装
 */
class Site3Command extends Command {
    /**
     * 3号场地监视命令
     * @param monitor 1
     */
    public Site3Command(Monitor monitor) {
        super(monitor);
    }
    /**
     * 命令执行函数
     */
    @Override
    void execute() {
        monitor.playSite3();
    }
}

/**
 * 检查4号场地的命令封装
 */
class Site4Command extends Command {
    /**
     * 4号场地监视命令
     * @param monitor 1
     */
    public Site4Command(Monitor monitor) {
        super(monitor);
    }
    /**
     * 命令执行函数
     */
    @Override
    void execute() {
        monitor.playSite4();
    }
}

/**
 * 检查5号场地的命令封装
 */
class Site5Command extends Command {
    /**
     * 5号场地监视命令
     * @param monitor 1
     */
    public Site5Command(Monitor monitor) {
        super(monitor);
    }
    /**
     * 命令执行函数
     */
    @Override
    void execute() {
        monitor.playSite5();
    }
}

