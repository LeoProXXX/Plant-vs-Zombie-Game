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

        Main.player.setZombielist(zombie);
        Main.player.setPlantlist(plants);

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
                        if(x instanceof Sunflower){
                            animated.canvas1.getChildren().remove(((Sunflower) x).suntoken.gifimage);
                        }
                        animated.canvas1.getChildren().remove(x.gifimage);
                    }
                    else if(r==2) {
                        toremoveZ.add(y);
                        animated.canvas1.getChildren().remove(y.gifimage);
                    }
                    else if(r==3)
                    {
                        toremoveP.add(x);
                        toremoveZ.add(y);
                        if(x instanceof Sunflower){
                            animated.canvas1.getChildren().remove(((Sunflower) x).suntoken.gifimage);
                            ((Sunflower) x).suntoken.n.stop();
                            ((Sunflower) x).suntoken.n.setCycleCount(0);
                        }
                        animated.canvas1.getChildren().remove(x.gifimage);
                        animated.canvas1.getChildren().remove(y.gifimage);
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
        s.gifimage.relocate(rand.nextInt(600) + 260,10);
        animated.canvas1.getChildren().add(s.gifimage);
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(s.gifimage.layoutYProperty(), rand.nextInt(440)+60)));
        timeline.setCycleCount(1);
        timeline.play();

    }
}
