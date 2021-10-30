package olympic.main.person.UrineTestProcurator;

public class UrineTestProcuratorProxy extends UrineTestProcurator{
	protected UrineTestProcuratorProxy(String name, String nation) {
		super(name, nation);
	}
	
	private UrineTestProcuratorReal urineTestProcuratorReal = null;
	
	@Override
	public void check() {
		realize();
		urineTestProcuratorReal.check();
	}
	
	private synchronized void realize(){
		if(urineTestProcuratorReal == null){
			urineTestProcuratorReal = new UrineTestProcuratorReal(name, nation);
		}
	}
}
