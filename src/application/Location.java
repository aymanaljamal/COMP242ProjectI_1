package application;

public class Location implements Comparable<Location> {
	private String LocationName;
	protected LinkedList<Martyr> Martyr;
	

	public Location(String nameLocation) {
		setLocationName(nameLocation);
		this.Martyr = new LinkedList<>();
	}
	public Location( ) {
		
	}
	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		if (locationName.isEmpty()) {
			System.out.println("is empty Location Name ");

		} else {
			LocationName = locationName;
		}

	}

	public LinkedList<Martyr> getMartyr() {
		return Martyr;
	}

	public void setMartyr(LinkedList<Martyr> martyr) {
		Martyr = martyr;
	}

	
	@Override
	public String toString() {
		return "Location is " + LocationName;
	}

	@Override
	public int compareTo(Location o) {

		String DistrictName1 = this.LocationName.replaceAll("'", "").toLowerCase();
		String DistrictName2 = o.LocationName.replaceAll("'", "").toLowerCase();;
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

		return ((Location) obj).getLocationName().equalsIgnoreCase(this.LocationName);
	}

}
