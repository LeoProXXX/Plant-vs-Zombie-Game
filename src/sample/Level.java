package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.time.Period;
import java.util.Random;

public class Level
{
    private static int level;
    private static Duration time;
    private static int i=0;
    public Level()
    {
        level=0;
    }
    public static void setLevel(int x)
    {
        level=x;
    }
    public static void start()
    {

        Random rand=new Random();
        time=Duration.millis(5000);
        i=1;
        Timeline zombietimeline=new Timeline(new KeyFrame(time,e->{
            int j=i;
            while(j>0)
            {
                NormalZombie n=new NormalZombie(850,animated.gridy[rand.nextInt(5)]-50);
               Game.zombie.add(n);
                n.gifimage.relocate(900,animated.gridy[rand.nextInt(5)]-50);
                animated.canvas1.getChildren().add(n.gifimage);
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000/60), z->{
                n.animate();
            } ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
            j--;
            }
            changetime();
        }));
        zombietimeline.setCycleCount(5);
        zombietimeline.play();
    }
    public static void changetime()
    {
        i++;
    }
}
