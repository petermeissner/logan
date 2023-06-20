package de.petermeissner.logan;

import de.petermeissner.logan.misc.AppController;
import de.petermeissner.logan.misc.PreferencesHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;


/**
 * Controller class for Options.fxml
 */
public class OptionsController extends AppController {
    public TextArea optionsText;


    @FXML
    public void initialize(){
        optionsText.setText(PreferencesHandler.toJSONString(app.preferences));
    }

    @FXML
    void loadOptions() throws IOException {
        app.loadPreferences();
        String s = PreferencesHandler.toJSONString(app.preferences);
        optionsText.textProperty().set(s);
    }

    @FXML
    void storeOptions() throws IOException {
        String s = optionsText.textProperty().get();
        app.preferences = PreferencesHandler.fromJSONString(s);
        app.storePreferences();
    }
}
