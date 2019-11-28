package sample;

public class Walnut extends Plant
{
    public Walnut()
    {
        super(500,0,7);
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(0);
    }
}
