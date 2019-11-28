package sample;

public abstract class Plant extends Character
{
    private int time;
    public Plant(int health,int damage,int time)
    {
        super(health,damage);
        this.time=time;
    }
    public int getTime()
    {
        return time;
    }

}
