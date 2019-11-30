package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CherryBomb extends Plant
{
    private ImageView blast;
    public int flag;
    public CherryBomb(int x,int y)
    {
        super(100,1000,5,new ImageView(new Image("/Photos/Cherrybomb.jpeg")),x,y,new ImageView(new Image("/Photos/Cherrybomb.jpeg")),0);
        //blast=new ImageView(new Image("/Photos/bomb.gif"));
        flag=0;
    }
    @Override
    public void attack(Characters c)
    {
        c.dechp(1000);
    }

    public int Checkcollision(Characters c){
        System.out.println((this.getXpos()-c.getImage().getBoundsInParent().getMaxX())+" "+(this.getYpos()-c.getImage().getLayoutY()));
        if(Math.abs(this.getXpos()-c.getImage().getBoundsInParent().getMaxX())<=100&&!(Math.abs(this.getYpos()-c.getImage().getLayoutY())>=100))
        {
            System.out.println("here");
            c.setSpeed(0);
            return 1;
        }
        return 2;
    }
    @Override
    public int checkcollision(Characters c){
        return 0;
    }
    public void changeimage(){
        this.gifimage=blast;
    }

    @Override
    public void animate() {
        if(flag==0)
        {
            changeimage();
            flag=1;
        }
        else
        {
            for(Characters a:Game.zombie)
            {
                if(Checkcollision(a)==1)
                {
                    animated.canvas1.getChildren().remove(a.gifimage);
                }
            }
            System.out.println("Here");
            animated.canvas1.getChildren().remove(this.gifimage);
        }
    }


}
