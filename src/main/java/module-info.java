module com.proyecto.navierajya {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proyecto.navierajya to javafx.fxml;
    exports com.proyecto.navierajya;
}