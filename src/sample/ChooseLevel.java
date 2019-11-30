package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class ChooseLevel
{
    private ArrayList<Player> playerList;
    private Player currPlayer;
    public ChooseLevel(){
        playerList=new ArrayList<Player>();
        currPlayer=new Player("Sandeep");
    }
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
    public void level1()throws Exception
    {
        Main.player.setLevel(1);
        Level.setLevel(1);
        Main.changeScene("Ingame.fxml");
    }
    public void level2()throws Exception
    {
        Main.player.setLevel(2);
        Level.setLevel(2);
        Main.changeScene("Ingame.fxml");
    }
    public void level3()throws Exception
    {
        Main.player.setLevel(3);
        Level.setLevel(3);
        Main.changeScene("Ingame.fxml");
    }
    public void level4()throws Exception
    {
        Main.player.setLevel(4);
        Level.setLevel(4);
        Main.changeScene("Ingame.fxml");
    }
    public void level5()throws Exception
    {
        Main.player.setLevel(5);
        Level.setLevel(5);
        Main.changeScene("Ingame.fxml");
    }
}
