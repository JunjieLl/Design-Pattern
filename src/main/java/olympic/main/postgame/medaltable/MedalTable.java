package olympic.main.postgame.medaltable;

import olympic.main.person.PersonFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MedalTable {
    private static final MedalTable medaltable = new MedalTable();
    private final List<Country> countries = new ArrayList<>();

    private MedalTable() {
        List<String> nationList = PersonFactory.getInstance().getNations();
        for (String currentCountryCode : nationList) {
            countries.add(new Country(0, 0, 0, currentCountryCode));
        }
    }

    public static MedalTable getInstance() {
        return medaltable;
    }

    public void printMedalTable() {
        System.out.println("\n========奖牌榜|Medal Table==========\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date(System.currentTimeMillis())));
        Collections.sort(countries);
        countries.stream().map(Country::toString).forEach(System.out::println);
    }

    public void penalty(String countryCode, int rank) {
        for (Country country : countries) {
            if (country.getCountryCode().equals(countryCode)) {
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

    public void addGold(String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equals(countryCode)) {
                country.goldPlusOne();
            }
        }
    }

    public void addSilver(String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equals(countryCode)) {
                country.silverPlusOne();
            }
        }
    }

    public void addBronze(String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equals(countryCode)) {
                country.bronzePlusOne();
            }
        }
    }

}
