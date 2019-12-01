package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Plant extends Characters{
    private static int time;
    public Plant(int health, int damage, int time, ImageView image,int x,int y,ImageView gifimage,int speed,String path,int c,int r)
    {
        super(health,damage,image,x,y,gifimage,speed,path,c,r);
        this.time=time;
        image.relocate(x,y);
    }
    public static int getTime()
    {
        return time;
    }
    public void draw(ImageView grid[][])
    {
        gifimage=new ImageView(new Image(path));
        gifimage.setImage(new Image(path));
        grid[r][c].setImage(gifimage.getImage());
    }
}