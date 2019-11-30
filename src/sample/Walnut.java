package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Walnut extends Plant
{
    private static int time=0;
    private static Timer timer;
    private static class task extends TimerTask
    {
        @Override
        public void run() {
            time-=1;
            if(time==0)
                timer.cancel();
        }
    }
    public static boolean isvalid()
    {
        return time==0;
    }
    public static void invalid()
    {
        time=Walnut.getTime();
        TimerTask task1=new Walnut.task();
        timer.schedule(task1,0L,1000l);
    }
    public Walnut(int x,int y,int c,int r) {
        super(1000,0,7,new ImageView(new Image("/Photos/walnut.png")),x,y,new ImageView(new Image("/Photos/walnut_full_life.gif")),0,"/Photos/walnut_full_life.gif",c,r);
    timer=new Timer();
    }


    @Override
    public void attack(Characters c)
    {
        c.dechp(0);
    }

    @Override
    public void animate() {

    }
}