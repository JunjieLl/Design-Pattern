package olympic.main.postgame.chores;

public class ChoreGenerating {
    private ChoreComposite composite = new ChoreComposite("所有单元");

    public ChoreGenerating() {
        ChoreComposite securityIssues = new ChoreComposite("安保单元");
        ChoreComposite securityPriorityIssues = new ChoreComposite("安保应急单元");
        ChoreLeaf securityPriorityIssue1 = new ChoreLeaf("护送运动员返回奥运村", 10, 1);
        ChoreLeaf securityPriorityIssue2 = new ChoreLeaf("护送裁判员返回住所", 20, 1);
        ChoreLeaf securityPriorityIssue3 = new ChoreLeaf("驻守运动员更衣室大门", 30, 1);
        securityPriorityIssues.add(securityPriorityIssue1);
        securityPriorityIssues.add(securityPriorityIssue2);
        securityPriorityIssues.add(securityPriorityIssue3);
        securityIssues.add(securityPriorityIssues);
        ChoreLeaf securityIssue1 = new ChoreLeaf("查看监控", 50, 1);
        ChoreLeaf securityIssue2 = new ChoreLeaf("场外巡逻", 30, 1);
        securityIssues.add(securityIssue1);
        securityIssues.add(securityIssue2);

        ChoreComposite cleaningIssues = new ChoreComposite("保洁单元");
        ChoreComposite cleaningPriorityIssues = new ChoreComposite("保洁应急单元");
        ChoreLeaf cleaningPriorityIssue1 = new ChoreLeaf("清理比赛场地", 10, 2);
        ChoreLeaf cleaningPriorityIssue2 = new ChoreLeaf("清理更衣室", 20, 2);
        ChoreLeaf cleaningPriorityIssue3 = new ChoreLeaf("清理场馆卫生间", 30, 2);
        cleaningPriorityIssues.add(cleaningPriorityIssue1);
        cleaningPriorityIssues.add(cleaningPriorityIssue2);
        cleaningPriorityIssues.add(cleaningPriorityIssue3);
        cleaningIssues.add(cleaningPriorityIssues);
        ChoreLeaf cleaningIssue1 = new ChoreLeaf("清理看台", 50, 2);
        cleaningIssues.add(cleaningIssue1);

        ChoreComposite audienceIssues = new ChoreComposite("场务单元");
        ChoreComposite audiencePriorityIssues = new ChoreComposite("场务应急单元");
        ChoreLeaf audiencePriorityIssue1 = new ChoreLeaf("贵宾礼遇", 10, 3);
        ChoreLeaf audiencePriorityIssue2 = new ChoreLeaf("验票系统维护", 20, 3);
        audiencePriorityIssues.add(audiencePriorityIssue1);
        audiencePriorityIssues.add(audiencePriorityIssue2);
        audienceIssues.add(audiencePriorityIssues);
        ChoreLeaf audienceIssue1 = new ChoreLeaf("观众行为监督", 50, 3);
        audienceIssues.add(audienceIssue1);

        ChoreComposite otherIssues = new ChoreComposite("附加单元");
        ChoreLeaf otherIssue1 = new ChoreLeaf("大巴停车场指挥", 50, 4);
        ChoreLeaf otherIssue2 = new ChoreLeaf("地铁站疏导人群", 30, 4);
        otherIssues.add(otherIssue1);
        otherIssues.add(otherIssue2);

        composite.add(securityIssues);
        composite.add(cleaningIssues);
        composite.add(audienceIssues);
        composite.add(otherIssues);

    }

    public ChoreComposite getGaneratedComposite() {
        return composite;
    }
}
