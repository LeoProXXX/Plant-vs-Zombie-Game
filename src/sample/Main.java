package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
public class Main extends Application
{
    public static int width=800;
    public static int height=800;
    public static Parent root;
    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Game g=new Game();
        Level l=new Level();
        stage=primaryStage;
//        loader= new FXMLLoader(getClass().getResource("Start_Screen.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ingame.fxml"));
        root= loader.load();
        primaryStage.setTitle("Plant vs Zombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void changeScene(String file) throws Exception{ // custom made function which helps in changing the scene
        root = FXMLLoader.load(Main.class.getResource(file));
        Main.stage.setScene(new Scene(root));
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}