package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Main extends Application {
	private FileChooser fileChooser = new FileChooser();
	private File file;

	@Override
	public void start(Stage stage) {
		Button loadButton = new Button("𝗥𝗘𝗔𝗗 𝗧𝗛𝗘 𝗙𝗜𝗟𝗘 𝗔𝗡𝗗 𝗦𝗔𝗩𝗘 𝗜𝗧 𝗢𝗡 𝗧𝗛𝗘 𝗟𝗜𝗦𝗧");
		Label label = new Label();
		Label labe2 = new Label(
				"𝑻𝑯𝑬 𝑴𝑨𝑰𝑵 𝑺𝑪𝑹𝑬𝑬𝑵: 𝒀𝑶𝑼 𝑴𝑼𝑺𝑻 𝑫𝑶𝑾𝑵𝑳𝑶𝑨𝑫 𝑻𝑯𝑬 𝑫𝑨𝑻𝑨 𝑩𝑬𝑭𝑶𝑹𝑬 𝑬𝑵𝑻𝑬𝑹𝑰𝑵𝑮 𝑻𝑯𝑬 𝑻𝑾𝑶 𝑺𝑪𝑹𝑬𝑬𝑵𝑺 𝑻𝑶 𝑷𝑬𝑹𝑭𝑶𝑹𝑴 𝑶𝑷𝑬𝑹𝑨𝑻𝑰𝑶𝑵𝑺 𝑶𝑵 𝑻𝑯𝑰𝑺 𝑫𝑨𝑻𝑨");
		Label labe3 = new Label(
				"	𝑨𝑭𝑻𝑬𝑹 𝑻𝑯𝑰𝑺 𝑭𝑰𝑳𝑬 𝑰𝑺 𝑫𝑶𝑾𝑵𝑳𝑶𝑨𝑫𝑬𝑫, 𝑰𝑻 𝑾𝑰𝑳𝑳 𝑻𝑨𝑲𝑬 𝒀𝑶𝑼 𝑫𝑰𝑹𝑬𝑪𝑻𝑳𝒀 𝑻𝑶 𝑨𝑵𝑶𝑻𝑯𝑬𝑹 𝑺𝑪𝑹𝑬𝑬𝑵");

		loadButton.setOnAction(event -> {
			file = fileChooser.showOpenDialog(stage);
			int count = 0;
			if (file != null) {
				try (Scanner scanner = new Scanner(file)) {
					String line = scanner.nextLine();
					while (scanner.hasNext()) {

						line = scanner.nextLine();

						String[] info = line.split(",");
						if (info.length < 6) {

							continue;
						}
						try {
							String name = info[0].trim();
							String date = info[1].trim();
							String age = info[2].trim();
							String locationName = info[3].trim();
							String districtName = info[4].trim();
							String gender = info[5].trim();

							District district = Driver.insertDistrict(districtName);
							if (district != null) {
								Location location = Driver.insertLocation(districtName, locationName);
								if (location != null) {
									Martyr martyr = new Martyr(name, age, locationName, date, gender, districtName);
									Driver.insertMartyr(martyr);
									count++;
								}
								System.out.println(
										Driver.findMartyr(districtName, locationName, name).toString() + count);

							}
						} catch (Exception e) {
							System.out.println("Error -->  " + line);
							e.printStackTrace();
						}
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

			DistrictScreen.MainScreen(stage);
		});

		VBox vBox = new VBox(20);
		vBox.getChildren().addAll(labe2, loadButton, labe3, label);
		vBox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vBox, 840, 300);
		vBox.setStyle("-fx-background-color: lightblue;");
		stage.setTitle("𝗣𝗥𝗢𝗝𝗘𝗖𝗧 𝟭_𝗔𝗬𝗠𝗔𝗡_𝟭𝟮𝟮𝟬𝟭𝟭𝟱");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}

	public void WriteToFile() {

		try {

			FileWriter fileWriter = new FileWriter(file, false);

			PrintWriter printWriter = new PrintWriter(fileWriter);
			DNode<District> curr1 = Driver.District.getHead().getNext();
			while (curr1 != null) {
				Node<Location> curr2 = curr1.getData().getLocation().getHead().getNext();
				while (curr2 != null) {
					Node<Martyr> curr3 = curr2.getData().getMartyr().getHead().getNext();
					while (curr3 != null) {
						printWriter.println(curr3.getData().toString());
						curr3 = curr3.getNext();
					}
					curr3 = curr3.getNext();
				}
				curr1 = curr1.getNext();
			}

			printWriter.close();
		} catch (

		IOException e) {
			e.printStackTrace();
		}

	}

}
