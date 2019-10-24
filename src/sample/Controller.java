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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;


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
    @FXML
    private ImageView peashooter_image;
    @FXML
    private ImageView sunflower_image;
    @FXML
    private ImageView walnut_image;
    @FXML
    private ImageView cherrybomb_image;
    @FXML
    private ImageView zombie_image;
    @FXML
    private ImageView bucketheadzombie_image;
    @FXML
    private ImageView coneheadzombie_image;
    @FXML
    private ImageView flagzombie_image;
    @FXML
    private Label character_details;
    @FXML
    private ImageView character_image;

    public String curr_username; //username of current user; it gets set when either creates a new game or chooses from a list of username in resume game option

    @FXML
    private void initialize(){ // for initiliazing the choice box present in main screen
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


    public void Cherrybomb_press(){

        character_image.setImage(new Image("/Photos/Cherrybomb.jpeg"));
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("Cherry bomb\nDamage: massive\n" +
                "Range: all zombies in a medium area\n" +
                "Usage: single use, instant\n" +
                "\"I wanna explode,\" says Cherry #1. \"No, let's detonate instead!\" says his brother, Cherry #2. After intense consultation they agree to explodonate.\n" +
                "Cost: 150\n" +
                "Recharge: very slow ");
    }
    public void Peashooter_press(){

        character_image.setImage(new Image("/Photos/peashooter.jpeg"));
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("Peashooter\nDamage: normal\n" +
                "How can a single plant grow and shoot so many peas so quickly? Peashooter says, \"Hard work, commitment, and a healthy, well-balanced breakfast of sunlight and high-fiber carbon dioxide make it all possible.\"\n" +
                "Cost: 100\n" +
                "Recharge: fast ");
    }
    public void Walnut_press(){

        character_image.setImage(new Image("/Photos/walnut.png"));
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("Walnut\nToughness: high\n" +
                "\"People wonder how I feel about getting constantly chewed on by zombies,\" says Wall-nut. \"What they don't realize is that with my limited senses all I can feel is a kind of tingling, like a relaxing back rub.\"\n" +
                "Cost: 50\n" +
                "Recharge: slow ");
    }
    public void Sunflower_press(){
        character_image.setImage(new Image("/Photos/sunflower.png"));
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("SunFLower\nSun production: normal\n" +
                "Sunflower can't resist bouncing to the beat. Which beat is that? Why, the life-giving jazzy rhythm of the Earth itself, thumping at a frequency only Sunflower can hear.\n" +
                "Cost: 50\n" +
                "Recharge: fast ");
    }
    public void Zombie_press(){
        character_image.setImage(new Image("/Photos/regular.png"));
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("Regular Zombie\nToughness: low\n" +
                "\n" +
                "This zombie loves brains. Can't get enough. Brains, brains, brains, day in and night out. Old and stinky brains? Rotten brains? Brains clearly past their prime? Doesn't matter. Regular zombie wants 'em. ");
    }
    public void Buckethead_press(){
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("BucketHead zombie\nToughness: high\n" +
                "Weakness: magnet-shroom\n" +
                "Buckethead Zombie always wore a bucket. Part of it was to assert his uniqueness in an uncaring world. Mostly he just forgot it was there in the first place. ");
        character_image.setImage(new Image("/Photos/buckethead.png"));
    }
    public void Conehead_press(){
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("ConeHead zombie\nToughness: medium\n" +
                "Conehead Zombie shuffled mindlessly forward like every other zombie. But something made him stop, made him pick up a traffic cone and stick it on his head. Oh yeah. He likes to party. ");
        character_image.setImage(new Image("/Photos/conehead.png"));
    }
    public void Flagzombie_press(){
        character_details.setFont(new Font("Arial", 15));
        character_details.setText("Flag zombie\nToughness: low\n" +
                "Make no mistake, Flag Zombie loves brains. But somewhere down the line he also picked up a fascination with flags. Maybe it's because the flags always have brains on them. Hard to say. ");
        character_image.setImage(new Image("/Photos/flag.png"));
    }

}
