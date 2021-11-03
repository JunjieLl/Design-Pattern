package olympic.main.opening.fireworkshow;

abstract public class Decorator extends Show {
    protected Show show;

    public Decorator(Show show) {
        this.show = show;
    }

    public void operation() {
        show.operation();
    }
}