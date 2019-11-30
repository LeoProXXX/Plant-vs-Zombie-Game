package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.sql.Time;
import java.time.Period;
import java.util.ArrayList;
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
    public static Timeline zombietimeline;
    public static ArrayList<Timeline> listzombietimeliens=new ArrayList<Timeline>();
    public static void start()
    {

        Random rand=new Random();
        time=Duration.millis(70000/level);
        i=1;
        zombietimeline=new Timeline(new KeyFrame(time,e->{
                Zombie n=getzombie(rand.nextInt(level));
                Game.zombie.add(n);
                animated.canvas1.getChildren().add(n.gifimage);
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000/60), z-> n.animate()));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                listzombietimeliens.add(timeline);
                changetime();
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
            n = new NormalZombie(900, animated.gridy[rand.nextInt(5)] - 50);
        else if (x == 1)
            n = new FlagZombie(900, animated.gridy[rand.nextInt(5)] - 50);
        else if (x == 2)
            n = new ConeheadZombie(900, animated.gridy[rand.nextInt(5)] - 50);
        else
            n = new BucketheadZombie(900, animated.gridy[rand.nextInt(5)] - 50);
        n.gifimage.relocate(n.getXpos(),n.getYpos());
        return n;
    }
    public static void pausetimelines(){
        zombietimeline.pause();
        for(Timeline i: listzombietimeliens){
            i.pause();
        }
    }
    public static void playtimeline(){
        zombietimeline.play();
        for(Timeline i: listzombietimeliens){
            i.play();
        }
    }
}
