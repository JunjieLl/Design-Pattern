package olympic.main.person.athlete;

import olympic.Utils.PrintBlockFormat;
import olympic.main.PreCompetitionSystem.UrineTest.UrineBottle;
import olympic.main.opening.deliverSpeech.Speechable;
import olympic.main.person.athleteList.UrineTestProcurator.UrineTestProcurator;
import olympic.main.person.athleteList.UrineTestProcurator.UrineTestProcuratorFactory;

import java.util.ArrayList;

/**
 * 个人运动员类
 */
public abstract class IndividualAthlete extends Athlete implements Speechable {
    /**
     * 个人运动员类的构造函数
     *
     * @param name   个人运动员的姓名
     * @param nation 个人运动员的国籍
     */
    public IndividualAthlete(String name, String nation) {
        super(name, nation);
    }

    /**
     * 尿样瓶
     */
    private final ArrayList<UrineBottle> urineBottles = new ArrayList<>();

    /**
     * 为运动员添加尿样瓶，最多有两瓶
     *
     * @param c 尿样平的名称（只能为'A'或'B'）
     * @throws Exception 如果给某个运动员添加了超过两个尿检品，则抛出异常提示用户每个运动员最多两个尿检瓶
     */
    public void addUrineBottle(char c) throws Exception {
        if (urineBottles.size() < 2) {
            urineBottles.add(new UrineBottle(c));
        } else {
            throw new Exception("每个运动员最多两个尿检瓶");
        }
    }

    /**
     * 为运动员的某个尿样瓶设置尿检策略
     *
     * @param num               需要修改的尿样瓶下标
     * @param urineTestStrategy 尿检策略
     * @param isPrint 控制是否输出classname语句
     * @return 尿检策略的详情
     */
    public String setUrineTestStrategy(int num, int urineTestStrategy, boolean isPrint) {
        return urineBottles.get(num).setUrineTestStrategy(urineTestStrategy, isPrint);
    }

    /**
     * 获取特定尿样瓶的尿样结果
     *
     * @param num 需要获取的尿样瓶下标
     * @return 如果该尿样通过了尿检，返回true，反之返回false
     */
    public Boolean getUrineTestResult(int num) {
        return !urineBottles.get(num).getPositive();
    }

    /**
     * 为运动员分配的检察员
     */
    UrineTestProcurator urineTestProcurator = null;

    /**
     * 为运动员设置检察员
     *
     * @param isPrint 控制是否输出classname语句
     */
    public void setUrineTestProcurator(boolean isPrint) {
        if (urineTestProcurator == null) {
            int num = (int) (Math.random() * 100);
            UrineTestProcuratorFactory urineTestProcuratorFactory = UrineTestProcuratorFactory.getInstance(isPrint);
            urineTestProcurator = urineTestProcuratorFactory.getUrineTestProcurator(num);
        }
    }

    /**
     * 获取该运动员对应的检察员
     * 
     * @return 尿检检察员
     */
    public UrineTestProcurator getUrineTestProcurator() {
        return urineTestProcurator;
    }

    /**
     * 用户衡量该运动员感染新馆病毒的指标，该指标超过特定值（现在为3）代表运动员没有感染新冠病毒
     */
    double isNovelCoronavirus = -1;

    /**
     * 检查该运动员是否感染新冠病毒
     *
     * @return 如果运动员感染新冠病毒，返回true，反之返回false
     */
    public boolean getIsNovelCoronavirus() {
        if (isNovelCoronavirus == -1) {
            isNovelCoronavirus = (Math.random() * 100);
        }
        return isNovelCoronavirus < 3;
    }

    @Override
    public void update(String content) {
        memory.add(content);
    }

    @Override
    public void passFire() {
        PrintBlockFormat.getPrintFormat().addString("现在正在传递圣火的是来自" + nation + "的" + name + ",现在他将火炬传递给了下一位圣火传递者。");
        //System.out.println("现在正在传递圣火的是来自" + nation + "的" + name + ",现在他将火炬传递给了下一位圣火传递者。");
    }

    public void deliverSpeech() {
        System.out.println("大家好，我是Athlete"+this.getName()+",我会遵守比赛规则！");
    }

}
