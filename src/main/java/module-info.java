module com.gamedemons.lance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.gamedemons.lance to javafx.fxml;
    exports com.gamedemons.lance;
}