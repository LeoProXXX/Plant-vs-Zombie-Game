package sample;

public class CherryBomb extends Plant
{
    public CherryBomb()
    {
        super(100,1000,5);
    }
    @Override
    public void attack(Character c)
    {
        c.dechp(1000);
    }
}
