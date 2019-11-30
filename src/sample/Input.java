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
    private Player currPlayer;
    @FXML
    private TextField username;
    @FXML
    private Label feedback;

    private boolean newgame;
    public Input( boolean y)
    {
        newgame=y;
    }
    public void input(ActionEvent e) throws Exception
    {

        String name= username.getText();
        if(name.length()==0)
            feedback.setText("Name can not be empty");
        else if(newgame==true)
        {
            if(Main.find(name))
            {
                username.setText("");
                feedback.setText("User Already exist");
            }
            else
            {
                currPlayer=new Player(name);
                Main.addPlayer(currPlayer);
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
                Main.setPlayer(currPlayer);
                loader.setController(new LoginScreen());
                Main.root=loader.load();
                Main.stage.setScene(new Scene(Main.root));
            }
        }
        else
        {
            if(!Main.find(name))
            {
                username.setText("");
                feedback.setText("User Don't exist");
            }
            else
            {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
                loader.setController(new LoginScreen());
                Main.root=loader.load();
                Main.stage.setScene(new Scene(Main.root));
            }

        }
    }

}
