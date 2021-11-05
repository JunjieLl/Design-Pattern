package olympic.main.postgame.medaltable;

import olympic.main.person.NameFactory;

public class Country implements Comparable<Country> {

    private int goldMedalNum;
    private int silverMedalNum;
    private int bronzeMedalNum;
    private final String countryCode;

    public Country(int goldMedalNum, int silverMedalNum, int bronzeMedalNum, String countryCode) {
        this.bronzeMedalNum = bronzeMedalNum;
        this.silverMedalNum = silverMedalNum;
        this.goldMedalNum = goldMedalNum;
        this.countryCode = countryCode;
    }

    public String toString() {
        return "国家：" + NameFactory.getChineseNaitonName(this.countryCode) +"("+ this.countryCode + ")" + "\t金牌数：" + this.goldMedalNum + "\t银牌数：" + this.silverMedalNum + "\t铜牌数：" + this.bronzeMedalNum + "\t奖牌数：" + (this.goldMedalNum + this.silverMedalNum + this.bronzeMedalNum);
    }

    @Override
    public int compareTo(Country o) {
        int difference;
        if ((difference = (o.goldMedalNum - goldMedalNum)) != 0
                || (difference = (o.silverMedalNum - silverMedalNum)) != 0
                || (difference = (o.bronzeMedalNum - bronzeMedalNum)) != 0) {
            return difference;
        }

        return countryCode.compareTo(o.countryCode);
    }



    public String getCountryCode() {
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


