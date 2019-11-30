package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static Random rand=new Random();
    public static ArrayList<Characters> zombie;
    public static ArrayList<Characters> plants;
    public static AnimationTimer t;
    public Game()
    {
        zombie=new ArrayList<Characters>();
        plants=new ArrayList<Characters>();

    }
    public static void checkCollision()
    {
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(1000/60),e->{
            for(Characters x:plants)
                for(Characters y:zombie)
                    x.checkcollision(y);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public static void dropsuntoken(){
        Sun s=new Sun();
        s.gifimage.relocate(rand.nextInt(600) + 260,10);
        animated.canvas1.getChildren().add(s.gifimage);
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(s.gifimage.layoutYProperty(), rand.nextInt(440)+60)));
        timeline.setCycleCount(1);
        timeline.play();

    }
}
