package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application
{
    private static int width=800;
    private static int height=800;
    public static Parent root;
    public static Stage stage;
    private static Player player;
    private static ArrayList<Player> playerslist;
    private static MediaPlayer m;
    @Override
    public void start(Stage primaryStage) throws Exception{
//      Game g=new Game();
        Level l=new Level();
        stage=primaryStage;
        deserialize();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Start_Screen.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("Ingame.fxml"));
        root= loader.load();
        primaryStage.setTitle("Plant vs Zombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        m=new MediaPlayer(new Media(new File("./src/Music/background.wav").toURI().toString()));
        m.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                m.seek(Duration.ZERO);
            }
        });
        m.play();
    }
    public static boolean find(String x)
    {
        for(int i=0;i<playerslist.size();i++)
        {
            if(x.equals(playerslist.get(i).getName()))
            {
                player=playerslist.get(i);
                return true;
            }
        }
        return false;
    }
    public static void addPlayer(Player x)
    {
        playerslist.add(x);
    }
    public static void serialize() throws IOException
    {
        ObjectOutputStream out=null;
        try
        {
            out=new ObjectOutputStream(new FileOutputStream("Data.txt"));
            out.writeObject(playerslist);
        }
        finally
        {
            if(out!=null)
                out.close();
        }
    }
    public void deserialize() throws IOException,ClassNotFoundException
    {
        ObjectInputStream inp=null;
        try {
            inp=new ObjectInputStream(new FileInputStream("Data.txt"));
            playerslist=(ArrayList<Player>)inp.readObject();
        }
        catch (FileNotFoundException e)
        {
            playerslist=new ArrayList<Player>();
        }
        finally {
            if(inp!=null)
                inp.close();
        }
    }
    public static void changeScene(String file) throws Exception{ // custom made function which helps in changing the scene
        root = FXMLLoader.load(Main.class.getResource(file));
        Main.stage.setScene(new Scene(root));
    }
    public static void setPlayer(Player x)
    {
        player=x;
    }
    public static Player getPlayer()
    {
        return player;
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}