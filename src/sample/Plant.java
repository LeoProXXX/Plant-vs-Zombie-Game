package sample;

import javafx.scene.image.Image;

public abstract class Plant extends Character
{
    private int time;
    public Plant(int health, int damage, int time, Image image)
    {
        super(health,damage,image);
        this.time=time;
    }
    public int getTime()
    {
        return time;
    }

}
