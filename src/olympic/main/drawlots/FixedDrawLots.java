package olympic.main.drawlots;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;

public class FixedDrawLots extends DrawLots {

    public FixedDrawLots(ArrayList<Athlete> athletes, DrawLotsImpl impl) {
        super(athletes, impl);
    }

    public ArrayList<Athlete> fixedDrawLots(ArrayList<Integer> orders) {
        if (orders.size() != athletes.size()) {
            return null;
        }
        long count = orders.stream().distinct().count();
        if (orders.size() != count) {
            return null;
        }
        ArrayList<Athlete> newArrayList = new ArrayList<>();
        for (int order : orders) {
            if (order > athletes.size()) {
                return null;
            }
            newArrayList.add(athletes.get(order));
        }
        return newArrayList;
    }
}
