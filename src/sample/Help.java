package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Help
{
    private  ArrayList<Player> playerList;
    private Player currPlayer;
    @FXML
    private Label help_zombies;
    public Help(java.util.ArrayList<Player> x, Player a)
    {
        currPlayer=a;
        playerList=x;
    }
    public void back_login(ActionEvent e) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
        loader.setController(new LoginScreen(playerList,currPlayer));
        Main.root=loader.load();
        Main.stage.setScene(new Scene(Main.root));
    }
    public void show_help(ActionEvent e) throws Exception
    {
        help_zombies.setVisible(true);
    }
}
