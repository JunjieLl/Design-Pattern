package olympic.main.drawlots;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;

public class RandomDrawLots extends DrawLots{
    public RandomDrawLots(ArrayList<Athlete> athletes, DrawLotsImpl impl) {
        super(athletes, impl);
    }
}
