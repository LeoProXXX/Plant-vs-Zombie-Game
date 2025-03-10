package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class CherryBomb extends Plant {
    private static int time = 0;
    private static Timer timer;

    private static class task extends TimerTask {
        @Override
        public void run() {
            time -= 1;
            if (time == 0)
                timer.cancel();
        }
    }

    public static boolean isvalid() {
        return time == 0;
    }

    public static void invalid() {
        time = CherryBomb.getTime();
        TimerTask task1 = new CherryBomb.task();
        timer.schedule(task1, 0L, 1000l);
    }

    private transient ImageView blast;
    public int flag;

    public CherryBomb(int x, int y, int c, int r) {
        super(100, 1000, 5, new ImageView(new Image("/Photos/Cherrybomb.jpeg")), x, y, new ImageView(new Image("/Photos/Cherrybomb.jpeg")), 0, "/Photos/Cherrybomb.jpeg", c, r);
        //blast=new ImageView(new Image("/Photos/bomb.gif"));
        flag = 0;
        timer = new Timer();
    }

    @Override
    public void attack(Characters c) {
        c.dechp(1000);
    }

    public int Checkcollision(Characters c) {
        System.out.println((this.getXpos() - c.getImage().getBoundsInParent().getMaxX()) + " " + (this.getYpos() - c.getImage().getLayoutY()));
        if (Math.abs(this.getXpos() - c.getImage().getBoundsInParent().getMaxX()) <= 100 && !(Math.abs(this.getYpos() - c.getImage().getLayoutY()) >= 100)) {
            System.out.println("here");
            c.setSpeed(0);
            return 1;
        }
        return 2;
    }

    @Override
    public int checkcollision(Characters c) {
        return 0;
    }

    public void changeimage() {
        this.gifimage = blast;
    }

    @Override
    public void startAnimation() {
        timeline = new Timeline(new KeyFrame(Duration.millis(3000), e -> {
            animate();
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    @Override
    public void animate() {

        for (Characters a : Game.zombie) {
            if (Checkcollision(a) == 1) {
                Animated.canvas1.getChildren().remove(a.gifimage);
            }
        }
        System.out.println("Here");
        this.getImage().setVisible(false);
        Animated.canvas1.getChildren().remove(this.getImage());
    }
}
