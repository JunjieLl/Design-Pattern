package olympic.main.person.personVisitor;

import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.TeamAthlete;
import olympic.main.person.athleteList.IndividualAthleteList;
import olympic.main.person.athleteList.TeamAthleteList;

import java.util.ArrayList;

public abstract class FilterVisitor {
	public abstract ArrayList<IndividualAthlete> visit(
			IndividualAthleteList individualAthleteList, String gameName);
	
	public abstract ArrayList<TeamAthlete> visit(
			TeamAthleteList teamAthleteList, String gameName);
	
	protected String intToString(int num, int space){
		StringBuilder str = new StringBuilder(((Integer) num).toString());
		int count = (int) StrictMath.log10(num) + 1;
		for (int i=0;i<space-count;i++){
			str.insert(0, " ");
		}
		return str.toString();
	}
}
