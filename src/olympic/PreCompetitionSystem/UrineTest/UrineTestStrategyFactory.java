package olympic.PreCompetitionSystem.UrineTest;

import java.util.HashMap;

public class UrineTestStrategyFactory {
	private HashMap<Integer, UrineTestStrategy> pool = new HashMap<Integer, UrineTestStrategy>();
	
	private static final UrineTestStrategyFactory singleton = new UrineTestStrategyFactory();
	
	private UrineTestStrategyFactory() {
	
	}
	
	public static UrineTestStrategyFactory getInstance() {
		return singleton;
	}
	
	public synchronized UrineTestStrategy getUrineTestStrategy(int number) {
		UrineTestStrategy urineTestStrategy = pool.get(number);
		if (urineTestStrategy == null) {
			if (number == 3) {
				urineTestStrategy = new ThirdGenerationUrineTestTechnologyStrategy();
			} else {
				urineTestStrategy = new FourthGenerationUrineTestTechnologyStrategy();
			}
			pool.put(number, urineTestStrategy);
		} return urineTestStrategy;
	}
	
}
