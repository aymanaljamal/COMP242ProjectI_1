package application;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class District implements Comparable<District> {
	private String DistrictName;
	protected LinkedList<Location> Location;
	

	 public District(String name) {
	        this.DistrictName = name;
	        this.Location = new LinkedList<>();
	    }
	public District() {
		
	}

	public String getDistrictName() {
		return DistrictName;
	}

	public void setDistrictName(String districtName) {
		if (DistrictName.isEmpty()) {
			System.out.println("is empty District Name ");

		} else {
			DistrictName = districtName;
		}

	}

	public LinkedList<Location> getLocation() {
		return Location;
	}

	public void setLocation(LinkedList<Location> location) {
		Location = location;
	}


	

	@Override
	public String toString() {
		return "District =" + DistrictName;
	}

	@Override
	public int compareTo(District o) {
		String DistrictName1 = this.DistrictName.toLowerCase();
		String DistrictName2 = o.DistrictName.toLowerCase();
		int re = DistrictName1.charAt(0) - DistrictName2.charAt(0);
		if (re > 0) {
			return 1;
		} else if (re < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {

		return ((District) obj).getDistrictName().equalsIgnoreCase(this.DistrictName);
	}
}
