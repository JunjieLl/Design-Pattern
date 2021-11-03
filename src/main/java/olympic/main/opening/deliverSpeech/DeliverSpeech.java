package olympic.main.opening.deliverSpeech;

abstract class DeliverSpeech {  //抽象类
    /**
     * 设计模式：模板方法模式
     * 钩子方法判断函数
     */
    public abstract boolean isOpen();

    /**
     * 设计模式：模板方法模式
     * 主要发表演讲函数
     */
    public void deliverSpeech() {
        String state = "闭幕";
        if (isOpen()) {
            state = "开幕";
        }
        System.out.println("classname: (DeliverSpeech) method: (deliverSpeech) action: (" + state + "式演讲流程开始)");
        System.out.println("本次第" + time() + "届奥运会");

        if (isOpen()) {
            System.out.println("运动员代表" + getAthleteRepre() + "进场宣誓");
            System.out.println("裁判员代表" + getCoachRepre() + "进场宣誓");

        }

        System.out.println("首先，由本届奥运会组委会主席" + getOOCP() + "讲话");

        System.out.println(getOOCP() + "退场，落座");
        System.out.println("再由国际奥委会主席" + getIOCP() + "讲话");
        System.out.println(getIOCP() + "退场，落座");
        System.out.println("最后由东道主国家元首" + getHP() + "宣布奥运会" + state);
        System.out.println(getHP() + "退场，落座");
    }

    /**
     * 运动会届数
     */
    abstract String time();

    /**
     * Olympic organizing committee president
     * 奥运会组委会主席
     */
    abstract String getOOCP();

    /**
     * IOCP IOC(International Olympic Committee President
     * 国际奥委会主席
     */
    abstract String getIOCP();

    /**
     * HP(host president)
     * 东道主国家元首
     */
    abstract String getHP();

    /**
     * Athlete Representative
     * 运动员代表
     */
    abstract String getAthleteRepre();

    /**
     * Referee repersentative
     * 裁判员代表
     */
    abstract String getCoachRepre();
}

