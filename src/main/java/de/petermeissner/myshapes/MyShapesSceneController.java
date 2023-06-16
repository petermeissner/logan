package de.petermeissner.myshapes;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;

public class MyShapesSceneController {
    private static final Logger log = LoggerFactory.getLogger(MyShapesSceneController.class);
    public StackPane stackPane;
    public Text text2;
    RotateTransition rotate;
    public void initialize() {

        // rotation binding to stackPane
        rotate = new RotateTransition(
                Duration.millis(500),
                stackPane
        );
        rotate.setToAngle(360);
        rotate.setFromAngle(0);

        // rotate status property binding to text
        rotate.statusProperty().addListener(
                (observable, oldValue, newValue) -> {
                    text2.setText(
                        String.format("Was %s now is %s", oldValue, newValue)
                    );
                }
        );
    }


    @FXML
    public void handleMouseClick(MouseEvent mouseEvent) {
        // log usage
        log.info(mouseEvent.getSource().getClass() + " clicked.");

        // execute
        if ( rotate.getStatus().equals(Animation.Status.RUNNING) ) {
            out.println("Pause");
            rotate.pause();
        } else {
            out.println("Play");
            rotate.play();
        }
    }

}
