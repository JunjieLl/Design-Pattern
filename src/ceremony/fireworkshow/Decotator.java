package ceremony.fireworkshow;

abstract class Decorator extends Show {
    protected Show show;

    public Decorator(Show show) {
        this.show = show;
    }
    public void operation(){
        show.operation();
    }
}