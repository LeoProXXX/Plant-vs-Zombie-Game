package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.util.Timer;
import java.util.TimerTask;

public class PeaShooter extends Plant {
    private transient ImageView pea;
    private transient Timer timer;

    public PeaShooter(int x, int y, int c, int r) {
        super(100, 30, 3, new ImageView(new Image("/Photos/peashooter.jpeg")), x, y, new ImageView(new Image("/Photos/pea_shooter.gif")), 3, "/Photos/pea_shooter.gif", c, r);
        pea = new ImageView(new Image("/Photos/Pea.png"));
        timer1 = new Timer();
        pea.relocate(this.getXpos(), this.getYpos());
        Animated.canvas1.getChildren().add(pea);
    }

    @Override
    public void draw(ImageView[][] grid) {
        pea = new ImageView(new Image("/Photos/Pea.png"));
        pea.relocate(this.getXpos(), this.getYpos());
        Animated.canvas1.getChildren().add(pea);
        super.draw(grid);
    }

    private class task extends TimerTask {
        @Override
        public void run() {
            try {
                pea.setVisible(true);
                setSpeed(3);
                pea.relocate(PeaShooter.this.getXpos(), PeaShooter.this.getYpos());
                Animated.canvas1.getChildren().add(pea);
                pea.setTranslateX(0.0);
            } catch (Exception e) {
            }
        }
    }

    private static int time = 0;
    private static Timer timer1;

    private static class task2 extends TimerTask {
        @Override
        public void run() {
            time -= 1;
            if (time == 0)
                timer1.cancel();
        }
    }

    public static boolean isvalid() {
        return time == 0;
    }

    public static void invalid() {
        time = PeaShooter.getTime();
        TimerTask task3 = new PeaShooter.task2();
        timer1.schedule(task3, 0L, 1000l);
    }

    @Override
    public int checkcollision(Characters c) {

        int r = super.checkcollision(c);
        if (r == 1 && timer != null)
            timer.cancel();
        // System.out.println("Here");
        if (Math.abs(pea.getBoundsInParent().getMaxX() - c.getImage().getBoundsInParent().getMaxX()) <= 20 && !(Math.abs(pea.getLayoutY() - c.getImage().getLayoutY()) >= 50)) {
            c.dechp(25);
            if (c.getHp() <= 0) {
                r += 2;
            }
            pea.setVisible(false);
            pea.relocate(0, 0);
            pea.setTranslateX(0);
            this.setSpeed(0);
            timer = new Timer();
            TimerTask task1 = new task();
            timer.schedule(task1, 3000L);
        }
        return r;
    }

    @Override
    public void attack(Characters c) {
        c.dechp(30);
    }

    @Override
    public void animate() {
        pea.setTranslateX(pea.getTranslateX() + getSpeed());
        if (pea.getLayoutX() + pea.getTranslateX() > 1000) {
            pea.relocate(this.getXpos(), this.getYpos());
            pea.setTranslateX(0);
        }
    }
}
