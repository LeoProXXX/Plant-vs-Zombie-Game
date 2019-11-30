package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CherryBomb extends Plant
{
    private ImageView blast;
    public int flag;
    public CherryBomb(int x,int y)
    {
        super(100,1000,5,new ImageView(new Image("/Photos/Cherrybomb.jpeg")),x,y,new ImageView(new Image("/Photos/Cherrybomb.gif")),0);
        blast=new ImageView(new Image("/Photos/bomb.gif"));
        flag=0;
    }
    @Override
    public void attack(Characters c)
    {
        c.dechp(1000);
    }

    @Override
    public int checkcollision(Characters c){
        if(Math.abs(this.imageView.getBoundsInParent().getMaxX()-c.getImage().getBoundsInParent().getMaxX())<=20&&!(Math.abs(this.imageView.getLayoutY()-c.getImage().getLayoutY())>=100))
        {
            return 1;
        }
        return 2;
    }

    public void changeimage(){
        this.gifimage=blast;
    }

    @Override
    public void animate() {}


}
