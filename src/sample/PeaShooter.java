package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PeaShooter extends Plant {
    public ImageView pea;
    private Timer timer;
    public PeaShooter(int x,int y)
    {
        super(100,30,3,new ImageView(new Image("/Photos/peashooter.jpeg")),x,y,new ImageView(new Image("/Photos/pea_shooter.gif")),3);
        pea=new ImageView(new Image("/Photos/Pea.png"));
        timer=new Timer();
    }
    private class task extends TimerTask
    {
        @Override
        public void run() {
            pea.setVisible(true);
            setSpeed(3);
            pea.relocate(PeaShooter.this.getXpos(),PeaShooter.this.getYpos());
            pea.setTranslateX(0.0);
        }
    }
    @Override
    public int checkcollision(Characters c)
    {

        int r=super.checkcollision(c);
        if(r==1)
            timer.cancel();
        //System.out.println(this.getHp()+" "+c.getHp());
        //System.out.println("x="+(pea.getBoundsInParent().getMaxX()-c.getImage().getBoundsInParent().getMaxX()));
        if(Math.abs(pea.getBoundsInParent().getMaxX()-c.getImage().getBoundsInParent().getMaxX())<=20&&!(Math.abs(pea.getLayoutY()-c.getImage().getLayoutY())>=50))
        {
            c.dechp(5);
            if(c.getHp()<=0){
                r+=2;
            }
            pea.setVisible(false);
            pea.relocate(0,0);
            pea.setTranslateX(0);
            this.setSpeed(0);
            TimerTask task1=new task();
            timer.schedule(task1,3000L);
        }
        return r;
    }
    /*public void cancel()
    {
        timer.cancel();
    }*/
    @Override
    public void attack(Characters c)
    {

        c.dechp(30);
    }

    @Override
    public void animate() {
        pea.setTranslateX(pea.getTranslateX()+getSpeed());
    }
}

