package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.sql.Time;
import java.util.ArrayList;

public class LawnMover extends Characters {
    Timeline t;
    Timeline temp;
    public LawnMover(ImageView im){
        super(im,im,1);
        Timeline t=new Timeline(new KeyFrame(Duration.seconds(1),e->checkzombie()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    @Override
    public void attack(Characters c) {

    }

    @Override
    public void animate() {
        gifimage.setTranslateX(gifimage.getTranslateX()+getSpeed());
        if(gifimage.getLayoutX()+gifimage.getTranslateX()>900){
            animated.canvas1.getChildren().remove(gifimage);
        }
        temp.stop();
    }

    @Override
    public int checkcollision(Characters a){
        if(Math.abs(this.getXpos()-a.getImage().getBoundsInParent().getMaxX())<=30&&!(Math.abs(this.getYpos()-a.getImage().getLayoutY())>=60))
        {
            a.dechp(1000);
            return 1;
        }
        return 2;
    }

    public void checkzombie(){
        ArrayList<Characters> removez=new ArrayList<Characters>();
        int flag=0;
        for(Characters c: Game.zombie){
            if(checkcollision(c)==1){
                flag=1;
                removez.add(c);
            }
        }
        if(flag==1) {
            for(Characters c: removez){
                animated.canvas1.getChildren().remove(c.gifimage);
                Game.zombie.remove(c);
            }
            temp = new Timeline(new KeyFrame(Duration.millis(1000 / 60), e -> animate()));
            temp.setCycleCount(Animation.INDEFINITE);
            temp.play();
            t.stop();
        }

    }

}