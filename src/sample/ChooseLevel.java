package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.ArrayList;

public class ChooseLevel
{
    private ArrayList<Player> playerList;
    private Player currPlayer;
    public ChooseLevel(ArrayList<Player> x, Player a)
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
    public void show_Ingame()throws Exception
    {
        Main.changeScene("Ingame.fxml");
    }
}
