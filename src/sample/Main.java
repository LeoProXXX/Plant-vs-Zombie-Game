package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;


public class Main extends Application {
    public static int width=800;
    public static int height=800;
    public static  Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        primaryStage.setTitle("Plant vs Zombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //A main file that saves the name of all the users that have saved their games
    public void save_user(){

    }

    public static void serialise(User ob) throws  IOException {
        ObjectOutputStream out=null;
        try {
            out=new ObjectOutputStream(new FileOutputStream(ob.getName()));
            out.writeObject(ob);
        }
        finally{
            if(out!=null){
                out.close();
            }

        }
    }

    public static User Deserialize(String name) throws IOException,ClassNotFoundException {
        ObjectInputStream in=null;
        User player=new User();
        try{
            in=new ObjectInputStream(new FileInputStream(name));
            player = (User) in.readObject();
        }
        catch(FileNotFoundException e){
            serialise(player);
        }
        catch (NullPointerException e){
            serialise(player);
        }
        finally{
            if(in!=null)
                in.close();
        }
        return player;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
