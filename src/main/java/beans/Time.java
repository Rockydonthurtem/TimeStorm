package beans;

public class Time {

//	private int Timesheet_id;
	private int Users_id;
	private int Monday;
	private int Tuesday;
	private int Wednesday;
	private int Thursday;
	private int Friday;
	private int Saturday;
	private int Sunday;
	private int Total;
	private int Status;
	
	
	public Time() {
		super();
	}

	public Time(int users_id, int monday, int tuesday, int wednesday, int thursday, int friday,
			int saturday, int sunday, int total, int status) {
		super();
		
//		Timesheet_id = timesheet_id;
		Users_id = users_id;
		Monday = monday;
		Tuesday = tuesday;
		Wednesday = wednesday;
		Thursday = thursday;
		Friday = friday;
		Saturday = saturday;
		Sunday = sunday;
		Total = total;
		Status = status;
	}

//	public int getTimesheet_id() {
//		return Timesheet_id;
//	}
//
//	public void setTimesheet_id(int timesheet_id) {
//		Timesheet_id = timesheet_id;
//	}

	public int getUsers_id() {
		return Users_id;
	}

	public void setUsers_id(int users_id) {
		Users_id = users_id;
	}

	public int getMonday() {
		return Monday;
	}

	public void setMonday(int monday) {
		Monday = monday;
	}

	public int getTuesday() {
		return Tuesday;
	}

	public void setTuesday(int tuesday) {
		Tuesday = tuesday;
	}

	public int getWednesday() {
		return Wednesday;
	}

	public void setWednesday(int wednesday) {
		Wednesday = wednesday;
	}

	public int getThursday() {
		return Thursday;
	}

	public void setThursday(int thursday) {
		Thursday = thursday;
	}

	public int getFriday() {
		return Friday;
	}

	public void setFriday(int friday) {
		Friday = friday;
	}

	public int getSaturday() {
		return Saturday;
	}

	public void setSaturday(int saturday) {
		Saturday = saturday;
	}

	public int getSunday() {
		return Sunday;
	}

	public void setSunday(int sunday) {
		Sunday = sunday;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
	
}
