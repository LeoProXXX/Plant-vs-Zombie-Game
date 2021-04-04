package sample;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;
import java.util.Timer;


public class Sun implements Serializable {
    private transient ImageView gifimage;
    private int Xpos;
    private int Ypos;
    private transient Timer timer;

    public Sun() {
        gifimage = new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        gifimage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Animated.canvas1.getChildren().remove(gifimage);
                int p = Integer.parseInt(Animated.points1.getText()) + 25;
                Animated.points1.setText(Integer.toString(p));
            }
        });
    }

    private Timeline n;

    public Sun(int x, int y) {
        this.Xpos = x;
        this.Ypos = y;
    }

    public ImageView getImage() {
        return gifimage;
    }

    public void generatesun() {
        gifimage = new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        gifimage.setOnMouseClicked(mouseEvent -> {
            Animated.canvas1.getChildren().remove(gifimage);
            int p = Integer.parseInt(Animated.points1.getText()) + 25;
            Animated.points1.setText(Integer.toString(p));
        });
        gifimage.relocate(Xpos, Ypos);
        Animated.canvas1.getChildren().add(gifimage);
    }
}
