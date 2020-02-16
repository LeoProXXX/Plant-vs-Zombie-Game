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

        time=Duration.millis(15000/level);

        Timeline zombietimeline=new Timeline(new KeyFrame(time,e->{

                Zombie n=getzombie(rand.nextInt(level));
                Game.zombie.add(n);
                animated.canvas1.getChildren().add(n.gifimage);
                n.startAnimation();
        }));
        zombietimeline.setCycleCount(3*level);
        zombietimeline.play();
    }
    public static void changetime()
    {
        i++;
    }
    public static Zombie getzombie(int x) {
        Random rand = new Random();
        Zombie n;
        System.out.println(x);
        if (x == 0)
            n = new NormalZombie(850, animated.gridy[rand.nextInt(5)] - 50);
        else if (x == 1)
            n = new FlagZombie(850, animated.gridy[rand.nextInt(5)] - 50);
        else if (x == 2)
            n = new ConeheadZombie(850, animated.gridy[rand.nextInt(5)] - 50);
        else
            n = new BucketheadZombie(850, animated.gridy[rand.nextInt(5)] - 50);
        return n;
    }
}
