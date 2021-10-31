package olympic.main.PreCompetitionSystem.UrineTest;

import java.util.HashMap;


public class UrineTestStrategyFactory {
	private HashMap<Integer, UrineTestStrategy> pool = new HashMap<Integer, UrineTestStrategy>();
	private UrineTestStrategy nullStrategy = new NullUrineTestTechnologyStrategy();
	
	private static final UrineTestStrategyFactory singleton = new UrineTestStrategyFactory();
	
	private UrineTestStrategyFactory() {
	
	}
	
	public static UrineTestStrategyFactory getInstance() {
		return singleton;
	}
	
	public synchronized UrineTestStrategy getUrineTestStrategy(int number) {
		if(number!=3 && number !=4){
			return nullStrategy;
		}
		UrineTestStrategy urineTestStrategy = pool.get(number);
		if (urineTestStrategy == null) {
			if (number == 3) {
				urineTestStrategy = new ThirdGenerationUrineTestTechnologyStrategy();
			}
			else if(number ==4) {
				urineTestStrategy = new FourthGenerationUrineTestTechnologyStrategy();
			}
			pool.put(number, urineTestStrategy);
		}
		return urineTestStrategy;
	}
	
}
