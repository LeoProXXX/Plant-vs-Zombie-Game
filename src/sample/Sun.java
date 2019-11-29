package sample;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Sun {
    public ImageView gifimage;
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
}
