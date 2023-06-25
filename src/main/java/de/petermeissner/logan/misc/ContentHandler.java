package de.petermeissner.logan.misc;

import de.petermeissner.logan.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ContentHandler {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(ContentHandler.class);

    // Reference to JavaFX Application to load content for
    private final App app;

    // Default init storing reference t application for which to load content
    public ContentHandler(App app) {
        this.app = app;
    }

    /**
     * Simple loader for fxml files from resources/fxml.
     * If given only the name of the fxml it will create the resource path on the fly.
     *
     * @param fname resource path or fxml name
     * @return FXMLLoader
     */
    public FXMLLoader loadFXML(String fname) {

        // check if name or path was provided
        boolean isPath = Util.strMatches(fname, ".*/.*");

        // handle non path
        if (!isPath) {
            fname = "/fxml/" + fname + ".fxml";
        }


        FXMLLoader parent = new FXMLLoader(
                Util.checkNull(app.getClass().getResource(fname))
        );
        return parent;
    }

    public Parent loadFXMLtoParent(String fname) throws IOException {
        FXMLLoader loader = loadFXML(fname);
        return loader.load();
    }


    /**
     * Load content from fxml and inserting it into app at specific content placeholder
     *
     * @param fxmlName   FXML name/fileName to load
     * @param app        Application object to add content to
     * @param controller controller class to initialize and set as controller of fxml
     * @throws IOException
     */
    public void loadContent(String fxmlName, App app, AppController controller) throws IOException {

        // fxml loader
        FXMLLoader fxmlLoader = loadFXML(fxmlName);

        // set controller
        controller.setApp(app);
        fxmlLoader.setController(controller);
        Parent fxmlInstance = fxmlLoader.load();

        // replace content
        app.root.getChildren().removeAll();
        app.root.getChildren().set(0, fxmlInstance);
    }
}
