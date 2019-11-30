package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sunflower extends Plant
{
    Sun suntoken;
    public Sunflower(int x,int y)
    {
        super(100,0,2,new ImageView(new Image("/Photos/sunflower.png")),x,y,new ImageView(new Image("/Photos/sun_flower.gif")),0);
        suntoken=new Sun(x,y);
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