package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Sun {
    Random rand=new Random();
    private int x;
    private int y;
    public ImageView image;
    public Sun(){
        this.x=rand.nextInt(600) + 260;
        this.y=10;
        image=new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        image.relocate(x,y);
    }
}
