package co.edu.uniquindio.poo.tallerdebicicletas.viewControler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.controler.MenuClientesControler;

import co.edu.uniquindio.poo.tallerdebicicletas.model.Bicicleta;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class MenuClientesViewControler {

    MenuClientesControler controler;
    App app;
    Cliente cliente;
    Bicicleta bicicletatbl;

    ObservableList<Bicicleta> bicicletas = FXCollections.observableArrayList();

//----------------------------------------------------------------------------------------------------------------------

    @FXML
    public Button btn_buscar;

    @FXML
    public Button btn_actualizar;

    @FXML
    public Button btn_quitar;

    @FXML
    public Button btn_volver;

    @FXML
    public Button btn_bicicletas;

    @FXML
    public TextField txt_nombre;

    @FXML
    public TextField txt_id;

    @FXML
    public TextField txt_telefono;

    @FXML
    public TextField txt_direccion;

    @FXML
    public TextField txt_serial;


    @FXML
    public TableView<Bicicleta> tbl_bicicletas;

    @FXML
    public TableColumn<Bicicleta, String> cln_marca;

    @FXML
    public TableColumn<Bicicleta, String> cln_tipo;

    @FXML
    public TableColumn<Bicicleta, String> cln_serial;

    @FXML
    public TableColumn<Bicicleta, String> cln_edad;

    @FXML
    public TableColumn<Bicicleta, String> cln_color;


//----------------------------------------------------------------------------------------------------------------------



    @FXML
    public void buscarCliente(){
        Cliente cliente = controler.buscarCliente(txt_id.getText());
        if (cliente != null){
            this.cliente = cliente;
            initVoid();
        } else {
            JOptionPane.showMessageDialog(null, "Cliente No Encontrado");
            limpiar();
        }
    }

    @FXML
    public void actualizarCliente() {
        controler.actualizarCliente(txt_nombre.getText(), txt_id.getText(), txt_telefono.getText(), txt_direccion.getText());
        limpiar();
    }

    @FXML
    public void quitar(){
        controler.quitarCliente(txt_id.getText());
        limpiar();
    }

    @FXML
    public void menuBicicletas() {
        if (controler.verificarBici(cliente.getId(), txt_serial.getText())){
            app.openViewMenuBicicletas(txt_serial.getText());
        }
    }

    @FXML
    public void menuInicio() {
        app.openViewMenuInicio();
    }



    public void initVoid() {
        limpiar();
        tbl_bicicletas.setItems(null);
        initDataBinding();
        obtenerBicicletas(cliente.getId());
        tbl_bicicletas.refresh();
        tbl_bicicletas.setItems(bicicletas);
        listSelection();
    }

    private void initDataBinding(){
        cln_marca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        cln_tipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));
        cln_serial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSerial()));
        cln_edad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));
        cln_color.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
    }

    private void obtenerBicicletas(String idCliente) {
        bicicletas.clear();
        bicicletas.addAll(controler.getBicicletas(idCliente));
    }

    private void listSelection(){
        tbl_bicicletas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bicicletatbl = newValue;
            mostrarBicicleta(bicicletatbl);
        });
    }

    public void mostrarBicicleta(Bicicleta bicicleta){
        if (bicicleta!=null){
            txt_serial.setText(bicicleta.getSerial());
        }
    }

    public void limpiar(){
        txt_nombre.setText(cliente.getNombre());
        txt_id.setText(cliente.getId());
        txt_telefono.setText(cliente.getTelefono());
        txt_direccion.setText(cliente.getDireccion());
        txt_serial.setText("");
    }

    public void initialize(){
        controler = new MenuClientesControler();
    }

    public void setApp(App app, String id){
        this.app = app;
        controler.buscarCliente(id);
    }
}
