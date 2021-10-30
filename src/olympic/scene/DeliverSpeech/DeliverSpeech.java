package olympic.scene.DeliverSpeech;

abstract class DeliverSpeech {  //抽象类
    /**
     * 设计模式：模板方法模式
     * 钩子方法判断函数
     */

    /**
     * 这里是需要去实例化并赋值的
     */
    public Chairman OOCP;
    public Chairman IOCP;
    public Chairman HP;
//    public Athlete athleteRepre;
//    public Coach coachRepre;

    public abstract boolean isOpen();
    /**
     * 设计模式：模板方法模式
     * 主要发表演讲函数
     */
    void deliverSpeech() {
        String state = "闭幕";
        if(isOpen()) {
            state = "开幕";
        }
        System.out.println("classname: (DeliverSpeech) method: (deliverSpeech) action: ("+state+"式演讲流程开始)");
        System.out.println("本次第" + time()+ "届奥运会");

        if(isOpen()) {
            System.out.println("运动员代表" + athleteRepre()+"进场宣誓");
            System.out.println("裁判员代表" + refereeRepre()+"进场宣誓");
            /* 改过之后的：
            System.out.println("运动员代表" + athleteRepre.name+"进场宣誓");
            athleteRepre.speech();
            System.out.println("裁判员代表" + refereeRepre()+"进场宣誓");
            refereeRepre.speech();
             */
        }

        System.out.println("首先，由本届奥运会组委会主席" + OOCP()+"讲话");

        System.out.println(OOCP()+"退场，落座");
        System.out.println("再由国际奥委会主席" + IOCP()+"讲话");
        System.out.println(IOCP()+"退场，落座");
        System.out.println("最后由东道主国家元首" + HP()+"宣布奥运会"+state);
        System.out.println(HP()+"退场，落座");

        /* 修改后
        System.out.println("首先，由本届奥运会组委会主席" + OOCP.name+"讲话");
        OOCP.speech();
        System.out.println(OOCP.name+"退场，落座");
        System.out.println("再由国际奥委会主席" + IOCP.name+"讲话");
        IOCP.speech();
        System.out.println(IOCP.name+"退场，落座");
        System.out.println("最后由东道主国家元首" + HP.name+"宣布奥运会"+state);
        HP.speech();
        System.out.println(HP()+"退场，落座");
        */

    }
    /**
     * 运动会届数
     */
    abstract String time();
    /**
     * Olympic organizing committee president
     * 奥运会组委会主席
     */
    abstract String OOCP();
    /**
     * IOCP IOC(International Olympic Committee President
     * 国际奥委会主席
     */
    abstract String IOCP();
    /**
     * HP(host president)
     * 东道主国家元首
     */
    abstract String HP();
    /**
     * Athlete Representative
     * 运动员代表
     */
    abstract String athleteRepre();
    /**
     * Referee repersentative
     * 裁判员代表
     */
    abstract String refereeRepre();
}

