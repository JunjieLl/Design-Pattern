package olympic.main.opening.deliverSpeech;


import olympic.Utils.PrintBlockFormat;

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
        if (isOpen()) state = "开幕";
        PrintBlockFormat.getPrintFormat().addString(state+"式演讲");
        PrintBlockFormat.getPrintFormat().addString("classname: (DeliverSpeech) method: (deliverSpeech) action: (" + state + "式演讲流程开始)");
        PrintBlockFormat.getPrintFormat().addString("本次第" + time() + "届奥运会");

        if (isOpen()) {
            PrintBlockFormat.getPrintFormat().addString("运动员代表" + getAthleteRepre() + "进场宣誓");
            getAthleteRepreSpeech();
            PrintBlockFormat.getPrintFormat().addString("裁判员代表" + getCoachRepre() + "进场宣誓");
            getCoachRepreSpeech();
        }

        PrintBlockFormat.getPrintFormat().addString("首先，由本届奥运会组委会主席" + getOOCP() + "讲话");
        getOOCPSpeech();
        PrintBlockFormat.getPrintFormat().addString(getOOCP() + "退场，落座");
        PrintBlockFormat.getPrintFormat().addString("再由国际奥委会主席" + getIOCP() + "讲话");
        getIOCPSpeech();
        PrintBlockFormat.getPrintFormat().addString(getIOCP() + "退场，落座");
        PrintBlockFormat.getPrintFormat().addString("最后由东道主国家元首" + getHP() + "宣布奥运会" + state);
        getHPSpeech();
        PrintBlockFormat.getPrintFormat().addString(getHP() + "退场，落座");
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

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

    /**
     * 获取奥运会组委会主席发言方法
     */
    abstract void getOOCPSpeech();

    /**
     * 获取国际奥委会主席发言方法
     */
    abstract void getIOCPSpeech();

    /**
     * 获取东道主国家元首发言方法
     */
    abstract void getHPSpeech();

    /**
     * 获取运动员代表发言方法
     */
    void getAthleteRepreSpeech()
    {

    };

    /**
     * 获取裁判员代表发言方法
     */
    void getCoachRepreSpeech(){

    };


}

