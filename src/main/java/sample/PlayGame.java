package sample;

import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;

public class PlayGame implements Serializable {
    private int current_suntoken;
    private ArrayList<Characters> zombielist;
    private ArrayList<Characters> plantlist;
    private boolean l[];
    private int level;

    public PlayGame(int level) {
        this.level = level;
        current_suntoken = 50;
        zombielist = new ArrayList<Characters>();
        plantlist = new ArrayList<Characters>();
        l = new boolean[5];
        for (int i = 0; i < l.length; i++)
            l[i] = true;
    }

    public void start(ImageView grid[][]) {
        for (Characters x : zombielist) {
            x.draw(grid);
            x.startAnimation();
        }
        for (Characters x : plantlist) {
            x.draw(grid);
            x.startAnimation();

        }
    }

    public void setl(boolean l[]) {
        this.l = l;
    }

    public boolean[] getl() {
        return l;
    }

    public int getCurrent_suntoken() {
        return current_suntoken;
    }

    public void setCurrent_suntoken(int current_suntoken) {
        this.current_suntoken = current_suntoken;
    }

    public ArrayList<Characters> getZombielist() {
        return zombielist;
    }

    public void setZombielist(ArrayList<Characters> zombielist) {
        this.zombielist = zombielist;
    }

    public ArrayList<Characters> getPlantlist() {
        return plantlist;
    }

    public void setPlantlist(ArrayList<Characters> plantlist) {
        this.plantlist = plantlist;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        String x = "sun= " + String.valueOf(current_suntoken) + " level= " + String.valueOf(level);
        return x;
    }

    @Override
    public boolean equals(Object t) {
        if (t != null)
            return this.toString().equals(t.toString());
        return false;
    }
}
