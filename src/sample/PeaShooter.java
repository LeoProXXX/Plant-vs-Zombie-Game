package sample;

import javafx.scene.image.Image;

public class PeaShooter extends Plant
{
    public PeaShooter()
    {
        super(100,30,3,new Image("/Photos/peashooter.jpeg"));
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(30);
    }
}
