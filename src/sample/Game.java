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
    public Game(ArrayList<Characters> a,ArrayList<Characters> b)
    {
        zombie=b;
        plants=a;
    }
    public static void checkCollision()
    {
        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(1000/60),e->{
            ArrayList<Characters> toremoveP=new ArrayList<Characters>();
            ArrayList<Characters> toremoveZ=new ArrayList<Characters>();

            for(Characters x:plants) {
                for (Characters y : zombie) {
                    int r=x.checkcollision(y);
                    if(r==1) {
                        toremoveP.add(x);
                        animated.canvas1.getChildren().remove(x.gifimage);
                        x.endAnimation();
                    }
                    else if(r==2) {
                        toremoveZ.add(y);
                        animated.canvas1.getChildren().remove(y.gifimage);
                        y.endAnimation();
                    }
                    else if(r==3)
                    {
                        toremoveP.add(x);
                        toremoveZ.add(y);
                        animated.canvas1.getChildren().remove(x.gifimage);
                        animated.canvas1.getChildren().remove(y.gifimage);
                        x.endAnimation();
                        y.endAnimation();
                    }
                }
            }
            for(Characters t:toremoveP)
                plants.remove(t);
            for(Characters t: toremoveZ) {
                zombie.remove(t);
                t.setSpeed(0);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public static void dropsuntoken(){
        Sun s=new Sun();
        s.getImage().relocate(rand.nextInt(600) + 260,10);
        animated.canvas1.getChildren().add(s.getImage());
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(s.getImage().layoutYProperty(), rand.nextInt(440)+60)));
        timeline.setCycleCount(1);
        timeline.play();

    }
}
