package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Overview
{
    private ArrayList<Player> playerList;
    private Player currPlayer;
    public Overview(ArrayList<Player> x, Player a)
    {
        currPlayer=a;
        playerList=x;
    }

    public void back(ActionEvent e) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
        loader.setController(new LoginScreen(playerList,currPlayer));
        Main.root=loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
}
