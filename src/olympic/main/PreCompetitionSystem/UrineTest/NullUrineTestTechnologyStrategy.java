package olympic.main.PreCompetitionSystem.UrineTest;

public class NullUrineTestTechnologyStrategy implements UrineTestStrategy{
	@Override
	public void urineTest() {
		System.out.println("不提供此类尿检方法");
	}
	
	@Override
	public boolean isNil() {
		return true;
	}
}
