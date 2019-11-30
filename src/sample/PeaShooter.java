package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PeaShooter extends Plant {
    public ImageView pea;
    private Timer timer;
    public PeaShooter(int x,int y)
    {
        super(100,30,3,new ImageView(new Image("/Photos/peashooter.jpeg")),x,y,new ImageView(new Image("/Photos/pea_shooter.gif")),3,"/Photos/pea_shooter.gif");
        pea=new ImageView(new Image("/Photos/Pea.png"));
        timer=new Timer();
        timer1=new Timer();
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
    private static int time=0;
    private static Timer timer1;
    private static class task2 extends TimerTask
    {
        @Override
        public void run() {
            time-=1;
            if(time==0)
                timer1.cancel();
        }
    }
    public static boolean isvalid(ImageView im)
    {
        if(time==0){
            im.setOpacity(1);
            return true;
        }
        return false;
    }

    public static void invalid(ImageView im)
    {
        im.setOpacity(0.7);
        time=PeaShooter.getTime();
        TimerTask task3=new PeaShooter.task2();
        timer1.schedule(task3,0L, 5000L);
    }
    @Override
    public int checkcollision(Characters c)
    {

        int r=super.checkcollision(c);
        if(r==1)
            timer.cancel();
        if(Math.abs(pea.getBoundsInParent().getMaxX()-c.getImage().getBoundsInParent().getMaxX())<=20&&!(Math.abs(pea.getLayoutY()-c.getImage().getLayoutY())>=50))
        {
            c.dechp(25);
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

    @Override
    public void attack(Characters c){ c.dechp(30);  }

    @Override
    public void animate() {
        pea.setTranslateX(pea.getTranslateX()+getSpeed());
    }
}

