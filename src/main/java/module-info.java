module com.gmail.edelpjhon.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.gmail.edelpjhon.tictactoe to javafx.fxml;
    exports com.gmail.edelpjhon.tictactoe;
}