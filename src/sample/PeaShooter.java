package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PeaShooter extends Plant
{
    public PeaShooter()
    {
        super(100,30,3,new ImageView(new Image("/Photos/peashooter.jpeg")));
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(30);
    }

    @Override
    public void animate() {

    }
}

