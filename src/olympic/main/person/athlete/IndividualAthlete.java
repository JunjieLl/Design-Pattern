package olympic.main.person.athlete;

import olympic.PreCompetitionSystem.UrineTest.UrineBottle;
import olympic.PreCompetitionSystem.UrineTest.UrineTestStrategy;
import olympic.PreCompetitionSystem.UrineTest.UrineTestStrategyFactory;
import olympic.main.game.Game;
import olympic.main.person.Person;
import olympic.main.person.UrineTestProcurator.UrineTestProcurator;
import olympic.main.person.UrineTestProcurator.UrineTestProcuratorFactory;

import java.util.ArrayList;

/**
 * 个人运动员，继承自抽象类Person和Athlete接口
 */
public class IndividualAthlete extends Person implements Athlete {
	public IndividualAthlete(String name, String nation) {
		super(name, nation);
	}
	
	@Override
	public void participate(Game game) throws Exception {
		throw new Exception("请指定具体比赛");
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
}