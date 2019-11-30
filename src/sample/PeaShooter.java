package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PeaShooter extends Plant {
    public ImageView pea;
    public PeaShooter(int x,int y)
    {
        super(100,30,3,new ImageView(new Image("/Photos/peashooter.jpeg")),x,y,new ImageView(new Image("/Photos/pea_shooter.gif")),2);
        pea=new ImageView(new Image("/Photos/Pea.png"));
    }
    @Override
    public int checkcollision(Characters c)
    {

        int r=super.checkcollision(c);
        System.out.println(this.getHp()+" "+c.getHp());
        //System.out.println("x="+(pea.getBoundsInParent().getMaxX()-c.getImage().getBoundsInParent().getMaxX()));
        if(Math.abs(pea.getBoundsInParent().getMaxX()-c.getImage().getBoundsInParent().getMaxX())<=20&&!(Math.abs(pea.getLayoutY()-c.getImage().getLayoutY())>=50))
        {
            c.dechp(1);
            if(c.getHp()<=0){
                r+=2;
            }
            pea.relocate(this.getXpos(),this.getYpos());
            pea.setTranslateX(0.0);
        }
        return r;
    }
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

