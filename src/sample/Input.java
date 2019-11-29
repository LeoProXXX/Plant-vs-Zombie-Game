package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Input
{
    private ArrayList<Player> playerList;
    private Player currPlayer;
    @FXML
    private TextField username;
    @FXML
    private Label feedback;

    private boolean newgame;
    public Input(ArrayList<Player> x, boolean y)
    {
        System.out.println("Hello");
        playerList=x;
        newgame=y;
    }
    public void input(ActionEvent e) throws Exception
    {
        System.out.println("Hello");
        String name= username.getText();
        System.out.println(newgame);
        if(name.length()==0)
            feedback.setText("Name can not be empty");
        else if(newgame==true)
        {
            if(find(name))
            {
                username.setText("");
                feedback.setText("User Already exist");
            }
            else
            {
                currPlayer=new Player(name);
                addPlayer(currPlayer);
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
                loader.setController(new LoginScreen(playerList,currPlayer));
                Main.root=loader.load();
                Main.stage.setScene(new Scene(Main.root));
            }
        }
        else
        {
            if(!find(name))
            {
                username.setText("");
                feedback.setText("User Don't exist");
            }
            else
            {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
                loader.setController(new LoginScreen(playerList,currPlayer));
                Main.root=loader.load();
                Main.stage.setScene(new Scene(Main.root));
            }

        }
    }
    public void addPlayer(Player a)
    {
        playerList.add(a);
    }
    public boolean find(String x)
    {
        for(int i=0;i<playerList.size();i++)
        {
            if(x.equals(playerList.get(i).getName()))
            {
                currPlayer=playerList.get(i);
                return true;
            }
        }
        return false;
    }
}
