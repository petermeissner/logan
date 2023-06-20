module de.petermeissner.logan {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires org.json;


    opens de.petermeissner.logan to javafx.fxml;
    exports de.petermeissner.logan;

    opens de.petermeissner.logan.misc to javafx.fxml;
    exports de.petermeissner.logan.misc;
}
