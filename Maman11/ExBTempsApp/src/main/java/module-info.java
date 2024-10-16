module org.example.temperatures {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens org.example.temperatures to javafx.fxml;
    exports org.example.temperatures;
}