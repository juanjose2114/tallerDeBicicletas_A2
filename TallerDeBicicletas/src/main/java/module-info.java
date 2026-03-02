module co.edu.uniquindio.poo.tallerdebicicletas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.tallerdebicicletas to javafx.fxml;
    exports co.edu.uniquindio.poo.tallerdebicicletas;

    opens co.edu.uniquindio.poo.tallerdebicicletas.controler;
    exports co.edu.uniquindio.poo.tallerdebicicletas.controler;

    opens co.edu.uniquindio.poo.tallerdebicicletas.model;
    exports co.edu.uniquindio.poo.tallerdebicicletas.model;

    opens co.edu.uniquindio.poo.tallerdebicicletas.viewControler;
    exports co.edu.uniquindio.poo.tallerdebicicletas.viewControler;
}