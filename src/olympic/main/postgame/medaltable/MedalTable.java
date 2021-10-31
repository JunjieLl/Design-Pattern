package olympic.main.postgame.medaltable;

import olympic.main.person.PersonFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MedalTable {
    private static MedalTable medaltable = new MedalTable();
    private List<Country> countries = new ArrayList<Country>();
    private MedalTable(){
        List<String> nationList = PersonFactory.getInstance().getNations();
        for(String currentCountryCode: nationList){
            countries.add(new Country(0,0,0,currentCountryCode));
        }
    }

    public static MedalTable getInstance(){
        return medaltable;
    }

    public void printMedalTable(){
        System.out.println("\n========奖牌榜|Medal Table==========\t"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date(System.currentTimeMillis())));
        Collections.sort(countries);
        for(int i=0;i<countries.size();i++){
            System.out.println(countries.get(i).toString());
        }
    }

    public void penalty(String countryCode, int rank){
        for(int i=0;i<countries.size();i++){
            if(countries.get(i).getCountryCode()==countryCode){
                if(rank ==1){
                    countries.get(i).goldMinusOne();
                }else if(rank==2){
                    countries.get(i).silverMinusOne();
                }else if(rank==3){
                    countries.get(i).bronzePlusOne();
                }
            }
        }
    }

    public void addGold(String countryCode){
        for(Country country: countries){
            if(country.getCountryCode()==countryCode){
                country.goldPlusOne();
            }
        }
    }

    public void addSilver(String countryCode){
        for(Country country: countries){
            if(country.getCountryCode()==countryCode){
                country.silverPlusOne();
            }
        }
    }

    public void addBronze(String countryCode){
        for(Country country: countries){
            if(country.getCountryCode()==countryCode){
                country.bronzePlusOne();
            }
        }
    }

}
