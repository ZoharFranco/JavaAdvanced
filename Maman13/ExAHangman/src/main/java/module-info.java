module org.example.maman13a {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens org.example.maman13a to javafx.fxml;
    exports org.example.maman13a;
}