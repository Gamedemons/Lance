module com.gamedemons.lance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gamedemons.lance to javafx.fxml;
    exports com.gamedemons.lance;
}