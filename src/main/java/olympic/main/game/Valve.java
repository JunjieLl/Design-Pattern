package olympic.main.game;

public abstract class Valve extends Game{
    public abstract Valve setNext(Valve valve);
    public abstract void start();
}
