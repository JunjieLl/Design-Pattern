package olympic.main.game.diving;

public class Athlete implements Comparable<Object> {
    private final String name;
    private double preliminaryScore;
    private double semiFinalScore;
    private double finalScore;
    private double curScore;

    Athlete(String name) {
        this.preliminaryScore = 0.0;
        this.semiFinalScore = 0.0;
        this.finalScore = 0.0;
        this.curScore = 0.0;
        this.name = name;
        System.out.println("运动员" + name + "已经入场");
    }

    public void addScore(double score) {
        this.curScore += score;
    }

    public void setPreliminaryScore(double score) {
        this.preliminaryScore = score;
    }

    public void setSemiFinalScore(double score) {
        this.semiFinalScore = score;
    }

    public void setFinalScore(double score) {
        this.finalScore = score;
    }

    public double getCurScore() {
        return this.curScore;
    }

    public void clearCurScore(){
        this.curScore = 0.0;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        if (this.getCurScore() > ((Athlete) o).getCurScore()) {
            return -1;
        } else if (this.getCurScore() == ((Athlete) o).getCurScore()) {
            return 0;
        }
        return 1;
    }
}
