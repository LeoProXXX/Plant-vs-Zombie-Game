package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static Random rand=new Random();
    public static ArrayList<Characters> gameobjects;
    public static AnimationTimer t;
    public Game(){
        gameobjects=new ArrayList<Characters>();

    }
    public static void dropsuntoken(){
        Sun s=new Sun();
        s.gifimage.relocate(rand.nextInt(600) + 260,10);
        animated.canvas1.getChildren().add(s.gifimage);
        Timeline timeline3=new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(s.gifimage.layoutYProperty(), rand.nextInt(440)+60)));
        timeline3.setCycleCount(1);
        timeline3.play();

    }
}
