package sample;

import javafx.animation.*;

import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class animated {

    @FXML
    public Pane canvas;

    public void shoot(){
        Image pea_image=new Image("/Photos/Pea.png");

        ImageView pea =new ImageView();
        pea.setImage(pea_image);
        pea.relocate(400, 460);
        ImageView pappu=new ImageView(new Image("/Photos/normal_zombie_moving.gif",100,100,false,false));
        pappu.relocate(850,460);
        canvas.getChildren().add(pea);
        canvas.getChildren().add(pappu);
        Bounds bounds = canvas.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(pea.layoutXProperty(), pappu.getLayoutX())));
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(10), new KeyValue(pappu.layoutXProperty(), 200)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
        System.out.println(pappu.getLayoutX());

    }
}