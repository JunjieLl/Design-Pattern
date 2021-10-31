package olympic.main.PreCompetitionSystem.UrineTest;

public class ThirdGenerationUrineTestTechnologyStrategy implements UrineTestStrategy{
	@Override
	public void urineTest() {
		System.out.println("采用第3代尿检技术，着重检测化学类兴奋剂。");
	}
	
	@Override
	public boolean isNil() {
		return false;
	}
}
