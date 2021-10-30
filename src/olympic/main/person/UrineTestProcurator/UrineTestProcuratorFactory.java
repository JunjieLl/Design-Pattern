package olympic.main.person.UrineTestProcurator;

import olympic.PreCompetitionSystem.UrineTest.FourthGenerationUrineTestTechnologyStrategy;
import olympic.PreCompetitionSystem.UrineTest.ThirdGenerationUrineTestTechnologyStrategy;
import olympic.PreCompetitionSystem.UrineTest.UrineTestStrategy;
import olympic.PreCompetitionSystem.UrineTest.UrineTestStrategyFactory;

import java.util.HashMap;

public class UrineTestProcuratorFactory {
	private HashMap<Integer, UrineTestProcurator> pool = new HashMap<Integer, UrineTestProcurator>();
	
	private static final UrineTestProcuratorFactory singleton = new UrineTestProcuratorFactory();
	
	private UrineTestProcuratorFactory() {
	
	}
	
	public static UrineTestProcuratorFactory getInstance() {
		return singleton;
	}
	
	public synchronized UrineTestProcurator getUrineTestProcurator(int number) {
		UrineTestProcurator urineTestProcurator = pool.get(number);
		if (urineTestProcurator == null) {
			if (number < 26) {
				urineTestProcurator = new UrineTestProcuratorProxy("检察员"
						+ ((char)('A' + number)),"");
			} else {
				urineTestProcurator = new UrineTestProcuratorProxy("检察员" +
						((Integer)(number+1)).toString(),"");
			}
			pool.put(number, urineTestProcurator);
		} return urineTestProcurator;
	}
}
