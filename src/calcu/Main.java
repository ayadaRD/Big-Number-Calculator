package calcu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //load file from path
        Parent root = FXMLLoader.load(getClass().getResource("view/mainPage.fxml"));

        //creating scene
        Scene scene = new Scene(root);

        //disabling maximize button
        stage.resizableProperty().setValue(Boolean.FALSE);

        //setting title
        stage.setTitle("Calculator");

        //set light mode as default theme
        scene.getStylesheets().add("calcu/styles/lightMode.css");

        //setting the size of window
        stage.setWidth(580);
        stage.setHeight(730);

        //connecting
        stage.setScene(scene);

        //setting icon
        stage.getIcons().add(new Image("calcu/icon.png"));

        //showing
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
