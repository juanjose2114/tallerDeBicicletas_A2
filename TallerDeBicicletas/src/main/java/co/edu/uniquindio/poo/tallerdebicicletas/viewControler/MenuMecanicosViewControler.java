package co.edu.uniquindio.poo.tallerdebicicletas.viewControler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.controler.MenuMecanicosControler;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Mecanico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuMecanicosViewControler {

    MenuMecanicosControler controler;
    Mecanico mecanico;
    App app;

//----------------------------------------------------------------------------------------------------------------------

    @FXML
    public Button btn_agregar;

    @FXML
    public Button btn_quitar;

    @FXML
    public Button btn_modificar;

    @FXML
    public Button btn_buscar;

    @FXML
    public Button btn_volver;


    @FXML
    public TextField txt_nombre;;

    @FXML
    public TextField txt_id;

    @FXML
    public TextField txt_codigo;

    @FXML
    public TextField txt_espec;

    @FXML
    public TextField txt_disponibilidad;

//----------------------------------------------------------------------------------------------------------------------


    @FXML
    public void agregar(){
        controler.agregarMecanico(txt_nombre.getText() ,txt_id.getText() ,txt_codigo.getText());
        mecanico = controler.buscarMecanico(txt_id.getText());
        limpiar();
    }

    @FXML
    public void quitar(){
        controler.quitarMecanico(txt_id.getText());
    }

    @FXML
    public void modificar(){
        controler.modificarMecanico(txt_nombre.getText() ,txt_id.getText() ,txt_codigo.getText() ,txt_espec.getText() ,txt_disponibilidad.getText());
        limpiar();
    }

    @FXML
    public void buscar(){
        mecanico = controler.buscarMecanico(txt_id.getText());
        limpiar();
    }

    @FXML
    public void menuInicio(){
        app.openViewMenuInicio();
    }



    public void limpiar(){
        txt_nombre.setText(mecanico.getNombre());
        txt_codigo.setText(mecanico.getCodigo());
        txt_espec.setText(mecanico.getEspecializacion() + "");
        txt_disponibilidad.setText(mecanico.isDisponible() + "");
    }

    public void initialize(){
        controler = new MenuMecanicosControler();
    }

    public void setApp(App app){
        this.app = app;
    }
}
