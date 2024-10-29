package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LocationScreen {

	static Martyr martyr = new Martyr();
	private static DNode<District> head = Driver.District.getHead().getNext();
	private static Node<Location> curr = head.getData().getLocation().getHead().getNext();
	private static Node<Location> nextLocation = null;

	private static District district = new District();

	public static District getDistrict() {
		return district;
	}

	public static Node<Location> getNextLocation() {
		return nextLocation;
	}

	public static void setNextLocation(Node<Location> nextLocation) {
		LocationScreen.nextLocation = nextLocation;
	}

	

	public static DNode<District> getHead() {
		return head;
	}

	public static void setHead(DNode<District> head) {
		LocationScreen.head = head;
	}

	public static Node<Location> getCurr() {
		return curr;
	}

	public static void setCurr(Node<Location> curr) {
		LocationScreen.curr = curr;
	}

	public static void Location(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		double buttonWidth = 250;
		double buttonHeight = 30;
		Button insertLocation = new Button("𝑰𝑵𝑺𝑬𝑹𝑻 𝑵𝑬𝑾 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵 ");
		TextField textinsertlocation = new TextField();
		textinsertlocation.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝒾𝓃 𝓉ℎ𝒾𝓈 ℴ𝓇𝒹ℯ𝓇 𝒟𝒾𝓈ℯ𝒸𝓇𝒾𝓉,ℒℴ𝒸𝒶𝓉𝒾ℴ𝓃");
		gridPane.add(insertLocation, 0, 0);
		gridPane.add(textinsertlocation, 1, 0);
		insertLocation.setMinWidth(buttonWidth);

		insertLocation.setMinHeight(buttonHeight);

		Button updateLocation = new Button("𝑼𝑷𝑫𝑨𝑻𝑬 𝑨 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵");
		TextField textupdateLocation = new TextField();
		TextField textnewLocation = new TextField();
		textnewLocation.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝓃ℯ𝓌 ℒℴ𝒸𝒶𝓉𝒾ℴ𝓃");
		textupdateLocation.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝒾𝓃 𝓉ℎ𝒾𝓈 ℴ𝓇𝒹ℯ𝓇 𝒟𝒾𝓈ℯ𝒸𝓇𝒾𝓉,ℒℴ𝒸𝒶𝓉𝒾ℴ𝓃");
		gridPane.add(updateLocation, 0, 1);
		gridPane.add(textupdateLocation, 1, 1);
		gridPane.add(textnewLocation, 2, 1);

		updateLocation.setMinWidth(buttonWidth);
		textupdateLocation.setMinWidth(buttonWidth);
		updateLocation.setMinHeight(buttonHeight);
		textupdateLocation.setMinHeight(buttonHeight);
		textnewLocation.setMinHeight(buttonHeight);
		textnewLocation.setMinWidth(buttonWidth);
		Button deleteLocation = new Button("𝑫𝑬𝑳𝑬𝑻𝑬 𝑨 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵");
		TextField textdeleteLocation = new TextField();
		textdeleteLocation.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝒾𝓃 𝓉ℎ𝒾𝓈 ℴ𝓇𝒹ℯ𝓇 𝒟𝒾𝓈ℯ𝒸𝓇𝒾𝓉,ℒℴ𝒸𝒶𝓉𝒾ℴ𝓃");
		gridPane.add(deleteLocation, 0, 2);
		gridPane.add(textdeleteLocation, 1, 2);

		deleteLocation.setMinWidth(buttonWidth);
		textdeleteLocation.setMinWidth(buttonWidth);
		deleteLocation.setMinHeight(buttonHeight);
		textdeleteLocation.setMinHeight(buttonHeight);
		Button InsertMartyr = new Button("𝑰𝑵𝑺𝑬𝑹𝑻 𝑴𝑨𝑹𝑻𝒀𝑹");
		Button deletMartyr = new Button("𝑫𝑬𝑳𝑬𝑻 𝑴𝑨𝑹𝑻𝒀𝑹");
		Button updateMartyr = new Button(" 𝑼𝑷𝑫𝑨𝑻𝑬 𝑴𝑨𝑹𝑻𝒀𝑹");

		Button butCleaning = new Button("𝑪𝑳𝑬𝑨𝑵𝑰𝑵𝑮");
		gridPane.add(InsertMartyr, 0, 3);
		gridPane.add(deletMartyr, 1, 3);
		gridPane.add(updateMartyr, 2, 3);

		InsertMartyr.setMinWidth(buttonWidth);
		butCleaning.setMinWidth(buttonWidth);
		InsertMartyr.setMinHeight(buttonHeight);
		butCleaning.setMinHeight(buttonHeight);
		updateMartyr.setMinHeight(buttonHeight);
		deletMartyr.setMinHeight(buttonHeight);
		updateMartyr.setMinWidth(buttonWidth);
		deletMartyr.setMinWidth(buttonWidth);
		Button goNextLocation = new Button("𝑮𝑶 𝑵𝑬𝑿𝑻 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵");
		Button searchLocation = new Button("𝑺𝑬𝑨𝑹𝑪𝑯 𝑭𝑶𝑹 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵  𝑹𝑬𝑪𝑶𝑹𝑫 𝑩𝒀 𝑯𝑰𝑺 𝑵𝑨𝑴𝑬");
		TextField textsearchLocation = new TextField();
		textsearchLocation.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝒾𝓃 𝓉ℎ𝒾𝓈 ℴ𝓇𝒹ℯ𝓇 𝒟𝒾𝓈ℯ𝒸𝓇𝒾𝓉,ℒℴ𝒸𝒶𝓉𝒾ℴ𝓃");
		textsearchLocation.setMinHeight(buttonHeight);
		textsearchLocation.setMinWidth(buttonWidth);
		searchLocation.setMinWidth(buttonWidth);
		goNextLocation.setMinWidth(buttonWidth);
		goNextLocation.setMinHeight(buttonHeight);
		Label masgLabel = new Label("=======================");
		gridPane.add(goNextLocation, 0, 4);
		gridPane.add(masgLabel, 1, 4);
		gridPane.add(searchLocation, 0, 5);
		gridPane.add(textsearchLocation, 1, 5);
		Label totalMartyrsLabel = new Label("𝑻𝑶𝑻𝑨𝑳 𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑴𝑨𝑹𝑻𝒀𝑹𝑺:");
		TextField texttotalMartyrsLabel = new TextField();
		texttotalMartyrsLabel.setPromptText("=======================");
		Label totalMaleFemaleMartyrsLabel = new Label(
				"𝑻𝑶𝑻𝑨𝑳 𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑴𝑨𝑳𝑬 𝑨𝑵𝑫 𝑭𝑬𝑴𝑨𝑳𝑬 𝑴𝑨𝑹𝑻𝒀𝑹𝑺𝖘:");
		TextField texttotalMaleFemaleMartyrsLabel = new TextField();
		texttotalMaleFemaleMartyrsLabel.setPromptText("=======================");
		Label averageAgeLabel = new Label("𝑨𝑽𝑬𝑹𝑨𝑮𝑬 𝑴𝑨𝑹𝑻𝒀𝑹𝑺 𝑨𝑮𝑬𝑺:");
		TextField textaverageAgeLabel = new TextField();
		textaverageAgeLabel.setPromptText("=======================");
		Label youngestOldestMartyrsLabel = new Label("𝑻𝑯𝑬 𝒀𝑶𝑼𝑵𝑮𝑬𝑺𝑻 𝑨𝑵𝑫 𝑶𝑳𝑫𝑬𝑺𝑻 𝑴𝑨𝑹𝑻𝒀𝑹𝑺:");
		TextField textyoungestOldestMartyrsLabel = new TextField();
		textyoungestOldestMartyrsLabel.setPromptText("=======================");
		Button goback = new Button("𝐆𝐎 𝐁𝐀𝐂𝐊");
		totalMartyrsLabel.setFont(Font.font(15));
		totalMaleFemaleMartyrsLabel.setFont(Font.font(15));
		averageAgeLabel.setFont(Font.font(15));
		youngestOldestMartyrsLabel.setFont(Font.font(15));
		texttotalMartyrsLabel.setMinWidth(buttonWidth);

		texttotalMaleFemaleMartyrsLabel.setMinWidth(buttonWidth);

		textaverageAgeLabel.setMinWidth(buttonWidth);

		textyoungestOldestMartyrsLabel.setMinWidth(buttonWidth);

		texttotalMartyrsLabel.setMinWidth(buttonWidth);

		texttotalMaleFemaleMartyrsLabel.setMinWidth(buttonWidth);

		textaverageAgeLabel.setMinWidth(buttonWidth);

		textyoungestOldestMartyrsLabel.setMinWidth(buttonWidth);

		Button search = new Button("𝑺𝑬𝑨𝑹𝑪𝑯 𝑭𝑶𝑹 𝑴𝑨𝑹𝑻𝒀𝑹 𝑹𝑬𝑪𝑶𝑹𝑫 𝑩𝒀 𝑷𝑨𝑹𝑻 𝑶𝑭 𝑯𝑰𝑺 𝑵𝑨𝑴𝑬");

		searchLocation.setMinHeight(buttonHeight);
		search.setMinHeight(buttonHeight);
		search.setMinWidth(buttonWidth);
		gridPane.add(totalMartyrsLabel, 0, 6);
		gridPane.add(texttotalMartyrsLabel, 1, 6);
		gridPane.add(totalMaleFemaleMartyrsLabel, 0, 7);
		gridPane.add(texttotalMaleFemaleMartyrsLabel, 1, 7);
		gridPane.add(averageAgeLabel, 0, 8);
		gridPane.add(textaverageAgeLabel, 1, 8);
		gridPane.add(youngestOldestMartyrsLabel, 0, 9);
		gridPane.add(textyoungestOldestMartyrsLabel, 1, 9);
		gridPane.add(goback, 2, 10);
		gridPane.add(search, 1, 10);
		searchLocation.setOnAction(e -> {
			try {
				String nameLocationandDisecrit = textsearchLocation.getText().trim();
				String[] info = nameLocationandDisecrit.split(",");
				Location location = Driver.findLocation(info[0], info[1]);

				masgLabel.setText("--> " + info[0] + "--> " + info[1]);
				texttotalMartyrsLabel.setText("--> " + Driver.numberMartyr(location));
				texttotalMaleFemaleMartyrsLabel.setText(" Female= " + Driver.numberMaleAndFemaleMartyrs(location, "F")
						+ " Male= " + Driver.numberMaleAndFemaleMartyrs(location, "M"));
				textaverageAgeLabel.setText("--> " + Driver.AverageMartyrs(location));
				textyoungestOldestMartyrsLabel.setText(
						"--> youngest=" + Driver.youngest(location) + " --> oldest=" + Driver.oldest(location));
			} catch (Exception e2) {
			}

		});
		search.setOnAction(e -> {
			searchByName(primaryStage);
		});
		goback.setOnAction(e -> {

			DistrictScreen.MainScreen(primaryStage);
		});
		insertLocation.setOnAction(e -> {
			try {

				String nameLocationandDisecrit = textinsertlocation.getText().trim();
				String[] info = nameLocationandDisecrit.split(",");
				Driver.insertLocation(info[0], info[1]);
			} catch (Exception e2) {

			}
		});
		updateLocation.setOnAction(e -> {
			try {

				String nameLocationandDisecrit = textupdateLocation.getText().trim();
				String[] info = nameLocationandDisecrit.split(",");
				Location Location = Driver.findLocation(info[0], info[1]);
				if (Location != null) {
					Location.setLocationName(textnewLocation.getText().trim());
				}
			} catch (Exception e2) {

			}
		});
		deleteLocation.setOnAction(e -> {
			try {

				String nameLocationandDisecrit = textdeleteLocation.getText().trim();
				String[] info = nameLocationandDisecrit.split(",");
				Location Location = Driver.findLocation(info[0], info[1]);
				if (Location != null) {
					Driver.deleteLocation(info[0], info[1]);
				}
			} catch (Exception e2) {

			}
		});

		goNextLocation.setOnAction(e -> {
			try {

				if (curr == null || curr.getNext() == null) {
					curr = head.getData().getLocation().getHead().getNext();
				} else {

					curr = curr.getNext();
				}
				nextLocation = curr;

				if (nextLocation != null) {
					Location location = nextLocation.getData();

					masgLabel.setText("--> " + head.getData().getDistrictName() + "--> " + location.getLocationName());
					texttotalMartyrsLabel.setText("--> " + Driver.numberMartyr(location));
					texttotalMaleFemaleMartyrsLabel
							.setText(" Female= " + Driver.numberMaleAndFemaleMartyrs(location, "F") + " Male= "
									+ Driver.numberMaleAndFemaleMartyrs(location, "M"));
					textaverageAgeLabel.setText("--> " + Driver.AverageMartyrs(location));
					textyoungestOldestMartyrsLabel.setText(
							"--> youngest=" + Driver.youngest(location) + " --> oldest=" + Driver.oldest(location));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		InsertMartyr.setOnAction(e -> {
			InsertMartyr(primaryStage);
		});
		deletMartyr.setOnAction(e -> {
			deletMartyr(primaryStage);

		});
		updateMartyr.setOnAction(e -> {
			updateMartyr(primaryStage);
		});
		gridPane.setStyle("-fx-background-color: lightcoral;");
		gridPane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(gridPane, 1000, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void InsertMartyr(Stage Stage) {

		GridPane grid = new GridPane();

		Label lbMessage = new Label("{                     }");
		Label lbMessage2 = new Label("{                     }");

		BorderPane borderPane = new BorderPane();

		Label name = new Label("Name:");
		TextField tfName = new TextField();

		tfName.setPromptText("Enter the name");
		Label age = new Label("Age:");

		TextField tfAge = new TextField();
		tfAge.setPromptText("Enter the Age:");

		Label Location = new Label("Event Location:");

		TextField tfLocation = new TextField();
		tfLocation.setPromptText("Enter the Event Location:");

		Label dateOfDeath = new Label("Date Of Death:");

		TextField tfDateOfDeath = new TextField();
		tfDateOfDeath.setPromptText("Enter the Date Of Death:");

		Label district = new Label("District");

		TextField tfdistrict = new TextField();
		tfdistrict.setPromptText("Enter the District ");

		ToggleGroup genderGroup = new ToggleGroup();

		RadioButton rbMale = new RadioButton("Male");
		rbMale.setToggleGroup(genderGroup);
		rbMale.setSelected(true);
		VBox vbox1 = new VBox(10);

		RadioButton rbFemale = new RadioButton("Female");
		rbFemale.setToggleGroup(genderGroup);

		vbox1.getChildren().addAll(rbMale, rbFemale);
		Label lbPGender = new Label("Gender");

		HBox HBox2 = new HBox(10);
		Button btInsert = new Button("Insert Martyr");
		Button btclen = new Button("       cleaning           ");
		Button goback = new Button("𝐆𝐎 𝐁𝐀𝐂𝐊");

		HBox2.getChildren().addAll(btInsert, lbMessage, lbMessage2);
		grid.add(name, 0, 0);
		grid.add(tfName, 1, 0);
		grid.add(age, 0, 1);
		grid.add(tfAge, 1, 1);
		grid.add(Location, 0, 2);
		grid.add(tfLocation, 1, 2);
		grid.add(dateOfDeath, 0, 3);
		grid.add(tfDateOfDeath, 1, 3);
		grid.add(district, 0, 4);
		grid.add(tfdistrict, 1, 4);

		grid.add(lbPGender, 0, 5);
		grid.add(vbox1, 1, 5);

		grid.add(btclen, 1, 6);
		grid.add(goback, 2, 6);
		borderPane.setCenter(grid);
		borderPane.setBottom(HBox2);
		grid.setHgap(10);
		grid.setVgap(10);

		btclen.setOnAction(e -> {
			tfName.clear();
			tfAge.clear();
			tfLocation.clear();
			tfDateOfDeath.clear();

			lbMessage.setText("");
			lbMessage2.setText("");
		});
		goback.setOnAction(e -> {

			Location(Stage);
		});
		btInsert.setOnAction(e -> {
			Label T = new Label("{         }");

			try {

				String namet = tfName.getText().trim();
				String aget = tfAge.getText().trim();
				String Locationt = tfLocation.getText().trim();
				String dateOfDeatht = tfDateOfDeath.getText().trim();
				String gendert = "";
				String districtt = tfdistrict.getText().trim();

				String[] time1 = dateOfDeatht.split("[,:/ |#]");
				int year = Integer.parseInt(time1[2].trim());
				int month = Integer.parseInt(time1[0].trim());
				int day = Integer.parseInt(time1[1].trim());
				boolean check = true;
				int agen = Integer.parseInt(aget.trim());
				if (year > 2025) {
					lbMessage.setText("Error: year should be 2024 or later.");
					lbMessage.setTextFill(Color.PINK);
					lbMessage.setFont(Font.font(15));
					check = false;
				}

				if (month < 1 || month > 12) {
					lbMessage.setText("Error: month should be between 1 and 12.");
					lbMessage.setTextFill(Color.PINK);
					lbMessage.setFont(Font.font(15));
					check = false;
				}

				if (day < 1 || day > 31) {
					lbMessage.setText("Error: day should be between 1 and 31.");
					lbMessage.setTextFill(Color.PINK);
					lbMessage.setFont(Font.font(15));
					check = false;
				}

				if (rbMale.isSelected()) {
					gendert = "M";
				} else if (rbFemale.isSelected()) {
					gendert = "F";
				}

				if (gendert.isEmpty()) {
					lbMessage2.setText("Gender must be selected.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					check = false;
				}

				if (namet.split(" ").length < 4) {
					lbMessage2.setText("The name must be divided into four parts or more.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					check = false;
				}

				if (agen > 130 || agen < 0) {
					lbMessage2.setText("Age cannot be more than 130 or less than zero.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					check = false;
				}

				Martyr martyr = new Martyr(namet, aget, Locationt, dateOfDeatht, gendert, districtt);

				if (check && Driver.findMartyr(martyr) == null) {

					lbMessage.setText("");
					lbMessage2.setText("");
					Driver.insertMartyr(martyr);
					lbMessage2.setText("{Added successfully!!}"+martyr.toString());
					T.setTextFill(Color.BLACK);
				} else {
					lbMessage2.setText("{Not added successfully!!}");
					lbMessage2.setTextFill(Color.RED);
				}
			} catch (NumberFormatException e2) {
				lbMessage2.setText("{Not added successfully!!}");
				lbMessage2.setTextFill(Color.RED);
			} catch (Exception e2) {
				lbMessage2.setText("{Not added successfully!!!1}");
				lbMessage2.setTextFill(Color.RED);
			}

		});

		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color: lightsalmon;");
		Scene scene = new Scene(borderPane, 500, 500);
		Stage.setTitle("Insert Martyr");
		Stage.setScene(scene);
		Stage.show();
	}

	public static void updateMartyr(Stage Stage) {

		GridPane grid = new GridPane();
		BorderPane borderPane = new BorderPane();
		grid.setPadding(new Insets(50, 50, 50, 50));
		VBox vbox = new VBox(10);
		HBox HBox1 = new HBox(10);
		Label lbMessage = new Label(
				"Write the name of a person, the name of his village, and the name of his city before the update process");
		Button Message = new Button("find");
		TextField tfMessage = new TextField();
		tfMessage.setPromptText("Enter name,Location,District ");
		vbox.getChildren().addAll(lbMessage, HBox1);
		HBox1.getChildren().addAll(Message, tfMessage);
		Button goback = new Button("𝐆𝐎 𝐁𝐀𝐂𝐊");
		HBox1.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		borderPane.setTop(vbox);
		Label lbMessage2 = new Label("{                     }");

		Label name = new Label("Name:");
		TextField tfName = new TextField();

		tfName.setPromptText("Enter the New name");
		Button update1 = new Button("update");
		Label age = new Label("Age:");

		TextField tfAge = new TextField();
		tfAge.setPromptText("Enter the New Age:");
		Button update2 = new Button("update");
		Label Location = new Label("Event Location:");

		TextField tfLocation = new TextField();
		tfLocation.setPromptText("Enter the New Event Location:");
		Button update3 = new Button("update");
		Label dateOfDeath = new Label("Date Of Death:");

		TextField tfDateOfDeath = new TextField();
		tfDateOfDeath.setPromptText("Enter the New Date Of Death:");
		Button update4 = new Button("update");
		Label district = new Label("District");

		TextField tfdistrict = new TextField();
		tfdistrict.setPromptText("Enter the New District ");
		Button update5 = new Button("update");

		ToggleGroup genderGroup = new ToggleGroup();

		RadioButton rbMale = new RadioButton("Male");
		rbMale.setToggleGroup(genderGroup);
		rbMale.setSelected(true);
		VBox vbox1 = new VBox(10);

		RadioButton rbFemale = new RadioButton("Female");
		rbFemale.setToggleGroup(genderGroup);

		vbox1.getChildren().addAll(rbMale, rbFemale);
		Label lbPGender = new Label("Gender");

		Button update6 = new Button("update");

		HBox HBox2 = new HBox(10);

		Button btclen = new Button("       cleaning           ");

		HBox2.getChildren().addAll(lbMessage2);

		grid.add(update1, 0, 0);
		grid.add(name, 1, 0);
		grid.add(tfName, 2, 0);

		grid.add(update2, 0, 1);
		grid.add(age, 1, 1);
		grid.add(tfAge, 2, 1);

		grid.add(update3, 0, 2);
		grid.add(Location, 1, 2);
		grid.add(tfLocation, 2, 2);

		grid.add(update4, 0, 3);
		grid.add(dateOfDeath, 1, 3);
		grid.add(tfDateOfDeath, 2, 3);

		grid.add(update5, 0, 4);
		grid.add(district, 1, 4);
		grid.add(tfdistrict, 2, 4);

		grid.add(update6, 0, 5);
		grid.add(vbox1, 2, 5);
		grid.add(lbPGender, 1, 5);

		grid.add(btclen, 2, 6);
		grid.add(goback, 3, 6);

		borderPane.setCenter(grid);
		borderPane.setBottom(HBox2);
		grid.setHgap(10);
		grid.setVgap(10);
		btclen.setOnAction(e -> {
			tfName.clear();
			tfAge.clear();
			tfLocation.clear();
			tfDateOfDeath.clear();
			tfdistrict.clear();

			tfMessage.clear();
			lbMessage.setText("");
			lbMessage2.setText("");

		});
		goback.setOnAction(e -> {

			Location(Stage);
		});
		Message.setOnAction(e -> {
			try {

				String martyrinformashen = tfMessage.getText().trim();

				String[] informashen = martyrinformashen.split(",");
				martyr = Driver.findMartyr(informashen[2], informashen[1], informashen[0]);
				if (martyr == null) {
					lbMessage2.setText("The process of finding a person with these specifications has failed.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
				} else {
					lbMessage2.setText(martyr.toString());
					lbMessage2.setTextFill(Color.RED);
					lbMessage2.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}
		});

		update1.setOnAction(e -> {
			try {
				boolean ayman = true;
				String newName = tfName.getText().trim();
				if (newName.split(" ").length == 4) {
					lbMessage2.setText("The name must be divided into four parts or more.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					ayman = false;

				}
				if (ayman) {
					martyr.setName(tfName.getText().trim());
					lbMessage2.setText("Updated successfully" + newName);
					lbMessage2.setTextFill(Color.BLUE);
					lbMessage2.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}

		});
		update2.setOnAction(e -> {
			try {
				boolean ayman = true;
				String newAge = tfAge.getText().trim();
				int Agen = Integer.parseInt(newAge);
				if (Agen > 130 || Agen < 0) {
					lbMessage2.setText("Age cannot be more than 130 or less than zero.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					ayman = false;
				} else {
					martyr.setAge(newAge);
					lbMessage2.setText("Updated successfully" + newAge);
					lbMessage2.setTextFill(Color.BLUE);
					lbMessage2.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}
		});
		update3.setOnAction(e -> {
			try {
				boolean ayman = true;
				String newLocation = tfLocation.getText().trim();
				Martyr teampmartyr = martyr;
				if (Driver.deleteMartyr(teampmartyr) != null) {
					martyr.setLocation(newLocation);
					Driver.insertMartyr(martyr);
					lbMessage2.setText("Updated successfully" + newLocation);
					lbMessage2.setTextFill(Color.BLUE);
					lbMessage2.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}

		});
		update5.setOnAction(e -> {
			try {
				String newDistrict = tfdistrict.getText().trim();
				Martyr teampmartyr = martyr;
				if (Driver.deleteMartyr(teampmartyr) != null) {
					martyr.setDistrict(newDistrict);
					Driver.insertMartyr(martyr);
					lbMessage2.setText("Updated successfully" + newDistrict);
					lbMessage2.setTextFill(Color.BLUE);
					lbMessage2.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}
		});
		update4.setOnAction(e -> {
			try {
				boolean ayman = true;
				String newDateOfDeath = tfDateOfDeath.getText().trim();
				String[] time1 = newDateOfDeath.split("[,:/ |#]");
				int year = Integer.parseInt(time1[2].trim());
				int month = Integer.parseInt(time1[0].trim());
				int day = Integer.parseInt(time1[1].trim());

				if (year > 2024) {
					lbMessage2.setText("Error: year should be 2024 or later.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					ayman = false;
				}

				if (month < 1 || month > 12) {
					lbMessage2.setText("Error: month should be between 1 and 12.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					ayman = false;
				}

				if (day < 1 || day > 31) {
					lbMessage2.setText("Error: day should be between 1 and 31.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
					ayman = false;
				}
				if (ayman) {
					martyr.setDate(newDateOfDeath);
					lbMessage2.setText("Updated successfully" + newDateOfDeath);
					lbMessage2.setTextFill(Color.BLUE);
					lbMessage2.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}
		});

		update6.setOnAction(e -> {
			try {
				String newGender = "";
				if (rbMale.isSelected()) {
					newGender = "M";
				} else if (rbFemale.isSelected()) {
					newGender = "F";
				}

				if (newGender.isEmpty()) {
					lbMessage2.setText("Gender must be selected.");
					lbMessage2.setTextFill(Color.PINK);
					lbMessage2.setFont(Font.font(15));
				} else {
					martyr.setGender(newGender);
					lbMessage2.setText(martyr.toString());
				}
			} catch (Exception e2) {
				lbMessage2.setText("The process of finding a person with these specifications has failed.");
			}
		});

		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color: lightyellow;");
		Stage.setTitle("update Martyr ");
		Scene scene = new Scene(borderPane, 700, 600);
		Stage.setScene(scene);
		Stage.show();
	}

	public static void deletMartyr(Stage Stage) {

		GridPane grid = new GridPane();

		HBox HBox2 = new HBox(10);
		Label lbname = new Label("Name:");
		TextField tfName = new TextField();
		tfName.setPromptText("Enter the name");
		Label lbLocation = new Label("Location:");
		TextField tfLocation = new TextField();
		tfLocation.setPromptText("Enter the Location");
		Label lbdistrict = new Label("District:");
		TextField tfdistrict = new TextField();
		tfdistrict.setPromptText("Enter the District");

		Button btdeletMartyr = new Button("Delet");
		Label lbMessage = new Label("{                     }");
		Button goback = new Button("𝐆𝐎 𝐁𝐀𝐂𝐊");
		grid.add(lbname, 0, 0);
		grid.add(tfName, 1, 0);
		grid.add(lbLocation, 0, 1);
		grid.add(tfLocation, 1, 1);
		grid.add(lbdistrict, 0, 2);
		grid.add(tfdistrict, 1, 2);
		grid.add(goback, 1, 4);

		grid.add(HBox2, 0, 3);

		HBox2.getChildren().addAll(btdeletMartyr, lbMessage);
		btdeletMartyr.setOnAction(e -> {
			try {

				Martyr martyr = Driver.findMartyr(tfdistrict.getText().trim(), tfLocation.getText().trim(),
						tfName.getText().trim());
				if (martyr != null && Driver.deleteMartyr(martyr) != null) {

					lbMessage.setText("The deletion was successful");
					lbMessage.setTextFill(Color.BLUE);
					lbMessage.setFont(Font.font(15));
				} else {
					lbMessage.setText("Failed operation");
					lbMessage.setTextFill(Color.PINK);
					lbMessage.setFont(Font.font(15));
				}
			} catch (Exception e2) {
				lbMessage.setText("Failed operation");
				lbMessage.setTextFill(Color.PINK);
				lbMessage.setFont(Font.font(15));
			}

		});

		goback.setOnAction(e -> {

			Location(Stage);
		});
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setPadding(new Insets(50, 50, 50, 50));
		grid.setStyle("-fx-background-color: lightcoral;");
		Scene scene = new Scene(grid, 400, 270);
		Stage.setTitle("delet Martyr");
		Stage.setScene(scene);
		Stage.show();
	}

	public static void searchByName(Stage primaryStage) {

		Button search = new Button("𝑺𝑬𝑨𝑹𝑪𝑯 𝑭𝑶𝑹 𝑴𝑨𝑹𝑻𝒀𝑹 𝑹𝑬𝑪𝑶𝑹𝑫 𝑩𝒀 𝑷𝑨𝑹𝑻 𝑶𝑭 𝑯𝑰𝑺 𝑵𝑨𝑴𝑬");
		Button clear = new Button("𝑪𝑳𝑬𝑨𝑵𝑰𝑵𝑮");
		Button bake = new Button("𝑩𝑨𝑪𝑲");
		TextField searchField = new TextField();
		TextField disField = new TextField();
		TextArea resultTextArea = new TextArea();

		searchField.setPromptText("𝑬𝑵𝑻𝑬𝑹 𝑨 𝑵𝑨𝑴𝑬 𝑶𝑹 𝑷𝑨𝑹𝑻 𝑶𝑭 𝑰𝑻");
		clear.setOnAction(e -> {
			searchField.clear();
			disField.clear();
			resultTextArea.clear();
		});
		bake.setOnAction(e -> {
			Location(primaryStage);
		});

		search.setOnAction(e -> {
			resultTextArea.clear();
			Driver.search(searchField, resultTextArea, disField);

		});
		VBox Vbox = new VBox(10);
		HBox Hbox = new HBox(10);
		double buttonWidth = 250;
		double buttonHeight = 30;
		bake.setMinHeight(buttonHeight);
		bake.setMinWidth(buttonWidth);
		clear.setMinHeight(buttonHeight);
		clear.setMinWidth(buttonWidth);
		search.setMinWidth(buttonWidth);
		search.setMinHeight(buttonHeight);
		disField.setMinWidth(buttonWidth);
		disField.setMinHeight(buttonHeight);
		Hbox.getChildren().addAll(clear, bake);
		Vbox.getChildren().addAll(search, searchField, disField, resultTextArea, Hbox);
		Vbox.setAlignment(Pos.CENTER);
		Hbox.setAlignment(Pos.CENTER);
		Vbox.setStyle("-fx-background-color: lightcoral;");
		primaryStage.setScene(new Scene(Vbox, 500, 500));
		primaryStage.show();
	}

}
