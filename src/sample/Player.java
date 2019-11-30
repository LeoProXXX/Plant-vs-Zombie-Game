package sample;


import javafx.scene.image.ImageView;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable {
    private final String name;
    private transient ImageView[][] grid;
    private int current_suntoken;
    private ArrayList<Characters> zombielist;
    private ArrayList<Characters> plantlist;
    private  int level;
    public Player(String x)
    {
        name=x;

    }

    public ImageView[][] getGrid() {
        return grid;
    }

    public void setGrid(ImageView[][] grid) {
        this.grid = grid;
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
    public String getName()
    {
        return  name;
    }

    public void serialize() throws IOException
    {
        System.out.println("Serialized");
        ObjectOutputStream out=null;
        try
        {
            out=new ObjectOutputStream(new FileOutputStream(this.name));
            out.writeObject(this);
        }
        finally
        {
            if(out!=null)
                out.close();
        }
    }

    public static Player deserialize(String name) throws IOException {
        System.out.println("Deserialized");
        ObjectInputStream inp=null;
        Player p=null;
        try
        {
            inp=new ObjectInputStream(new FileInputStream(name));
            p=(Player)inp.readObject();

        }
        catch(Exception e)
        {

        }
        finally
        {
            if(inp!=null)
                inp.close();
        }

        return p;

    }

}
