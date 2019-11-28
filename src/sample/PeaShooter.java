package sample;

public class PeaShooter extends Plant
{
    public PeaShooter()
    {
        super(100,30,3);
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(30);
    }
}
