package application;

import java.util.Calendar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DistrictScreen {

	private static DNode<District> head = Driver.District.getHead();
	private static DNode<District> curr = head;
	private static DNode<District> prev = null;

	public static void district(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20, 50, 20, 50));

		Label masgg = new Label("");
		double buttonWidth = 250;
		double buttonHeight = 30;
		BorderPane borderPane = new BorderPane();
		Button insertDistrict = new Button("𝑰𝑵𝑺𝑬𝑹𝑻 𝑵𝑬𝑾 𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻");
		TextField textInsertDistrict = new TextField();
		textInsertDistrict.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝒩ℯ𝓌 𝒟𝒾𝓈𝓉𝓇𝒾𝒸𝓉");
		gridPane.add(insertDistrict, 0, 0);
		gridPane.add(textInsertDistrict, 1, 0);
		insertDistrict.setMinWidth(buttonWidth);
		textInsertDistrict.setMinWidth(buttonWidth);
		insertDistrict.setMinHeight(buttonHeight);
		textInsertDistrict.setMinHeight(buttonHeight);

		Button updateDistrict = new Button("𝑼𝑷𝑫𝑨𝑻𝑬 𝑨 𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻");
		TextField textUpdateDistrict = new TextField();

		textUpdateDistrict.setPromptText("ℰ𝓃𝓉ℯ𝓇 𝒩ℯ𝓌 𝒟𝒾𝓈𝓉𝓇𝒾𝒸𝓉");
		gridPane.add(updateDistrict, 0, 1);
		gridPane.add(textUpdateDistrict, 1, 1);

		updateDistrict.setMinWidth(buttonWidth);
		textUpdateDistrict.setMinWidth(buttonWidth);

		updateDistrict.setMinHeight(buttonHeight);
		textUpdateDistrict.setMinHeight(buttonHeight);

		Button deleteDistrict = new Button("𝗗𝗘𝗟𝗘𝗧𝗘 𝗔 𝗗𝗜𝗦𝗧𝗥𝗜𝗖𝗧");
		TextField textDeleteDistrict = new TextField();
		textDeleteDistrict.setPromptText("𝑬𝑵𝑻𝑬𝑹 𝑻𝑯𝑬 𝑶𝑳𝑫 𝑵𝑨𝑴𝑬, 𝑵𝑬𝑾 𝗗𝗜𝗦𝗧𝗥𝗜𝗖𝗧 𝑵𝑨𝑴𝑬");
		gridPane.add(deleteDistrict, 0, 2);
		gridPane.add(textDeleteDistrict, 1, 2);
		deleteDistrict.setMinWidth(buttonWidth);
		textDeleteDistrict.setMinWidth(buttonWidth);
		deleteDistrict.setMinHeight(buttonHeight);
		textDeleteDistrict.setMinHeight(buttonHeight);

		Button goNextDistrict = new Button("𝑮𝑶 𝑵𝑬𝑿𝑻 𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻");
		Button goPreviousDistrict = new Button("𝑮𝑶 𝑷𝑹𝑬𝑽𝑰𝑶𝑼𝑺 𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻");
		gridPane.add(goPreviousDistrict, 0, 3);
		gridPane.add(goNextDistrict, 1, 3);

		goNextDistrict.setMinWidth(buttonWidth);
		goPreviousDistrict.setMinWidth(buttonWidth);
		goNextDistrict.setMinHeight(buttonHeight);
		goPreviousDistrict.setMinHeight(buttonHeight);

		Label totalMartyrsLabel = new Label("𝑻𝑶𝑻𝑨𝑳 𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑴𝑨𝑹𝑻𝒀𝑹𝑺:");
		totalMartyrsLabel.setFont(Font.font(15));
		gridPane.add(totalMartyrsLabel, 0, 4);
		TextField totalMartyrsField = new TextField();
		totalMartyrsField.setPromptText("=======================");
		totalMartyrsField.setEditable(false);
		gridPane.add(totalMartyrsField, 1, 4);
		totalMartyrsField.setMinWidth(buttonWidth);
		totalMartyrsField.setMinHeight(buttonHeight);

		Label maleMartyrsLabel = new Label("𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑴𝑨𝑳𝑬:");
		maleMartyrsLabel.setFont(Font.font(15));
		gridPane.add(maleMartyrsLabel, 0, 5);
		TextField maleMartyrsField = new TextField();
		maleMartyrsField.setPromptText("=======================");
		maleMartyrsField.setEditable(false);
		gridPane.add(maleMartyrsField, 1, 5);
		maleMartyrsField.setMinWidth(buttonWidth);
		maleMartyrsField.setMinHeight(buttonHeight);

		Label femaleMartyrsLabel = new Label("𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑭𝑬𝑴𝑨𝑳𝑬:");
		femaleMartyrsLabel.setFont(Font.font(15));
		gridPane.add(femaleMartyrsLabel, 0, 6);
		TextField femaleMartyrsField = new TextField();
		femaleMartyrsField.setPromptText("=======================");
		femaleMartyrsField.setEditable(false);
		gridPane.add(femaleMartyrsField, 1, 6);
		femaleMartyrsField.setMinWidth(buttonWidth);
		femaleMartyrsField.setMinHeight(buttonHeight);

		Label avgAgeLabel = new Label("𝑨𝑽𝑬𝑹𝑨𝑮𝑬 𝑴𝑨𝑹𝑻𝒀𝑹𝑺 𝑨𝑮𝑬𝑺:");
		avgAgeLabel.setFont(Font.font(15));
		gridPane.add(avgAgeLabel, 0, 7);
		TextField avgAgeField = new TextField();
		avgAgeField.setPromptText("=======================");
		avgAgeField.setEditable(false);
		gridPane.add(avgAgeField, 1, 7);
		avgAgeField.setMinWidth(buttonWidth);
		avgAgeField.setMinHeight(buttonHeight);

		Label maxDateLabel = new Label(
				"𝑫𝑨𝑻𝑬 𝑻𝑯𝑨𝑻 𝑯𝑨𝑺 𝑻𝑯𝑬 𝑴𝑨𝑿𝑰𝑴𝑼𝑴 𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑴𝑨𝑹𝑻𝒀𝑹𝑺:");

		maxDateLabel.setFont(Font.font(15));
		gridPane.add(maxDateLabel, 0, 8);
		TextField maxDateField = new TextField();
		maxDateField.setEditable(false);
		maxDateField.setPromptText("=======================");
		gridPane.add(maxDateField, 1, 8);

		maxDateField.setMinWidth(buttonWidth);
		maxDateField.setMinHeight(buttonHeight);
		Button goback = new Button("𝐆𝐎 𝐁𝐀𝐂𝐊");

		HBox hBOX = new HBox(10);
		HBox hBOX2 = new HBox(10);
		VBox VBOX = new VBox(10);
		Button districttolocation = new Button(
				" 𝑻𝑶 𝑳𝑶𝑨𝑫 𝑻𝑯𝑬 𝑭𝑰𝑹𝑺𝑻 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵 𝑰𝑵 𝑻𝑯𝑰𝑺 𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻 𝑻𝑶 𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵 𝑺𝑪𝑹𝑬𝑬𝑵.");
		Button totalnumbermartyrsd = new Button(
				"𝑻𝑶𝑻𝑨𝑳 𝑵𝑼𝑴𝑩𝑬𝑹 𝑶𝑭 𝑴𝑨𝑹𝑻𝒀𝑹𝑺 𝑭𝑶𝑹 𝑨 𝑮𝑰𝑽𝑬𝑵 𝑫𝑨𝑻𝑬.");
		TextField totalnumbermartyrsdField = new TextField();
		totalnumbermartyrsdField.setPromptText("𝑰𝑵 𝑻𝑯𝑰𝑺 𝑶𝑹𝑫𝑬𝑹: 𝑫𝑰𝑺𝑪𝑹𝑬𝑬𝑻, 𝑻𝑯𝑬𝑵 𝑫𝑨𝑻𝑬");
		Label totalnumbermartyrsdFielL = new Label(" ");
		totalnumbermartyrsd.setMinWidth(buttonWidth);
		totalnumbermartyrsdField.setMinWidth(buttonWidth);
		totalnumbermartyrsd.setMinHeight(buttonHeight);
		totalnumbermartyrsdField.setMinHeight(buttonHeight);
		hBOX2.getChildren().addAll(districttolocation, goback);
		hBOX.getChildren().addAll(totalnumbermartyrsd, totalnumbermartyrsdField, totalnumbermartyrsdFielL);
		VBOX.getChildren().addAll(hBOX, hBOX2, masgg);
		Label namedis = new Label("{    }");
		gridPane.add(namedis, 2, 3);

		borderPane.setBottom(VBOX);

		goback.setOnAction(e -> {

			DistrictScreen.MainScreen(primaryStage);
		});
		insertDistrict.setOnAction(e -> {
			try {

				String newDistrict = textInsertDistrict.getText().trim();
				if (Driver.insertDistrict(newDistrict) != null) {
					masgg.setText("Added successfully--> " + newDistrict);
				} else {
					masgg.setText("There error");
				}
			} catch (Exception e2) {
				masgg.setText("There error");
			}
		});
		updateDistrict.setOnAction(e -> {

			try {

				String[] info = textUpdateDistrict.getText().trim().split(",");
				String oldDistrict = info[0];

				String newDistrict = info[1];
				if (Driver.findDistrict(oldDistrict) != null) {
					District district = Driver.findDistrict(oldDistrict);
					Driver.deleteDistrict(oldDistrict);

					district.setDistrictName(newDistrict);
					Driver.District.insert(district);
					masgg.setText("Updated successfully to--> " + newDistrict + " from--> " + oldDistrict);
				} else {
					masgg.setText("There error");
				}
			} catch (Exception e2) {
				masgg.setText("There error");
			}
		});
		deleteDistrict.setOnAction(e -> {
			try {

				String deleteDistrict1 = textDeleteDistrict.getText().trim();

				if (Driver.deleteDistrict(deleteDistrict1) != null) {

					masgg.setText("Deleted successfully --> " + deleteDistrict1);
				}
			} catch (Exception e2) {
				masgg.setText("There error");
			}

		});
		goNextDistrict.setOnAction(e -> {
			try {

				if (curr == null || curr.getNext() == null) {
					curr = head;
				} else {
					prev = curr;
					curr = curr.getNext();
				}

				if (curr != null) {
					District district = curr.getData();
					namedis.setText("---->" + district.getDistrictName());
					totalMartyrsField.setText("---> " + Driver.totalNumberOfMartyrs(district));
					maleMartyrsField.setText("---> " + Driver.numberOfMaleAndFemaleMartyrs(district, "M"));
					femaleMartyrsField.setText("---> " + Driver.numberOfMaleAndFemaleMartyrs(district, "F"));
					avgAgeField.setText("---> " + Driver.averageMartyrsAges(district));

					Calendar maxDate = Driver.dateMaximumNumberOfMartyrs(district);

					int year = maxDate.get(Calendar.YEAR);
					int month = maxDate.get(Calendar.MONTH) + 1;
					int day = maxDate.get(Calendar.DAY_OF_MONTH);

					maxDateField.setText("--->" + month + "/" + day + "/" + year);

				}
			} catch (Exception ex) {
				maxDateField.setText("");
			}
		});

		goPreviousDistrict.setOnAction(e -> {
			try {
				if (prev == null || prev == head) {
					curr =head;
				} else {
					curr = prev;
					prev = curr.getPrev();
				}

				if (curr != null) {
					District district = curr.getData();

					namedis.setText("---->" + district.getDistrictName());
					totalMartyrsField.setText("---> " + Driver.totalNumberOfMartyrs(district));
					maleMartyrsField.setText("---> " + Driver.numberOfMaleAndFemaleMartyrs(district, "M"));
					femaleMartyrsField.setText("---> " + Driver.numberOfMaleAndFemaleMartyrs(district, "F"));
					avgAgeField.setText("---> " + Driver.averageMartyrsAges(district));
					Calendar maxDate = Driver.dateMaximumNumberOfMartyrs(district);

					int year = maxDate.get(Calendar.YEAR);
					int month = maxDate.get(Calendar.MONTH) + 1;
					int day = maxDate.get(Calendar.DAY_OF_MONTH);

					maxDateField.setText("--->" + month + "/" + day + "/" + year);

				}
			} catch (Exception e2) {
				maxDateField.setText("");
			}
		});

		totalnumbermartyrsd.setOnAction(e -> {

			try {

				String[] info = totalnumbermartyrsdField.getText().trim().split(",");
				String district = info[0];
				String date = info[1];
				District District = Driver.findDistrict(district);
				double num = Driver.getMartyrsDate(District, date);
				totalnumbermartyrsdFielL.setText("--->" + num);
				totalnumbermartyrsdFielL.setFont(Font.font(15));
			} catch (Exception e2) {
				totalnumbermartyrsdFielL.setText("" + e2.toString());
				totalnumbermartyrsdFielL.setFont(Font.font(15));
			}
		});
		districttolocation.setOnAction(e -> {
			LocationScreen.setHead(curr);
			LocationScreen.setNextLocation(null);
			LocationScreen.setCurr(curr.getData().getLocation().getHead().getNext());
			LocationScreen.Location(primaryStage);
		});
		borderPane.setCenter(gridPane);
		borderPane.setPadding(new Insets(20, 50, 20, 50));

		borderPane.setStyle("-fx-background-color: #FAD4B8;");

		gridPane.setStyle("-fx-background-color: #FAD4B8;");

		primaryStage.setScene(new Scene(borderPane, 1000, 500));
		primaryStage.show();
	}

	public static void MainScreen(Stage primaryStage) {

		Button districtScreen = new Button("𝑮𝑶 𝑻𝑶 𝑻𝑯𝑬 𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻 𝑺𝑪𝑹𝑬𝑬𝑵");

		Button LocationScreen1 = new Button("𝑮𝑶 𝑻𝑶 𝑻𝑯𝑬 𝑴𝑨𝑹𝑻𝒀𝑹𝑺-𝑳𝑶𝑪𝑨𝑻𝑰𝑶𝑵 𝑺𝑪𝑹𝑬𝑬𝑵 ");
		LocationScreen1.setOnAction(e -> {
			LocationScreen.Location(primaryStage);
		});
		districtScreen.setOnAction(e -> {
			district(primaryStage);

		});
		VBox Vbox = new VBox(10);
		double buttonWidth = 250;
		double buttonHeight = 30;
		districtScreen.setMinWidth(buttonWidth);
		districtScreen.setMinHeight(buttonHeight);
		LocationScreen1.setMinWidth(buttonWidth);
		LocationScreen1.setMinHeight(buttonHeight);
		Vbox.getChildren().addAll(districtScreen, LocationScreen1);
		Vbox.setAlignment(Pos.CENTER);
		primaryStage.setScene(new Scene(Vbox, 350, 350));
		primaryStage.show();
	}

}
