package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Characters {
    private int hp;
    private int damage;
    private double Xpos;
    private double Ypos;

    private double speed;
    protected Image image;
    protected ImageView imageView;
    protected ImageView gifimage;
    public int checkcollision(Characters a)
    {
        //System.out.println((this.Xpos-a.getImage().getBoundsInParent().getMaxX())+" "+(this.Ypos-a.getImage().getLayoutY()));
        if(Math.abs(this.Xpos-a.getImage().getBoundsInParent().getMaxX())<=20&&!(Math.abs(this.Ypos-a.getImage().getLayoutY())>=60))
        {
            a.setSpeed(0);
            this.dechp(1);
            if(this.hp<=0){
                animated.canvas1.getChildren().remove(gifimage);
                gifimage.setImage(null);
                System.out.println("Hello");
                a.setSpeed(0.2);
                return 1;
            }
        }
        return 0;
    }
    public Characters(ImageView imageView,ImageView gifimage,double speed){
        this.image=imageView.getImage();
        this.imageView=imageView;
        this.gifimage=gifimage;
        this.speed=speed;
    }

    public Characters(int hp, int damage, ImageView imageview,int x,int y,ImageView gifimage,double speed){
        this.hp=hp;
        this.damage=damage;
        this.image=imageview.getImage();
        this.imageView=imageview;
        this.Xpos=x;
        this.Ypos=y;
        this.gifimage=gifimage;
        this.speed=speed;
    }

    public ImageView getImage()
    {
        return gifimage;
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getXpos() {
        return Xpos;
    }

    public void setXpos(double xpos) {
        Xpos = xpos;
    }

    public double getYpos() {
        return Ypos;
    }

    public void setYpos(double ypos) {
        Ypos = ypos;
    }

    public abstract void attack(Characters c);
    public abstract void animate();
    public void dechp(int x){
        this.hp-=x;

    }
}
