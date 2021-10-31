package olympic.main.person.athlete;

import olympic.main.PreCompetitionSystem.UrineTest.UrineBottle;
import olympic.main.person.athleteList.UrineTestProcurator.UrineTestProcurator;
import olympic.main.person.athleteList.UrineTestProcurator.UrineTestProcuratorFactory;

import java.util.ArrayList;

public abstract class IndividualAthlete extends Athlete {
    public IndividualAthlete(String name, String nation) {
        super(name, nation);
    }
    
    private ArrayList<UrineBottle> urineBottles = new ArrayList<>();
    
    public void addUrineBottle(char c) throws Exception {
        if (urineBottles.size() < 2) {
            urineBottles.add(new UrineBottle(c));
        } else {
            throw new Exception("每个运动员最多两个尿检瓶");
        }
    }
    
    public void setUrineTestStrategy(int num, int urineTestStrategy) {
        urineBottles.get(num).setUrineTestStrategy(urineTestStrategy);
    }
    
    public UrineBottle getUrineBottle(int num) {
        return urineBottles.get(num);
    }
    
    public Boolean getUrineTestResult(int num){
        return !urineBottles.get(num).getPositive();
    }
    
    UrineTestProcurator urineTestProcurator = null;
    
    public void setUrineTestProcurator(){
        if(urineTestProcurator == null) {
            int num = (int) (Math.random() * 100);
            UrineTestProcuratorFactory urineTestProcuratorFactory = UrineTestProcuratorFactory.getInstance();
            urineTestProcurator = urineTestProcuratorFactory.getUrineTestProcurator(num);
        }
    }
    
    public UrineTestProcurator getUrineTestProcurator() {
        return urineTestProcurator;
    }

    @Override
    public void update(String content) {
        
    }

    @Override
    public void passFire() {
        System.out.println("现在正在传递圣火的是来自"+nation+"的"+name+",现在他将火炬传递给了下一位圣火传递者。");
    }
}
