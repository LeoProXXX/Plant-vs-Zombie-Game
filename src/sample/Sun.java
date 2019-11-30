package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class Sun {
    public ImageView gifimage;
    private int Xpos;
    private int Ypos;
    Timeline t;
    public Sun(){
        gifimage=new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        gifimage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                animated.canvas1.getChildren().remove(gifimage);
                int p=Integer.parseInt(animated.points1.getText())+25;
                animated.points1.setText(Integer.toString(p));
            }
        });
    }
    public Sun(int x,int y){
        this.Xpos=x;
        this.Ypos=y;
        t=new Timeline(new KeyFrame(Duration.seconds(5),e->generatesun()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }
    public void generatesun(){
        gifimage=new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        gifimage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                animated.canvas1.getChildren().remove(gifimage);
                int p=Integer.parseInt(animated.points1.getText())+25;
                animated.points1.setText(Integer.toString(p));
            }
        });
        gifimage.relocate(Xpos,Ypos);
        animated.canvas1.getChildren().add(gifimage);

    }

}
