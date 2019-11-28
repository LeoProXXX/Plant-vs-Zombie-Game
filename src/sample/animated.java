package sample;


import javafx.animation.*;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;


public class animated implements Initializable {
    Random rand=new Random();

    @FXML
    public Pane canvas;

    @FXML
    public Button gamepause;

    @FXML
    public ImageView source1;
    @FXML
    public ImageView dest00;
    public int check=1;


    public int chosenx=0,choseny=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void shoot() {
        if(check==1){
            zombietimer();
            check=0;
        }

        ImageView pea =new ImageView(new Image("/Photos/Pea.png"));
        pea.relocate(400, 460);

        ImageView zombie=new ImageView(new Image("/Photos/normal_zombie_moving.gif",100,100,false,false));
        zombie.relocate(850,rand.nextInt(450)+30);

        ImageView sunToken = new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        sunToken.relocate(rand.nextInt(600) + 260,10);

        canvas.getChildren().add(sunToken);
        canvas.getChildren().add(pea);
        canvas.getChildren().add(zombie);



        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(pea.layoutXProperty(), zombie.getLayoutX())));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(40), new KeyValue(zombie.layoutXProperty(), 300)));
        Timeline timeline3=new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(sunToken.layoutYProperty(), 500)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timeline2.setCycleCount(1);
        timeline2.play();
        timeline3.setCycleCount(1);
        timeline3.play();
    }

    public void zombietimer(){

        ImageView zombiehead=new ImageView(new Image("/Photos/zombiehead.png",40,40,false,false));
        canvas.getChildren().add(zombiehead);
        Line line=new Line();
        int y=20;
        int x=700;
        int xend=550;
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(xend);
        line.setEndY(y);

        PathTransition transition=new PathTransition();
        transition.setNode(zombiehead);
        transition.setDuration(Duration.seconds(60));
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

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            this.gamepause.setText("Pause");
        } else if (option.get() == exitbutton) {
            System.exit(0);
        }  else if (option.get() == mainmenubutton) {
            Main.changeScene("LoginScreen.fxml");
        }
    }




    @FXML
    public void handledragdetection(MouseEvent event){
        Dragboard db= source1.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb=new ClipboardContent();
        cb.putImage(source1.getImage());
        db.setContent(cb);
        event.consume();

    }
    @FXML
    public void handledragover(DragEvent event){
        System.out.println("hi");
        if(event.getDragboard().hasImage()){
            System.out.println("here");
            event.acceptTransferModes(TransferMode.ANY);
        }

    }
    @FXML
    public void handledrop(DragEvent event){
        Image plant=event.getDragboard().getImage();
        System.out.println(plant.getUrl());

        dest00.setImage(plant);

    }


}
