package sample;

import javafx.animation.AnimationTimer;
import java.util.ArrayList;

public class Game {
    public static ArrayList<Character> gameobjects;
    public static AnimationTimer t;
    public Game(){
        gameobjects=new ArrayList<Character>();
        t= new AnimationTimer(){
            @Override
            public void handle(long l) {
                if(gameobjects.size()!=0){
                    Character i=gameobjects.remove(0);
                    i.animate();
                }
            }
        };

    }
}
