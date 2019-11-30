package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.ArrayList;

public class LawnMover extends Characters {
    Timeline t;
    Timeline temp;
    public LawnMover(ImageView im){
        super(im,im,1,"/Photos/lawn_mower.gif");
        Timeline t=new Timeline(new KeyFrame(Duration.seconds(1),e->checkzombie()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
        this.setXpos(im.getLayoutX());
        this.setYpos(im.getLayoutY());
    }
    public void draw(ImageView grid[][])
    {}
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
//        System.out.println(((this.getXpos()-a.getImage().getBoundsInParent().getMaxX()))+" "+(this.getYpos()-a.getImage().getLayoutY()));
        if(Math.abs(this.getXpos()-a.getImage().getBoundsInParent().getMaxX())<=160&&!(Math.abs(this.getYpos()-a.getImage().getLayoutY())>=60))
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
                break;
            }
        }
        if(flag==1) {
            for(Characters c:Game.zombie)
            {
                if(!(Math.abs(this.getYpos()-c.getImage().getLayoutY())>=60))
                    removez.add(c);
            }
            for(Characters c: removez){
                animated.canvas1.getChildren().remove(c.gifimage);
                Game.zombie.remove(c);
                c.setSpeed(0);
            }
            temp = new Timeline(new KeyFrame(Duration.millis(1000), new KeyValue(gifimage.layoutXProperty(),1100)));
            temp.setCycleCount(1);
            this.setXpos(-1000);
            temp.play();
            if(t!=null)
            t.stop();
        }

    }

}