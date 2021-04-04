package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Zombie extends Characters {
    private static boolean flag = true;

    public Zombie(int hp, int damage, int x, int y, ImageView image, ImageView gifimage, double speed, String path) {

        super(hp, damage, image, x, y, gifimage, speed, path);
        this.gifimage.relocate(x, y);
    }

    public Zombie(int x, int y, ImageView image, ImageView gifimage, double speed, String path) {
        super(100, 10, image, x, y, gifimage, speed, path);
        this.gifimage.relocate(x, y);
    }

    @Override
    public void draw(ImageView grid[][]) {
        gifimage = new ImageView(new Image(path, 100, 100, false, false));
        this.gifimage.relocate(this.getXpos(), this.getYpos());
        Animated.canvas1.getChildren().add(gifimage);
    }

    public void moving() {

    }

    @Override
    public void attack(Characters c) {

        c.dechp(getDamage());
    }

    @Override
    public void animate() {

        gifimage.setTranslateX(gifimage.getTranslateX() - getSpeed());
        this.setXpos(gifimage.getLayoutX() + gifimage.getTranslateX());
        if (gifimage.getLayoutX() + gifimage.getTranslateX() < 50 && flag) {
            System.out.println("hereeee");
            flag = false;
            GameOver();
        }
    }

    public void GameOver() {
        try {
            Main.changeScene("GameOver.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
