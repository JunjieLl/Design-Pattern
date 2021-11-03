package olympic.main.postgame.chores;

/**
 * 解决问题的类.
 */
public abstract class Support {
    private String name;
    private Support next;
    public Support(String name){
        this.name = name;
    }

    public Support setNext(Support next){
        this.next = next;
        return next;
    }

    public final void support(ChoreLeaf choreleaf){
        if(resolve(choreleaf)){
            done(choreleaf);
        }else if(next!=null){
            next.support(choreleaf);
        }else{
            fail(choreleaf);
        }
    }

    public String toString(){
        return "【"+name+"】";
    }

    protected abstract boolean resolve(ChoreLeaf choreleaf);

    protected void done(ChoreLeaf choreleaf){
        System.out.println("\nclassname: (Support) method: (done) action: (显示具体的杂务解决情况) ");
        System.out.println(choreleaf.getName()+"已被【"+name+"】解决。");
    }

    protected void fail(ChoreLeaf choreleaf){
        System.out.println("\nclassname: (Support) method: (fail) action: (显示经过责任链后无法解决的杂务) ");
        System.out.println(choreleaf.getName()+"暂不能被解决");
    }
}
