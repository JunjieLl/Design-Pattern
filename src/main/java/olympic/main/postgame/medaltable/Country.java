package olympic.main.postgame.medaltable;

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


