package olympic.main.postgame.award_ceremony.medal_decorator;

/**
 * 抽象地表示装饰边框的类.
 */
public abstract class Border extends Display {
    protected Display display;

    /**
     * @param display 被装饰物.
     */
    protected Border(Display display){
        this.display = display;
    }
}
