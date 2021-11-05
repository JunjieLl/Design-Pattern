package olympic.main.postgame.medaltable;

import olympic.main.person.NameFactory;

/**
 * 奖牌榜上的国家类
 */
public class Country implements Comparable<Country> {

    /**
     * 该国家金牌数
     */
    private int goldMedalNum;

    /**
     * 该国家银牌数
     */
    private int silverMedalNum;

    /**
     * 该国家铜牌数
     */
    private int bronzeMedalNum;

    /**
     * 该国家三字码名称
     */
    private final String countryCode;

    /**
     * 国家项构造函数
     *
     * @param goldMedalNum   金牌数
     * @param silverMedalNum 银牌数
     * @param bronzeMedalNum 铜牌数
     * @param countryCode    名称
     */
    public Country(int goldMedalNum, int silverMedalNum, int bronzeMedalNum, String countryCode) {
        this.bronzeMedalNum = bronzeMedalNum;
        this.silverMedalNum = silverMedalNum;
        this.goldMedalNum = goldMedalNum;
        this.countryCode = countryCode;
    }

    /**
     * @return 国家项转换为字符串
     */
    public String toString() {
        return String.format(("国家：%-22s" + "\t金牌数：" + this.goldMedalNum + "\t银牌数：" + this.silverMedalNum + "\t铜牌数：" + this.bronzeMedalNum + "\t奖牌数：" + (this.goldMedalNum + this.silverMedalNum + this.bronzeMedalNum)), NameFactory.getChineseNaitonName(this.countryCode) + "(" + this.countryCode + ")");
    }

    /**
     * 国家项的比较函数
     *
     * @param o 括号中的国家对象
     * @return 对比结果
     */
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


    /**
     * @return 该国家名称
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * 金牌数加一
     */
    public void goldPlusOne() {
        this.goldMedalNum += 1;
    }

    /**
     * 银牌数加一
     */
    public void silverPlusOne() {
        this.silverMedalNum += 1;
    }

    /**
     * 铜牌数加一
     */
    public void bronzePlusOne() {
        this.bronzeMedalNum += 1;
    }

    /**
     * 金牌数减一
     */
    public void goldMinusOne() {
        this.goldMedalNum -= 1;
    }

    /**
     * 银牌数减一
     */
    public void silverMinusOne() {
        this.silverMedalNum -= 1;
    }

    /**
     * 铜牌数减一
     */
    public void bronzeMinusOne() {
        this.bronzeMedalNum -= 1;
    }
}

