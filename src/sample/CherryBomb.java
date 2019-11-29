package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CherryBomb extends Plant
{
    public CherryBomb(int x,int y)
    {
        super(100,1000,5,new ImageView(new Image("/Photos/Cherrybomb.jpeg")),x,y,new ImageView(new Image("/Photos/Cherrybomb.jpeg")),0);
    }
    @Override
    public void attack(Characters c)
    {
        c.dechp(1000);
    }

    @Override
    public void animate() {

    }
}
