package sample;

import javafx.animation.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import java.util.Random;

import java.util.Optional;


public class animated {
    Random rand=new Random();

    @FXML
    public Pane canvas;

    @FXML
    public Button gamepause;

    @FXML
    public Button b00;
    @FXML
    public Button b01;
    @FXML
    public Button b02;
    @FXML
    public Button b03;
    @FXML
    public Button b04;
    @FXML
    public Button b05;
    @FXML
    public Button b06;
    @FXML
    public Button b07;
    @FXML
    public Button b08;
    @FXML
    public Button b10;
    @FXML
    public Button b11;
    @FXML
    public Button b12;
    @FXML
    public Button b13;
    @FXML
    public Button b14;
    @FXML
    public Button b15;
    @FXML
    public Button b16;
    @FXML
    public Button b17;
    @FXML
    public Button b18;
    @FXML
    public Button b20;
    @FXML
    public Button b21;
    @FXML
    public Button b22;
    @FXML
    public Button b23;
    @FXML
    public Button b24;
    @FXML
    public Button b25;
    @FXML
    public Button b26;
    @FXML
    public Button b27;
    @FXML
    public Button b28;




    public int chosenx=0,choseny=0;


    public void shoot(){
        ImageView pea =new ImageView(new Image("/Photos/Pea.png"));
        pea.relocate(400, 460);

        ImageView zombie=new ImageView(new Image("/Photos/normal_zombie_moving.gif",100,100,false,false));
        zombie.relocate(850,420);
        canvas.getChildren().add(pea);
        canvas.getChildren().add(zombie);



        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(pea.layoutXProperty(), zombie.getLayoutX())));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(40), new KeyValue(zombie.layoutXProperty(), 200)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }

    public void dropsun(){

        Line line= new Line();
        ImageView sunToken=new ImageView(new Image("/Photos/sunnysmile.gif",60,60,false,false));
        canvas.getChildren().add(sunToken);
        int x=rand.nextInt(600)+260;
        int starty=10;
        int endy=500;
        line.setStartX(x);
        line.setStartY(starty);
        line.setEndX(x);
        line.setEndY(endy);

        PathTransition transition=new PathTransition();
        transition.setNode(sunToken);
        transition.setDuration(Duration.seconds(3));
        transition.setPath(line);
        transition.setCycleCount(1);
        transition.play();
    }


    public void showAlertWithDefaultHeaderText() throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("what do you want to do :");

        ButtonType exitbutton = new ButtonType("Exit");
        ButtonType resumebutton = new ButtonType("Resume");
        ButtonType mainmenubutton = new ButtonType("Main Menu");

        // Remove default ButtonTypes
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(exitbutton, resumebutton, mainmenubutton);

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            this.gamepause.setText("Pause");
        } else if (option.get() == exitbutton) {
            System.exit(0);
        }  else if (option.get() == mainmenubutton) {
            Main.changeScene("LoginScreen.fxml");
        }
    }

    public void cellAction(){

    }
}