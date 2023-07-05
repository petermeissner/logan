package de.petermeissner.logan;

import de.petermeissner.logan.misc.AppController;
import de.petermeissner.logan.misc.Preferences;
import de.petermeissner.logan.misc.PreferencesHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Controller class for Options.fxml
 */
public class OptionsController extends AppController {
    public TextArea optionsText;
    public TextArea directoryRegex;
    public TextArea directories;

    @FXML
    public void initialize() throws IOException {
//        optionsText.setText(PreferencesHandler.toJSONString(app.preferences));
        loadOptions();
    }

    @FXML
    void loadOptions() throws IOException {
        app.loadPreferences();
        updateUI();
    }

    void updateUI(){
        String s = PreferencesHandler.toJSONString(app.preferences);
        optionsText.textProperty().set(s);
        directoryRegex.textProperty().set(app.preferences.regex);
        directories.textProperty() .set(String.join("\n",app.preferences.directories));
    }

    @FXML
    void storeOptions() throws IOException {

        // get preferences
        Preferences p = new Preferences();
        p.regex = directoryRegex.getText();
        p.directories = directories.getText().split(" *\n *");

        // assign to global preference store and store to disk
        app.preferences = p;
        app.storePreferences();

        // do a reload to ensure options were stored correctly and update
        updateUI();
    }

    @FXML
    void generateLogfile(){
//        Logger myTestLogger = LoggerFactory.getLogger("MyTestLogger");
//        Logger superAwesomeMegaLogger= LoggerFactory.getLogger("SuperAwesomeMegaLogger");
//
//        FileHandler fh;
//
//        try {
//
//            // This block configure the logger with handler and formatter
//            fh = new FileHandler("C:/temp/test/MyLogFile.log");
//            logger.addHandler(fh);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);
//
//            // the following statement is used to log any messages
//            logger.info("My first log");
//
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        logger.info("Hi How r u?");
    }
}
