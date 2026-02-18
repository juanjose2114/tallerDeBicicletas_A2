module co.edu.uniquindio.poo.tallerdebicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.tallerdebicicletas to javafx.fxml;
    exports co.edu.uniquindio.poo.tallerdebicicletas;
    exports co.edu.uniquindio.poo.tallerdebicicletas.controller;
    opens co.edu.uniquindio.poo.tallerdebicicletas.controller to javafx.fxml;
}