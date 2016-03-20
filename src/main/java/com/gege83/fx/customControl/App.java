package com.gege83.fx.customControl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	private final ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Parent root = SpringFXMLLoader.create().location(getClass().getResource("Main.fxml"))
				.applicationContext(context).load();
		final Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
