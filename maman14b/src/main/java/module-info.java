module org.example.maman14b {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.maman14b to javafx.fxml;
    exports org.example.maman14b;
}