package sample;

import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable {
    private ArrayList<PlayGame> games;
    private final String name;
    private int mLevel;

    public Player(String name) {
        this.name = name;
        mLevel = 1;
        games = new ArrayList<PlayGame>();
    }

    public void incLevel() {
        mLevel += 1;
    }

    public int getmLevel() {
        return mLevel;
    }

    public ArrayList<PlayGame> getList() {
        return games;
    }

    public void add(PlayGame a) {
        games.add(a);
    }

    public String getName() {
        return name;
    }
}
