package olympic.main.drawlots;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;

public class DrawLots {
    ArrayList<Athlete> athletes;
    private DrawLotsImpl impl;

    public DrawLots(ArrayList<Athlete> athletes, DrawLotsImpl impl) {
        this.athletes = athletes;
        this.impl = impl;
    }

    public void drawLotsStart() {
    }

    public void drawLotsEnd() {
    }

    public ArrayList<Athlete> drawLot() {
        drawLotsStart();
        drawLotsEnd();
        return athletes;
    }
}
