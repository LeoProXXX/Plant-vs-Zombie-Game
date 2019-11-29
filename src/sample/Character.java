package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Character {
    private int hp;
    private int damage;
    private double Xpos;
    private double Ypos;
    protected Image image;
    protected ImageView imageView;
    protected ImageView gifimage;

    public Character(ImageView imageView,ImageView gifimage){
        this.image=imageView.getImage();
        this.imageView=imageView;
        this.gifimage=gifimage;

    }
    public Character(int hp, int damage, ImageView imageview,int x,int y,ImageView gifimage){
        this.hp=hp;
        this.damage=damage;
        this.image=imageview.getImage();
        this.imageView=imageview;
        this.Xpos=x;
        this.Ypos=y;
        this.gifimage=gifimage;
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

    public abstract void attack(Character c);
    public abstract void animate();
    public void dechp(int x){
        this.hp-=x;

    }
}
