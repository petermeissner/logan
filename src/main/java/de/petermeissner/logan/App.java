package de.petermeissner.logan;

import de.petermeissner.logan.misc.ContentHandler;
import de.petermeissner.logan.misc.Preferences;
import de.petermeissner.logan.misc.PreferencesHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class App extends Application {

    // Logger
    Logger logger = LoggerFactory.getLogger(App.class);

    // Content Handler
    private final ContentHandler contentHandler = new ContentHandler(this);

    // Preferences / Options
    Preferences preferences = PreferencesHandler.load("settings.json") ;

    // Placeholder node within App.fxml that can be used to
    // switch content in and out
    @FXML
    public ScrollPane mainSceneContent;

    public App() throws IOException {
    }

    // Startup
    @Override
    public void start(Stage stage) throws IOException {

        // loading fxml
        Parent startScene = contentHandler.loadFXMLtoParent("/fxml/App.fxml");

        // scene
        Scene scene = new Scene(startScene, Color.ALICEBLUE);

        // setting up window
        stage.setTitle("Logan the log analyst");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * THE MAIN application entry point
     * @param args not used, arguments to main
     */
    public static void main(String[] args) {
        launch(args);
    }


    // #### PAGES # ------------------------------------------------------------

    // Page: Options
    public void loadContentOptions(ActionEvent actionEvent) throws IOException {
        OptionsController controller = new OptionsController();
        contentHandler.loadContent("App-Options", this, controller);
    }

    // Page: Logs
    public void loadContentLogs(ActionEvent actionEvent) throws IOException {
        contentHandler.loadContent("App-Logs");
    }



    // #### Global Methods
    public void loadPreferences() throws IOException {
       PreferencesHandler.load("settings.json") ;
    }

    public void storePreferences() throws IOException {
        PreferencesHandler.store(this.preferences);
    }
}
