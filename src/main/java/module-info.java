module de.petermeissner.myshapes {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;


    opens de.petermeissner.myshapes to javafx.fxml;
    exports de.petermeissner.myshapes;
    exports de.petermeissner;
    opens de.petermeissner to javafx.fxml;
    exports de.petermeissner.logan;
    opens de.petermeissner.logan to javafx.fxml;
}
