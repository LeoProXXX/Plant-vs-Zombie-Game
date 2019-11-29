package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Plant extends Character
{
    private int time;
    public Plant(int health, int damage, int time, ImageView image)
    {
        super(health,damage,image);
        this.time=time;
    }
    public int getTime()
    {
        return time;
    }

}