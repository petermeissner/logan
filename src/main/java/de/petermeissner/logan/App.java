package de.petermeissner.logan;

import de.petermeissner.util;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class App extends Application {

    @FXML
    ScrollPane mainSceneContent;
    Logger logger = LoggerFactory.getLogger(App.class);


    @Override
    public void start(Stage stage) throws IOException {

        // loading fxml
        Parent startScene = this.loadFXML("/fxml/MainScene.fxml");

        // scene
        Scene scene = new Scene(startScene, Color.ALICEBLUE);

        // setting up window
        stage.setTitle("Logan the log analyst");
        stage.setScene(scene);
        loadLogs();
        stage.show();
    }




    /**
     * THE MAIN application entry point
     * @param args not used, arguments to main
     */
    public static void main(String[] args) {
        launch(args);
    }




    /**
     * @param fname file name without path and without file extension
     * @return scene/nodes
     */
    private Parent loadFXML(String fname) throws IOException {
        Parent parent = FXMLLoader.load(
                util.checkNull(getClass().getResource(fname))
        );
        return parent;
    }


    void loadContent(String node) throws IOException {
        logger.info("Load parameter = " + node);

        // check if name or path was provided
        boolean isPath = util.strMatches(node, ".*/.*");

        // handle non path
        if ( !isPath ) {
            node = "/fxml/" + node + ".fxml";
        }

        logger.info("Loading = " + node);

        // load fxml
        Parent n = this.loadFXML(node);

        // replace content
        this.mainSceneContent.setContent(n);
    }

    public void loadOptions(ActionEvent actionEvent) throws IOException {
        loadContent("Options");
    }

    public void loadOptions() throws IOException {
        loadContent("Options");
    }

    public void loadLogs(ActionEvent actionEvent) throws IOException {
        loadContent("Logs");
    }
    public void loadLogs() throws IOException {
        loadContent("Logs");
    }
}
