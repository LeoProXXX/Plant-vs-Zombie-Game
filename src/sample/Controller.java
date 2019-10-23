package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {
    ObservableList<String> game= FXCollections.observableArrayList("Resume Game","New Game");
    @FXML
    private ChoiceBox gametype=new ChoiceBox();
    @FXML
    private Button adventure; // present in main screen for helping select the type of game to load i.e new or resume
    @FXML
    private Button bonus; // to play the bonus game
    @FXML
    private Button exit; // to exit the game
    @FXML
    private Button overview; // to show the list of users already saved and their progress
    @FXML
    private Button help; // to show the help screen
    @FXML
    private Button almanac; // to show the almanac
    @FXML
    private Button back2login;// brings back screen to main screen
    @FXML
    private TextField username; // captures the username if entered
    @FXML
    private Button start_game; // this button is made to take user directly to game; present in new game and resume game screen

    public String curr_username; //username of current user; it gets set when either creates a new game or chooses from a list of username in resume game option

    @FXML
    public void initialize(){ // for initiliazing the choice box present in main screen
        gametype.setValue("Resume Game");
        gametype.setItems(game);
    }


    public void changeScene(String file)throws Exception{ // custom made function which helps in changing the scene
        Parent root = FXMLLoader.load(getClass().getResource(file));
        Main.stage.setScene(new Scene(root));
    }
    public void handlebutton(ActionEvent e) throws Exception { // the main handler function of game
        if(e.getSource()==adventure){
            if(gametype.getValue().equals("New Game")){
                changeScene("New_Game.fxml");
            }
            else {
                changeScene("Resume_Game.fxml");
            }
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
        else if(e.getSource()== back2login){
            changeScene("LoginScreen.fxml");
        }
        else if(e.getSource()==start_game){
            //to be updated
            curr_username=username.getText();
            System.out.println(curr_username);
        }
    }

}
