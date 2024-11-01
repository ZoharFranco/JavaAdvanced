module org.example.maman12b {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens org.example.maman12b to javafx.fxml;
    exports org.example.maman12b;
}