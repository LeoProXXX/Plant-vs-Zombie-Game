package sample;

public abstract class Character {
    private int hp;
    private int damage;
    private double Xpos;
    private double Ypos;

    public Character(){

    }
    public Character(int hp, int damage){
        this.hp=hp;
        this.damage=damage;
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
    public void dechp(int x){

    }
}
