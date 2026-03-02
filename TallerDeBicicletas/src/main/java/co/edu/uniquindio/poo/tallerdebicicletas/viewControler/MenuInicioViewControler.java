package co.edu.uniquindio.poo.tallerdebicicletas.viewControler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.controler.MenuInicioControler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuInicioViewControler {

    MenuInicioControler menuInicioControler;
    App app;

    @FXML
    public Button btn_clientes;

    @FXML
    public Button btn_mecanicos;

    @FXML
    public Button btn_ordenes;

    @FXML
    public void initialize(){
        menuInicioControler = new MenuInicioControler();
    }


    @FXML
    public void openMenuClientes(){
        if(app != null) {
            app.openViewMenuClientes("");
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openMenuMecanicos(){
        if(app != null) {
            app.openViewMenuMecanicos();
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void openMenuOrdenes(){
        if(app != null) {
            app.openViewMenuOrdenes();
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }


    public void setApp(App app){
        this.app = app;
    }
}
