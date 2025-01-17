package duke;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    private static final Color USERCOLOR = Color.ANTIQUEWHITE;
    private static final Color DUKECOLOR = Color.BEIGE;

    private static final double displayPicDimensions = 80.0;

    public DialogBox(Label l, ImageView iv, Color color) {
        text = l;
        displayPicture = iv;

        text.setWrapText(true);
        displayPicture.setFitWidth(displayPicDimensions);
        displayPicture.setFitHeight(displayPicDimensions);
        cropToCircle(displayPicture);

        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, displayPicture);

        this.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    private void cropToCircle(ImageView picture) {
        Circle circle = new Circle(displayPicDimensions/2,displayPicDimensions/2,displayPicDimensions/2);
        circle.setFill(Color.WHITE);
        picture.setClip(circle);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public static DialogBox getUserDialog(Label l, ImageView iv) {
        return new DialogBox(l, iv, USERCOLOR);
    }

    public static DialogBox getDukeDialog(Label l, ImageView iv) {
        var db = new DialogBox(l, iv, DUKECOLOR);
        db.flip();
        return db;
    }

}
