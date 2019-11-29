package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CherryBomb extends Plant
{
    public CherryBomb(int x,int y)
    {
        super(100,1000,5,new ImageView(new Image("/Photos/Cherrybomb.jpeg")),x,y);
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(1000);
    }

    @Override
    public void animate() {

    }
}
