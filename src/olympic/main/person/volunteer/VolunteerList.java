package olympic.main.person.volunteer;

import java.util.ArrayList;

public class VolunteerList {
	ArrayList<Volunteer> volunteers = new ArrayList<>();
	
	int count = 0;
	int allCount = 100;
	
	private static final VolunteerList singleton = new VolunteerList();
	
	private VolunteerList() {
		for (int i = 0; i < allCount; i++) {
			volunteers.add(new Volunteer("志愿者" + i, ""));
		}
	}
	
	public static VolunteerList getInstance() {
		return singleton;
	}
	
	public ArrayList<Volunteer> allocateVolunteer(int num) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("> 协助该场比赛的志愿者共有" + num + "人，他们分别为：");
		ArrayList<Volunteer> volunteersSelect = new ArrayList<>();
		int tempAll = allCount;
		for (int i = count; i < allCount; ) {
			i = (i + 1) % allCount;
			tempAll -= 1;
			if (volunteers.get(i).allocateWork()) {
				volunteersSelect.add(volunteers.get(i));
				num -= 1;
			}
			if(tempAll<=0 || num <=0){
				break;
			}
		}
		for(int i=0;i<volunteersSelect.size();i++){
			System.out.print("> "+volunteersSelect.get(i).getName());
			volunteersSelect.get(i).changeStateToExpert();
		}
		return volunteersSelect;
	}
}
