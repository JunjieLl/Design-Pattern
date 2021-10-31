package olympic.main.postgame.medaltable;

import olympic.main.person.NameFactory;

public class Country implements Comparable{

    private int goldMedalNum;
    private int silverMedalNum;
    private int bronzeMedalNum;
    private String countryCode;

    public Country(int goldMedalNum, int silverMedalNum, int bronzeMedalNum, String countryCode){
        this.bronzeMedalNum = bronzeMedalNum;
        this.silverMedalNum = silverMedalNum;
        this.goldMedalNum = goldMedalNum;
        this.countryCode = countryCode;
    }

    public String toString() {
        return "国家：" + this.countryCode + "\t金牌数：" + this.goldMedalNum + "\t银牌数：" + this.silverMedalNum + "\t铜牌数：" + this.bronzeMedalNum+ "\t奖牌数：" + (this.goldMedalNum+this.silverMedalNum+this.bronzeMedalNum);
    }




    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        Country p = (Country) o;
        int difference;

        if ((difference = (p.goldMedalNum - this.goldMedalNum)) != 0) {
            return difference;
        } else if ((difference = (p.silverMedalNum - this.silverMedalNum)) != 0) {
            return difference;
        } else if ((difference = (p.bronzeMedalNum - this.bronzeMedalNum)) != 0) {
            return difference;
        }
        return (compareTo(p.getCountryCode(), this.getCountryCode()));
    }

    private int compareTo(String name2, String name3) {
        int s, i = 0;
        if ((s = (name3.charAt(i) - name2.charAt(i))) != 0) {
            return s;
        }
        else {
            i++;
        }
        return 0;
    }

    public String getCountryCode(){
        return this.countryCode;
    }

    public void goldPlusOne() {
        this.goldMedalNum += 1;
    }

    public void silverPlusOne() {
        this.silverMedalNum += 1;
    }

    public void bronzePlusOne() {
        this.bronzeMedalNum += 1;
    }

    public void goldMinusOne() {
        this.goldMedalNum -= 1;
    }

    public void silverMinusOne() {
        this.silverMedalNum -= 1;
    }

    public void bronzeMinusOne() {
        this.bronzeMedalNum -= 1;
    }
}


