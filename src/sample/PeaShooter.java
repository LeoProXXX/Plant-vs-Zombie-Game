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
        super(100,30,3,new ImageView(new Image("/Photos/peashooter.jpeg")),x,y,new ImageView(new Image("/Photos/pea_shooter.gif")),10);
        pea=new ImageView(new Image("/Photos/Pea.png"));

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

