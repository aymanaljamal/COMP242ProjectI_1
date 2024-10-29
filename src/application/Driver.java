package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Driver {
	protected static DLinkedList<District> District = new DLinkedList();
//In this method, I search and find the District through while Loop only

	public static District findDistrict(String nameDistrict) {
		if (nameDistrict == null || nameDistrict.isEmpty()) {
			return null;
		}

		DNode<District> curr = District.getHead().getNext();
		while (curr != null) {
			District district = curr.getData();
			if (district != null && district.getDistrictName().equalsIgnoreCase(nameDistrict)) {
				return district;
			}
			curr = curr.getNext();
		}
		return null;
	}

	// In this method, I search and find the Location through TOW while Loop only,
	// and it takes B(n) time
	public static Location findLocation(String districtName, String nameLocation) {
		District District = findDistrict(districtName);
		Node<Location> curr = District.getLocation().getHead().getNext();
		while (curr != null) {
			Location location = curr.getData();
			if (location != null && location.getLocationName().equalsIgnoreCase(nameLocation)) {
				return location;
			}
			curr = curr.getNext();
		}
		return null;

	}

//Because the number of District is small, it can be said that this method does not take a
	// long time. I will consider it to take a fixed amount of time--> Constant.
	public static District insertDistrict(String districtName) {
		if (districtName == null || districtName.isEmpty()) {
			return null;
		}

		District district = findDistrict(districtName);
		if (district == null) {
			district = new District(districtName);

			District.insert(district);
		}

		return district;
	}

//Because adding a location is considered somewhat simple, the search is not done in a large number of
	// District. Only one District is searched and then added their.

	public static Location insertLocation(String districtName, String nameLocation) {
		if (districtName == null || districtName.isEmpty() || nameLocation == null || nameLocation.isEmpty()) {
			return null;
		}

		District district = insertDistrict(districtName);
		if (district == null) {
			return null;
		}

		Location location = findLocation(districtName, nameLocation);
		if (location == null) {
			location = new Location(nameLocation);
			district.getLocation().insert(location);
		}

		return location;
	}

//The location is searched and then this martyr is added. It takes a little
	// time due to the scarcity of villages in one city compared to the number of
	// martyrs.
	public static Martyr insertMartyr(Martyr martyr) {
		if (martyr == null || martyr.getDistrict() == null || martyr.getLocation() == null
				|| martyr.getDistrict().isEmpty() || martyr.getLocation().isEmpty()) {
			return null;
		}

		Location location = insertLocation(martyr.getDistrict(), martyr.getLocation());
		if (location == null) {
			return null;
		}

		location.getMartyr().insert(martyr);
		return martyr;
	}

//A method to delete a District that does not take much time is considered a const
	public static District deleteDistrict(String nameDistrict) {
		if (nameDistrict == null || nameDistrict.isEmpty()) {
			return null;
		}
		District district = findDistrict(nameDistrict);

		if (district != null) {

			return (District) District.delete(district).getData();
		}

		return null;
	}

//Convert string to time using calender
	public static Calendar calendarTimes(String timeString) {
		try {
			String[] time = timeString.split("[,:/ |#]");

			int year = Integer.parseInt(time[2].trim());
			int num1 = Integer.parseInt(time[0].trim());
			int month = num1 - 1;
			int day = Integer.parseInt(time[1].trim());
			Calendar calendar = new GregorianCalendar(year, month, day);

			return calendar;

		}

		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

//Of the martyrs have a specific date of death, which takes a n^3  of time because I am only searching within the martyrs, but the rest is considered
	// small in proportion to the number of martyrs --> much greater than the number
	// of district and the number of Location.
	//
	public static Calendar dateMaximumNumberOfMartyrs(District district) {
		int maxMartyrs = 0;
		Calendar maxDate = null;

		Node<Location> currLocation = district.getLocation().getHead().getNext();
		while (currLocation != null) {

			Node<Martyr> currmartyr = currLocation.getData().getMartyr().getHead().getNext();
			while (currmartyr != null) {
				int dailyMartyrs = 1;
				Calendar currentDate = calendarTimes(currmartyr.getData().getDate());

				while (currmartyr.getNext() != null
						&& calendarTimes(currmartyr.getNext().getData().getDate()).compareTo(currentDate) == 0) {
					dailyMartyrs++;
					currmartyr = currmartyr.getNext();
				}

				if (dailyMartyrs > maxMartyrs) {
					maxMartyrs = dailyMartyrs;
					maxDate = currentDate;
				}

				currmartyr = currmartyr.getNext();
			}

			currLocation = currLocation.getNext();
		}

		return maxDate;
	}

//	The method by which I collect the number of martyrs takes n  time
	public static int totalNumberOfMartyrs(District district) {
		double count = 0;
		Node curr = district.Location.getHead().getNext();
		while (curr != null) {
			if (curr.getData() instanceof Location) {

				Location location = (Location) curr.getData();
				count += location.getMartyr().length();
			}
			curr = curr.getNext();
		}

		return (int) count;
	}

	// The method by which I collect the number of martyrs by gender takes n time by
	// district
	public static int numberOfMaleAndFemaleMartyrs(District district, String Gander) {
		double count = 0;

		Node curr = district.Location.getHead().getNext();

		while (curr != null) {
			try {
				if (curr.getData() instanceof Location) {
					Location location = (Location) curr.getData();
					count += numberMaleAndFemaleMartyrs(location, Gander);

				}
			} catch (Exception e) {

			}
			curr = curr.getNext();
		}
		return (int) count;
	}

//The method by which I collect the number of martyrs by gender takes n time by Location
	public static int numberMaleAndFemaleMartyrs(Location Location, String Gander) {
		double count = 0;

		Location location = Location;
		Node curr = location.Martyr.getHead().getNext();
		while (curr != null) {
			try {
				Martyr martyr = (Martyr) curr.getData();
				if (martyr.getGender().equalsIgnoreCase(Gander)) {
					count++;
				}

			} catch (Exception e) {

			}
			curr = curr.getNext();
		}

		return (int) count;
	}

//A method that calculates the average age of martyred people takes n time by district
	public static int averageMartyrsAges(District District) {
		double totalLocation = 0;
		double averag = 0;
		Node<Location> curr = District.Location.getHead().getNext();

		while (curr != null) {
			Location location = curr.getData();
			averag += AverageMartyrs(location);
			totalLocation++;
			curr = curr.getNext();
		}
		if (averag > 0) {
			return (int) (averag / totalLocation);
		} else {
			return 0;
		}
	}

	// A method calculate the number of people according to the date they were
	// martyred by district takes n time
	public static int getMartyrsDate(District district2, String date) {
		int count = 0;
		if (district2 == null || date == null || date.isEmpty()) {
			return count;
		}

		Node<Location> curr = district2.getLocation().getHead().getNext();

		while (curr != null) {
			Location location = curr.getData();
			if (location != null) {
				Node<Martyr> currMartyr = location.getMartyr().getHead();

				while (currMartyr != null) {
					Martyr martyr = currMartyr.getData();
					if (martyr != null) {
						Calendar targetDate = calendarTimes(date);
						Calendar martyrDate = calendarTimes(martyr.getDate());
						if (targetDate != null && martyrDate != null && targetDate.compareTo(martyrDate) == 0) {
							count++;
						}
					}
					currMartyr = currMartyr.getNext();
				}
			}
			curr = curr.getNext();
		}

		return count;
	}

//A method to delete a Location that does not take much time is considered a const
	public static Location deleteLocation(String nameDistrict, String nameLocation) {
		if (nameDistrict == null || nameDistrict.isEmpty() || nameLocation == null || nameLocation.isEmpty()) {
			return null;
		}
		District district = findDistrict(nameDistrict);
		Location location = findLocation(nameDistrict, nameLocation);

		if (location != null && district != null) {

			return district.getLocation().delete(location).getData();
		}

		return null;
	}

	// A method to deleteMartyr a Location that take n time
	public static Martyr deleteMartyr(Martyr martyr) {
		if (martyr.getDistrict() == null || martyr.getDistrict().isEmpty() || martyr.getLocation() == null
				|| martyr.getLocation().isEmpty()) {
			return null;
		}
		District district = findDistrict(martyr.getDistrict());

		Location location = findLocation(martyr.getDistrict(), martyr.getLocation());
		if (district == null && location == null) {
			return null;
		}
		if (location.getMartyr().delete(martyr) != null) {
			return martyr;
		}
		return null;
	}

	// I am searching for a martyr using this method, but it will take n time,
	// Because I ignore the small time in relation to the number of martyrs
	public static Martyr findMartyr(String nameDistrict, String nameLocation, String name) {
		if (nameDistrict == null || nameDistrict.isEmpty() || nameLocation == null || nameLocation.isEmpty()
				|| nameDistrict.isEmpty() || name == null || name.isEmpty()) {
			return null;
		}
		District district = findDistrict(nameDistrict);
		Location location = findLocation(nameDistrict, nameLocation);
		if (district != null && location != null) {
			Node<Martyr> curr = location.getMartyr().getHead().getNext();
			while (curr != null) {
				if (curr.getData().getName().equalsIgnoreCase(name)) {
					return curr.getData();
				}
				curr = curr.getNext();
			}
		}
		return null;
	}

//The same method as the previous one, but each method has a specific use
	public static Martyr findMartyr(Martyr martyr) {
		if (martyr.getDistrict() == null || martyr.getDistrict().isEmpty() || martyr.getLocation() == null
				|| martyr.getLocation().isEmpty()) {
			return null;
		}
		District district = findDistrict(martyr.getDistrict());
		Location location = findLocation(martyr.getDistrict(), martyr.getLocation());
		if (district != null && location != null) {
			Node<Martyr> curr = location.getMartyr().getHead().getNext();
			while (curr != null) {
				if (curr.getData().getName().equalsIgnoreCase(martyr.getName())) {
					return curr.getData();
				}
				curr = curr.getNext();
			}
		}
		return null;
	}

//To calculate the number of location Martyr
	public static int numberMartyr(Location location) {
		return location.getMartyr().length();

	}

	// A method that calculates the average age of martyred people takes n time by
	// location
	public static int AverageMartyrs(Location location) {
		double totalAge = 0;
		double totalCount = 0;
		Node<Martyr> curr = location.getMartyr().getHead().getNext();

		while (curr != null) {

			Martyr martyr = curr.getData();
			try {
				double age = Double.parseDouble(martyr.getAge());
				totalAge += age;
				totalCount++;
			} catch (NumberFormatException e) {

			} catch (Exception e1) {

			}
			curr = curr.getNext();
		}

		if (totalCount > 0) {
			return (int) (totalAge / totalCount);
		} else {
			return 0;
		}

	}

	// A method through which to calculate the youngest martyr present in const
	// location
	public static int youngest(Location location) {
		if (location == null || location.getMartyr().getHead().getNext() == null) {
			return 0;
		}

		Martyr youngestMartyr = (Martyr) location.getMartyr().getHead().getNext().getData();
		try {
			return Integer.parseInt(youngestMartyr.getAge());
		} catch (NumberFormatException e) {
			return 0;
		} catch (Exception e2) {
			return 0;
		}
	}

//A method through which to calculate the oldest martyr present in one location  takes  const time 
	public static int oldest(Location location) {
		if (location == null || location.getMartyr().getHead().getNext() == null) {
			return 0;
		}

		Node<Martyr> curr = location.getMartyr().getHead().getNext();
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}

		Martyr oldestMartyr = curr.getData();
		try {
			return Integer.parseInt(oldestMartyr.getAge());
		} catch (NumberFormatException e) {
			return 0;
		} catch (Exception e2) {
			return 0;
		}
	}

//A method Through it, you can search for the name of a part of it within a District or Location  takes n time 
	static void search(TextField searchField, TextArea resultTextArea, TextField disField) {
		String name = searchField.getText().trim();
		String namedis = disField.getText().trim();
		if (name.isEmpty()) {
			return;
		}

		District district = findDistrict(namedis);

		Node<Location> curr1 = district.getLocation().getHead().getNext();
		while (curr1 != null) {
			Node<Martyr> curr2 = curr1.getData().getMartyr().getHead().getNext();
			while (curr2 != null) {
				String martyrName = curr2.getData().getName();
				if (martyrName != null && martyrName.contains(name)) {
					resultTextArea.appendText(curr2.getData().toString() + "\n");
				}
				curr2 = curr2.getNext();
			}
			curr1 = curr1.getNext();
		}

	}

}
