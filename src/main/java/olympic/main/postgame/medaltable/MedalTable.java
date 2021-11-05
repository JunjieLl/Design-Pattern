package olympic.main.postgame.medaltable;

import olympic.utils.PrintBlockFormat;
import olympic.main.person.PersonFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 奖牌榜的类
 */
public class MedalTable {
    /**
     * 单例的构造函数
     */
    private static final MedalTable medaltable = new MedalTable();

    /**
     * 奖牌榜上的国家列表
     */
    private final List<Country> countries = new ArrayList<>();

    /**
     * 奖牌榜的构造函数
     */
    private MedalTable() {
        List<String> nationList = PersonFactory.getInstance().getNations();
        for (String currentCountryCode : nationList) {
            countries.add(new Country(0, 0, 0, currentCountryCode));
        }
    }

    /**
     * @return 返回唯一的奖牌榜实例
     */
    public static MedalTable getInstance() {
        return medaltable;
    }

    /**
     * 打印奖牌榜
     */
    public void printMedalTable() {
        List<String> printBlockFormat = new ArrayList<>();
        printBlockFormat.add("奖牌榜");
        printBlockFormat.add("\t"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date(System.currentTimeMillis())));
        Collections.sort(countries);
        countries.stream().map(Country::toString).forEach(printBlockFormat::add);
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(printBlockFormat,true);
    }

    /**
     * 对国家进行惩罚
     *
     * @param countryCode 国家码
     * @param rank 撤销奖牌的类型
     */
    public void penalty(String countryCode, int rank) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                if (rank == 1) {
                    country.goldMinusOne();
                } else if (rank == 2) {
                    country.silverMinusOne();
                } else if (rank == 3) {
                    country.bronzeMinusOne();
                }
            }
        }
    }

    /**
     * 向某国家添加金牌
     *
     * @param countryCode 国家码
     */
    public void addGold(String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                country.goldPlusOne();
            }
        }
    }


    /**
     * 向某国家添加银牌
     *
     * @param countryCode 国家码
     */
    public void addSilver(String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                country.silverPlusOne();
            }
        }
    }

    /**
     * 向某国家添加铜牌
     *
     * @param countryCode 国家码
     */
    public void addBronze(String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                country.bronzePlusOne();
            }
        }
    }

}
