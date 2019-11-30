package sample;

import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Sun {
    public ImageView gifimage;
    private int Xpos;
    private int Ypos;
    private Timer timer;
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
        timer=new Timer();
    }
    public Sun(int x,int y){
        this.Xpos=x;
        this.Ypos=y;
        gifimage=new ImageView(new Image("/Photos/sunnysmile.gif", 60, 60, false, false));
        gifimage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                animated.canvas1.getChildren().remove(gifimage);
                int p=Integer.parseInt(animated.points1.getText())+25;
                animated.points1.setText(Integer.toString(p));
            }
        });
        timer =new Timer();
        TimerTask task1=new task();
        timer.schedule(task1,3000L);

    }
    private class task extends TimerTask
    {
        @Override
        public void run() {
            gifimage.relocate(Xpos,Ypos);
            FadeTransition ft = new FadeTransition(Duration.millis(3000), gifimage);
            ft.setFromValue(1.0);
            ft.setToValue(0.3);
            ft.setAutoReverse(true);
            animated.canvas1.getChildren().add(gifimage);
            ft.play();
        }
    }
}
