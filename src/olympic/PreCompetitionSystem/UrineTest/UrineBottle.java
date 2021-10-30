package olympic.PreCompetitionSystem.UrineTest;

public class UrineBottle {
	private char urineBottles;
	private Boolean isPositive;
	
	public UrineBottle(char c) throws Exception {
		int num = (int) (Math.random() * 100);
		isPositive = false;
		if (c == 'A') {
			urineBottles = c;
			if (num < 5) {
				isPositive = true;
			}
		}
		else if (c == 'B') {
			urineBottles = c;
			if (num < 8) {
				isPositive = true;
			}
		}
		else {
			throw new Exception("尿样只能装入A瓶或B瓶");
		}
	}
	
	public char getUrineBottles() {
		return urineBottles;
	}
	
	public Boolean getPositive() {
		return isPositive;
	}
	
	private UrineTestStrategy urineTestStrategy = null;
	
	public void setUrineTestStrategy(int number){
		UrineTestStrategyFactory urineTestStrategyFactory = UrineTestStrategyFactory.getInstance();
		urineTestStrategy = urineTestStrategyFactory.getUrineTestStrategy(number);
		urineTestStrategy.urineTest();
	}
	
	public UrineTestStrategy getUrineTestStrategy(){
		return urineTestStrategy;
	}
}
