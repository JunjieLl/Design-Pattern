package olympic.main.person.athletelist.urinetestprocurator;

/**
 * 尿检检察员的代理类，具体使用时，我们先生成代理类，只有在需要使用到check函数时，才会生成真实的尿检检察员类。
 * 这样做采用了代理模式的设计模式，可以用于减少系统的加载（尿检检察员）时间。
 */
public class UrineTestProcuratorProxy extends UrineTestProcurator {
    /**
     * 尿检检察员代理类的构造函数
     *
     * @param name   尿检检察员的名字
     * @param nation 尿检检察员的国籍
     */
    protected UrineTestProcuratorProxy(String name, String nation) {
        super(name, nation);
    }
    
    /**
     * 尿检检察员真实的类，刚开始时为null，只有在使用到该类的check函数时才会去生成
     */
    private UrineTestProcuratorReal urineTestProcuratorReal = null;
    
    /**
     * 尿检检察员（代理类）检查运动员的函数。使用时如果此时尿检检察员的真实类为null，则先生成该类。
     * 然后使用尿检检察员的真实类检查运动员
     *
     * @param isPrint 控制是否输出classname语句
     * @return 表示检察员检查的结果
     */
    @Override
    public String  check(boolean isPrint) {
        if(isPrint) {
            System.out.println("classname: (UrineTestProcuratorProxy) method: (check) " + "action: (检察员代理类生成真正的检察员，并让真正的检察员检查运动员，使用了Proxy模式) ");
        }
        realize(isPrint);
        return urineTestProcuratorReal.check(isPrint);
    }
    
    /**
     * 用于生成尿检检察员的真实类（如果此时尿检检察员真实类为null）。如果此时尿检检察员真实类不为null，
     * 则不做任何操作
     *
     * @param isPrint 控制是否输出classname语句
     */
    private synchronized void realize(boolean isPrint) {
        if(isPrint) {
            System.out.println("classname: (UrineTestProcuratorProxy) method: (realize) " + "action: (检察员代理类生成真正的检察员，使用了Proxy模式) ");
        }
        if (urineTestProcuratorReal == null) {
            urineTestProcuratorReal = new UrineTestProcuratorReal(name, nation);
        }
    }
}
