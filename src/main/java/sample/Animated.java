package sample;

import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.Optional;
import java.util.ResourceBundle;

public class Animated implements Initializable {
    private PlayGame playgame;

    public Animated(PlayGame p) {
        playgame = p;
    }

    Random rand = new Random();
    public static int[] gridy = new int[]{90, 190, 300, 400, 500};
    public static int[] gridx = new int[]{320, 400, 480, 560, 640, 720, 800, 880, 960};
    public static Timeline suntokentimeline;
    public static Timeline zombietimertimeline;
    public static Timeline zombietimeline;
    public static PathTransition zombietimertransition;

    @FXML
    public Pane canvas;
    public static Pane canvas1;

    @FXML
    public Label points;
    public static Label points1;

    @FXML
    public Button gamepause;

    @FXML
    public ImageView source1;
    @FXML
    public ImageView source2;
    @FXML
    public ImageView source3;
    @FXML
    public ImageView source4;

    @FXML
    public ImageView dest00;
    @FXML
    public ImageView dest01;
    @FXML
    public ImageView dest02;
    @FXML
    public ImageView dest03;
    @FXML
    public ImageView dest04;
    @FXML
    public ImageView dest10;
    @FXML
    public ImageView dest11;
    @FXML
    public ImageView dest12;
    @FXML
    public ImageView dest13;
    @FXML
    public ImageView dest14;
    @FXML
    public ImageView dest20;
    @FXML
    public ImageView dest21;
    @FXML
    public ImageView dest22;
    @FXML
    public ImageView dest23;
    @FXML
    public ImageView dest24;
    @FXML
    public ImageView dest30;
    @FXML
    public ImageView dest31;
    @FXML
    public ImageView dest32;
    @FXML
    public ImageView dest33;
    @FXML
    public ImageView dest34;
    @FXML
    public ImageView dest40;
    @FXML
    public ImageView dest41;
    @FXML
    public ImageView dest42;
    @FXML
    public ImageView dest43;
    @FXML
    public ImageView dest44;
    @FXML
    public ImageView dest50;
    @FXML
    public ImageView dest51;
    @FXML
    public ImageView dest52;
    @FXML
    public ImageView dest53;
    @FXML
    public ImageView dest54;
    @FXML
    public ImageView dest60;
    @FXML
    public ImageView dest61;
    @FXML
    public ImageView dest62;
    @FXML
    public ImageView dest63;
    @FXML
    public ImageView dest64;
    @FXML
    public ImageView dest70;
    @FXML
    public ImageView dest71;
    @FXML
    public ImageView dest72;
    @FXML
    public ImageView dest73;
    @FXML
    public ImageView dest74;
    @FXML
    public ImageView dest80;
    @FXML
    public ImageView dest81;
    @FXML
    public ImageView dest82;
    @FXML
    public ImageView dest83;
    @FXML
    public ImageView dest84;
    @FXML
    public ImageView lawnmower1;
    @FXML
    public ImageView lawnmower2;
    @FXML
    public ImageView lawnmower3;
    @FXML
    public ImageView lawnmower4;
    @FXML
    public ImageView lawnmower5;

    @FXML
    public GridPane grida;
    private LawnMover l1;
    private LawnMover l2;
    private LawnMover l3;
    private LawnMover l4;
    private LawnMover l5;

    public static ImageView grid[][];

    public int dragcase = -1;

    public void setimageonimageview(ImageView dest, DragEvent event) {
        if (dest.getImage() == null) {
            Integer cIndex = GridPane.getColumnIndex(dest);
            Integer rIndex = GridPane.getRowIndex(dest);
            int x = cIndex == null ? 0 : cIndex;
            int y = rIndex == null ? 0 : rIndex;
            switch (dragcase) {
                case 1:
                    PeaShooter p = new PeaShooter((int) dest.getLayoutX() + 330, (int) dest.getLayoutY() + 90, x, y);
                    Game.plants.add(p);
                    dest.setImage(p.getImage().getImage());
                    p.gifimage = dest;
                    p.startAnimation();
                    int x1 = Integer.parseInt(Animated.points1.getText()) - 100;
                    Animated.points1.setText(Integer.toString(x1));
                    PeaShooter.invalid();
                    break;
                case 2:
                    Sunflower s = new Sunflower((int) dest.getLayoutX() + 330, (int) dest.getLayoutY() + 90, x, y);
                    Game.plants.add(s);
                    dest.setImage(s.gifimage.getImage());
                    s.gifimage = dest;
                    s.startAnimation();
                    int sx = Integer.parseInt(Animated.points1.getText()) - 50;
                    Animated.points1.setText(Integer.toString(sx));
                    Sunflower.invalid();
                    break;
                case 3:
                    Walnut w = new Walnut((int) dest.getLayoutX() + 330, (int) dest.getLayoutY() + 90, x, y);
                    Game.plants.add(w);
                    dest.setImage(w.gifimage.getImage());
                    w.gifimage = dest;
                    int wx = Integer.parseInt(Animated.points1.getText()) - 50;
                    Animated.points1.setText(Integer.toString(wx));
                    Walnut.invalid();
                    break;
                case 4:
                    CherryBomb c = new CherryBomb((int) dest.getLayoutX() + 330, (int) dest.getLayoutY() + 90, x, y);
                    //Game.plants.add(c);
                    dest.setImage(c.gifimage.getImage());
                    c.gifimage = dest;
                    int cx = Integer.parseInt(Animated.points1.getText()) - 150;
                    Animated.points1.setText(Integer.toString(cx));
                    c.startAnimation();
                    CherryBomb.invalid();
                    break;
                default:
                    System.out.println("no Object found");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println("animated");
        Game g = new Game(playgame.getPlantlist(), playgame.getZombielist());
        source1.setDisable(true);
        source1.setVisible(false);
        source2.setVisible(false);
        source3.setVisible(false);
        source4.setVisible(false);
        source2.setDisable(true);
        source3.setDisable(true);
        source4.setDisable(true);
        if (Main.getPlayer().getmLevel() >= 1) {
            source1.setDisable(false);
            source1.setVisible(true);
        }
        if (Main.getPlayer().getmLevel() >= 2) {
            source2.setDisable(false);
            source2.setVisible(true);
        }
        if (Main.getPlayer().getmLevel() >= 3) {
            source3.setDisable(false);
            source3.setVisible(true);
        }
        if (Main.getPlayer().getmLevel() >= 4) {
            source4.setDisable(false);
            source4.setVisible(true);
        }
        canvas1 = canvas;
        points.setText(String.valueOf(playgame.getCurrent_suntoken()));
        points1 = points;
        lawnmower1.setVisible(false);
        lawnmower2.setVisible(false);
        lawnmower3.setVisible(false);
        lawnmower4.setVisible(false);
        lawnmower5.setVisible(false);
        boolean l[] = playgame.getl();
        if (l[0]) {
            lawnmower1.setVisible(true);
            l1 = new LawnMover(lawnmower1);
        }
        if (l[1]) {
            lawnmower2.setVisible(true);
            l2 = new LawnMover(lawnmower2);
        }
        if (l[2]) {
            lawnmower3.setVisible(true);
            l3 = new LawnMover(lawnmower3);
        }
        if (l[3]) {
            lawnmower4.setVisible(true);
            l4 = new LawnMover(lawnmower4);
        }
        if (l[4]) {
            lawnmower5.setVisible(true);
            l5 = new LawnMover(lawnmower5);
        }
        grid = new ImageView[][]{{dest00, dest01, dest02, dest03, dest04}, {dest10, dest11, dest12, dest13, dest14}, {dest20, dest21, dest22, dest23, dest24}, {dest30, dest31, dest32, dest33, dest34}, {
                dest40, dest41, dest42, dest43, dest44}, {dest50, dest51, dest52, dest53, dest54}, {dest60, dest61, dest62, dest63, dest64}, {dest70, dest71, dest72, dest73, dest74}, {dest80, dest81, dest82, dest83, dest84}};

        for (ImageView[] i : grid) {
            for (ImageView j : i) {
                j.setOnDragDropped(event -> {
                    setimageonimageview(j, event);
                });
            }
        }
        playgame.start(grid);
        suntokentimeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> Game.dropsuntoken()));
        suntokentimeline.setCycleCount(Animation.INDEFINITE);
        suntokentimeline.play();
        Level.start();
        zombietimertimeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> zombietimer()));
        zombietimertimeline.setCycleCount(1);
        zombietimertimeline.play();
        Game.checkCollision();
    }

    public void sync() {
        boolean l[] = new boolean[5];
        if (l1 != null)
            l[0] = l1.getisapplicable();
        if (l2 != null)
            l[1] = l2.getisapplicable();
        if (l3 != null)
            l[2] = l3.getisapplicable();
        if (l4 != null)
            l[3] = l4.getisapplicable();
        if (l5 != null)
            l[4] = l5.getisapplicable();
        playgame.setl(l);
        playgame.setCurrent_suntoken(Integer.valueOf(points.getText()));
        playgame.setPlantlist(Game.plants);
        playgame.setZombielist(Game.zombie);

    }

    public void zombietimer() {

        ImageView zombiehead = new ImageView(new Image("/Photos/zombiehead.png", 40, 40, false, false));
        canvas.getChildren().add(zombiehead);
        Line line = new Line();
        int y = 20;
        int x = 700;
        int xend = 550;
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(xend);
        line.setEndY(y);

        zombietimertransition = new PathTransition();
        zombietimertransition.setNode(zombiehead);
        zombietimertransition.setDuration(Duration.seconds(120));
        zombietimertransition.setPath(line);
        zombietimertransition.setCycleCount(1);
        zombietimertransition.play();
    }


    public void showAlertWithDefaultHeaderText() throws Exception {
        zombietimertimeline.pause();
        suntokentimeline.pause();
        zombietimertransition.pause();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("what do you want to do :");

        ButtonType exitbutton = new ButtonType("Exit");
        ButtonType resumebutton = new ButtonType("Resume");
        ButtonType mainmenubutton = new ButtonType("Main Menu");
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(exitbutton, resumebutton, mainmenubutton);

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null || option.get() == resumebutton) {
            this.gamepause.setText("Pause");
//            zombietimertimeline.play();
            suntokentimeline.play();
            zombietimertransition.play();

        } else if (option.get() == exitbutton) {
            sync();
            Main.serialize();
            System.exit(0);
        } else if (option.get() == mainmenubutton) {
            sync();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../LoginScreen.fxml"));
            loader.setController(new LoginScreen());
            Main.root = loader.load();
            Main.stage.setScene(new Scene(Main.root));
        }
    }


    @FXML
    public void handledragdetection_plant(MouseEvent event) {

        if (Integer.parseInt(Animated.points1.getText()) >= 100 && PeaShooter.isvalid()) {

            dragcase = 1;
            Dragboard db = source1.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(source1.getImage());
            db.setContent(cb);
            event.consume();
        }
    }

    @FXML
    public void handledragdetection_sunflower(MouseEvent event) {
        if (Integer.parseInt(Animated.points1.getText()) >= 50 && Sunflower.isvalid()) {
            dragcase = 2;
            Dragboard db = source2.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(source2.getImage());
            db.setContent(cb);
            event.consume();
        }
    }

    @FXML
    public void handledragdetection_walnut(MouseEvent event) {
        if (Integer.parseInt(Animated.points1.getText()) >= 50 && Walnut.isvalid()) {
            dragcase = 3;
            Dragboard db = source3.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(source3.getImage());
            db.setContent(cb);
            event.consume();
        }
    }

    @FXML
    public void handledragdetection_bomb(MouseEvent event) {
        if (Integer.parseInt(Animated.points1.getText()) >= 150 && CherryBomb.isvalid()) {
            dragcase = 4;
            Dragboard db = source4.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(source4.getImage());
            db.setContent(cb);
            event.consume();

        }
    }

    @FXML
    public void handledragover(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
}
