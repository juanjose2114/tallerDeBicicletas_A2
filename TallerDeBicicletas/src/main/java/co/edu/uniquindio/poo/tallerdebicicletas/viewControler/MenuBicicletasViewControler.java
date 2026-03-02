package co.edu.uniquindio.poo.tallerdebicicletas.viewControler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.controler.MenuBicicletasControler;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Bicicleta;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Cliente;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Orden;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class MenuBicicletasViewControler {

    App app;
    Cliente cliente;
    Bicicleta bicicleta;
    ObservableList<Orden> historial = FXCollections.observableArrayList();
    MenuBicicletasControler controler;

//----------------------------------------------------------------------------------------------------------------------

    @FXML
    public Button btn_volver;

    @FXML
    public Button btn_buscar;

    @FXML
    public Button btn_modificar;

    @FXML
    public Button btn_quitar;

    @FXML
    public Button btn_agregarBici;


    @FXML
    public TextField txt_nombre;

    @FXML
    public TextField txt_id;

    @FXML
    public TextField txt_marca;

    @FXML
    public TextField txt_tipo;

    @FXML
    public TextField txt_color;

    @FXML
    public TextField txt_serial;

    @FXML
    public TextField txt_edad;


    @FXML
    public TableView<Orden> tbl_historial;

    @FXML
    public TableColumn<Orden, String> cln_describcionH;

    @FXML
    public TableColumn<Orden, String> cln_fechaH;


//----------------------------------------------------------------------------------------------------------------------

    @FXML
    public void menuCliente(){
        if(app != null) {
            app.openViewMenuClientes(cliente.getId());
        } else {
            System.err.println("Error: La referencia a App es nula");
            throw new IllegalStateException("La referencia a App no ha sido establecida");
        }
    }

    @FXML
    public void buscarBicicleta(){
        System.out.println(".");
        Bicicleta bicicleta = controler.buscarBicicleta(cliente.getId(), txt_serial.getText());
        System.out.println(".");
        if (bicicleta != null){
            System.out.println("..");
            this.bicicleta = bicicleta;
            System.out.println(".");
            initVoid();
            System.out.println(".");
        } else {
            System.out.println(".,");
            JOptionPane.showMessageDialog(null, "Bicicleta No Encontrada");
            limpiar();
        }
        System.out.println(".");
    }

    @FXML
    public void modificarBicicleta(){
        if (!controler.setBicicleta(txt_id.getText(), txt_serial.getText(), txt_marca.getText(), txt_tipo.getText(), txt_color.getText(), txt_edad.getText())){
            JOptionPane.showMessageDialog(null, "ERROR, bici no modificada");
        }
        bicicleta = controler.buscarBicicleta(cliente.getId(), txt_serial.getText());
        initVoid();
    }

    @FXML
    public void quitarBicicleta(){
        controler.quitarBici(cliente.getId(), txt_serial.getText());
        limpiar();
    }

    @FXML
    public void agregarBici(){
        if (controler.buscarBicicleta(txt_id.getText(), txt_serial.getText()) == null){
            controler.agregarBici(txt_id.getText(), txt_serial.getText(), txt_marca.getText(), txt_tipo.getText(), txt_edad.getText(), txt_color.getText());
        }

    }





    public void initVoid(){
        limpiar();
        tbl_historial.setItems(null);
        initDataBinding();
        obtenerHistorial(txt_serial.getText());
        tbl_historial.setItems(historial);
    }

    public void initDataBinding(){
        cln_fechaH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        cln_describcionH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescribcion()));
    }

    public void limpiar(){
        txt_nombre.setText(cliente.getNombre());
        txt_id.setText(cliente.getId());

        txt_marca.setText(bicicleta.getMarca());
        txt_tipo.setText(bicicleta.getTipo());
        txt_color.setText(bicicleta.getColor());
        txt_edad.setText(bicicleta.getEdad());
        txt_serial.setText(bicicleta.getSerial());
    }

    public void obtenerHistorial(String serial){
        historial.clear();
        historial.addAll(controler.getHistorial(serial));
    }




    public void initialize(){
        controler = new MenuBicicletasControler();
    }

    public void setApp(App app, String serialBici){
        this.app = app;
        this.cliente = controler.buscarPropietario(serialBici);
        bicicleta = controler.buscarBicicleta(controler.buscarPropietario(serialBici).getId(), serialBici);
        initVoid();
    }
}
