import java.util.Scanner;
import java.util.Arrays;

class FoodLog {
	private String item;
	private int quantity;
	private String date;
	private String time;
	FoodLog(final String name, final int quantity1, final String date1, String time1) {
		this.item = name;
		this.quantity = quantity1;
		this.date = date1;
		this.time = time1;
	}

	public String getItem() {
		return this.item;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public String getDate() {
		return this.date;
	}

	public String getTime() {
		return this.time;
	}

	public String toString() {
		String s = "";
		s += "Date : " + date + "\n";
		s += "Time : " + time + "\n";
		s += "Name : " + item + "\n";
		s += "Quantity : " + quantity; 
		return s;
	}
} 

class WaterLog {
	private int amount;
	private String date;
	WaterLog(final int water, final String date1) {
		this.amount = water;
		this.date = date1;
	}

	public int getWater() {
		return this.amount;
	}

	public String getDate() {
		return this.date;
	}

	public String toString() {
		String s = "";
		s += "Date : " + date + "\n";
		s += "Quantity : " + amount + "ml"; 
		return s;
	}
}

class Pactivities {
	private String actname;
	private String notes;
	private String date;
	private String stime;
	private String etime;
	Pactivities(final String name, String notes1, final String date1, final String time, final String time1) {
		this.actname = name;
		this.notes = notes1;
		this.date = date1;
		this.stime = time;
		this.etime = time1;
	}

	public String getActName() {
		return this.actname;
	}

	public String getNotes() {
		return this.notes;
	}
	public String getDate() {
		return this.date;
	}

	public String getStartTime() {
		return this.stime;
	}

	public String getEndTime() {
		return this.etime;
	}

	public String toString() {
		String s = "";
		s += "Name : " + actname + "\n";
		s += "Notes : " + notes + "\n";
		s += "Date : " + date + "\n";
		s += "Starttime : " + stime + "\n";
		s += "Endtime : " + etime;
		return s;
	}
}

class SleepLog {
	String date;
	String stime;
	String etime;
	SleepLog(String date1, String stime1, String etime1) {
		this.date = date1;
		this.stime = stime1;
		this.etime = etime1;
	}

	public String getDate() {
		return this.date;
	}

	public String getSTime() {
		return this.stime;
	}

	public String getETime() {
		return this.etime;
	}

	public String toString() {
		String s = "";
		s += "Date : " + date + "\n";
		s += "Starttime : " + stime + "\n";
		s += "Endtime : " + etime;
		return s;
	}
}

class WeightLog {
	String date;
	String time;
	String weight;
	String fat;
	WeightLog(String date1, String time1, String weight1, String fat1) {
		this.date = date1;
		this.time = time1;
		this.weight = weight1;
		this.fat = fat1;
	}

	public String getDateW() {
		return this.date;
	}

	public String getTimeW() {
		return this.time;
	}

	public String getWeight() {
		return this.weight;
	}

	public String getFat() {
		return this.fat;
	}

	public String toString() {
		String s = "";
		s += "Date : " + date + "\n";
		s += "Starttime : " + time + "\n";
		s += "Weight : "+ weight + "\n";
		s += "Fat : " + fat;
		return s;
	}

}
 
class FitByte {
	private List<FoodLog> foodlogs;
	private List<WaterLog> waterlogs;
	private List<Pactivities> pactivities;
	private List<SleepLog> sleeplogs;
	private List<WeightLog> weightlogs;
	FitByte() {
		foodlogs = new List<FoodLog>();
		waterlogs = new List<WaterLog>();
		pactivities = new List<Pactivities>();
		sleeplogs = new List<SleepLog>();
		weightlogs = new List<WeightLog>();
		
	}

	public List<FoodLog> getFood() {
		return foodlogs;
	}

	public List<WaterLog> getWater() {
		return waterlogs;
	}

	public List<Pactivities> getPactivities() {
		return pactivities;
	}

	public List<SleepLog> getSleep() {
		return sleeplogs;
	}

	public List<WeightLog> getWeight() {
		return weightlogs;
	}
	public void addFood(FoodLog food) {
		foodlogs.add(food);
	}

	public void addWater(WaterLog water) {
		waterlogs.add(water);
	}

	public void addSleep(SleepLog sleep) {
		sleeplogs.add(sleep);
	}

	public void addActivity(Pactivities act) {
		pactivities.add(act);
	}

	public void addWeight(WeightLog weight) {
		weightlogs.add(weight);
	}

	public void getSummary() {
		System.out.println("Food");
		System.out.println(getFood());
		System.out.println();

		System.out.println("Water");
		System.out.println(getWater());
		System.out.println();

		System.out.println("PhysicalActivity");
		System.out.println(getPactivities());
		System.out.println();

		System.out.println("Weight");
		System.out.println(getWeight());
		System.out.println();

		System.out.println("Sleep");
		System.out.println(getSleep());
		System.out.println();
	}

	public void getSummaryDt(String date) {
		for (int i = 0; i < foodlogs.size(); i++) {
			if (foodlogs.get(i).getDate().equals(date)) {
				System.out.println(foodlogs.get(i));
			}
		}
		for (int i = 0; i < waterlogs.size(); i++) {
			if (foodlogs.get(i).getDate().equals(date)) {
				System.out.println(waterlogs.get(i));
			}
		}
		for (int i = 0; i < pactivities.size(); i++) {
			if (foodlogs.get(i).getDate().equals(date)) {
				System.out.println(pactivities.get(i));
			}
		}
		for (int i = 0; i < weightlogs.size(); i++) {
			if (foodlogs.get(i).getDate().equals(date)) {
				System.out.println(weightlogs.get(i));
			}
		}
		for (int i = 0; i < sleeplogs.size(); i++) {
			if (foodlogs.get(i).getDate().equals(date)) {
				System.out.println(sleeplogs.get(i));
			}
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FitByte fitbyte = new FitByte();
		while (scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");
			switch (line[0]) {
				case "Food":
					String[] log = line[1].split(",");
					FoodLog food = new FoodLog(log[0],
						Integer.parseInt(log[1]), log[2], log[3]);
					fitbyte.addFood(food);
				break;
				case "Water":
					log = line[1].split(",");
					WaterLog water = new WaterLog(Integer.parseInt(log[0]), log[1]);
					fitbyte.addWater(water);
				break;
				case "PhysicalActivity":
					log = line[1].split(",");
					Pactivities activity = new Pactivities(log[0], log[1],
						log[2], log[3], log[4]);
					fitbyte.addActivity(activity);
				break;
				case "Sleep":
					log = line[1].split(",");
					SleepLog sleep = new SleepLog(log[0], log[1], log[2]);
					fitbyte.addSleep(sleep);
				break;
				case "Weight":
					log = line[1].split(",");
					WeightLog weight = new WeightLog(log[0], log[1], log[2], log[3]);
					fitbyte.addWeight(weight);
				break;
				case "Foodlog":
					System.out.println(fitbyte.getFood());
				break;
				case "Waterlog":
					System.out.println(fitbyte.getWater());
				break;
				case "PhysicalActivitylog":
					if (fitbyte.getPactivities().size() == 0) {
						System.out.println("None");
					} else {
						System.out.println(fitbyte.getPactivities());
					}
				break;
				case "Weightlog":
					System.out.println(fitbyte.getWeight());
				break;
				case "Sleeplog":
					System.out.println(fitbyte.getSleep());
				break;
				case "Summary":
				if (line.length > 1) {
					fitbyte.getSummaryDt(line[1]);
				} else {
					fitbyte.getSummary();
				}
				break;
				default:
				break;
			}
		}
	}
}