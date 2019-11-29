package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StartScreen
{
    private ArrayList<Player> playerList;
    private boolean newgame;
    public void newGame(ActionEvent e) throws Exception
    {
        newgame=true;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("input.fxml"));
        loader.setController(new Input(playerList,newgame));
        Main.root=loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
    public void loadGame(ActionEvent e) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("input.fxml"));
        loader.setController(new Input(playerList,newgame));
        Main.root=loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
    public StartScreen()
    {
        newgame=false;
        ObjectInputStream inp=null;
        try
        {
            inp=new ObjectInputStream(new FileInputStream("Players.txt"));
            playerList=(ArrayList<Player>)inp.readObject();
        }
        catch (FileNotFoundException e)
        {
            playerList=new ArrayList<Player>();
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException");
        }
        finally
        {
            if(inp != null)
            {
                try {
                    inp.close();
                } catch (IOException e) {
                    System.out.println("IoException e");
                }
            }
        }
    }
}
