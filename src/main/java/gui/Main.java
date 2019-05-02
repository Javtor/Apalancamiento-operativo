package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	@SuppressWarnings("restriction")
	@Override
	public void start(Stage primaryStage) throws Exception { 
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/interfaz.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Apalancamiento Operativo");
		MainController contr = loader.getController();
		contr.init();
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
