package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;


public class Controller {
    @FXML
    private Button adventure;
    @FXML
    private Button bonus;
    @FXML
    private Button exit;
    @FXML
    private Button overview;
    @FXML
    private Button help;
    @FXML
    private Button almanac;
    @FXML
    private Button start2login;


    public void changeScene(String file)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(file));
        Main.stage.setScene(new Scene(root));
    }
    public void handlebutton(ActionEvent e) throws Exception {
        if(e.getSource()==adventure){
            changeScene("Adventure.fxml");
        }
        else if(e.getSource()==overview){
            changeScene("Overview.fxml");
        }
        else if(e.getSource()==bonus){
            changeScene("BonusGame.fxml");
        }
        else if(e.getSource()==help){
            changeScene("Help.fxml");
        }
        else if(e.getSource()==almanac){
            changeScene("Almanac.fxml");
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==start2login){
            changeScene("LoginScreen.fxml");

        }
    }

}
