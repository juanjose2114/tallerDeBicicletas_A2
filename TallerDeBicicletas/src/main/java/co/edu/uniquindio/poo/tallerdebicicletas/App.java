
package co.edu.uniquindio.poo.tallerdebicicletas;

import co.edu.uniquindio.poo.tallerdebicicletas.model.*;
import co.edu.uniquindio.poo.tallerdebicicletas.viewControler.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;
    public static Taller taller = new Taller();

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Menu de inicio Taller");
        inicializarData();
        openViewMenuInicio();
    }

    /*
     Manejo de escenas
     */

    /**
     * open view, abre la escena con distintivo fxmlPath que se envia desde el open view correspondiente
     * no modificar sin autorizacion o se cae todo
     * @param fxmlPath de la interfaz a abrir
     */
    public void openView(String fxmlPath, String especial){
        try {
            System.out.println("creando loader");
            FXMLLoader loader = new FXMLLoader();
            System.out.println("configurando Loader con: " + fxmlPath);
            loader.setLocation(getClass().getResource(fxmlPath));
            System.out.println("parent root\n-----" + loader.getLocation());
            Parent root = loader.load();
            System.out.println("llamado el setApp\n-----" + fxmlPath);
            switch (fxmlPath){
                case "MenuInicio.fxml":
                    MenuInicioViewControler controller1 = loader.getController();
                    controller1.setApp(this);
                    break;
                case "MenuClientes.fxml":
                    MenuClientesViewControler controller2 = loader.getController();
                    controller2.setApp(this, especial);
                    break;
                case "MenuMecanicos.fxml":
                    MenuMecanicosViewControler controller3 = loader.getController();
                    controller3.setApp(this);
                    break;
                case "MenuOrdenes.fxml":
                    MenuOrdenesViewControler controller4 = loader.getController();
                    controller4.setApp(this);
                    break;
                case "MenuBicicletas.fxml":
                    MenuBicicletasViewControler controller5 = loader.getController();
                    controller5.setApp(this, especial);
                    break;
            }

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception exception) {

            //imprime error
            System.err.println("Error al cargar FXML:");
            exception.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("No se pudo cargar la interfaz:" + exception.getMessage());
            alert.showAndWait();
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Abre la escena asociada con MenuInicio
     */
    public void openViewMenuInicio(){
        openView("MenuInicio.fxml", null);
    }

    public void openViewMenuClientes(String id){
        openView("MenuClientes.fxml", id);
    }

    public void openViewMenuMecanicos(){
        openView("MenuMecanicos.fxml", null);
    }

    public void openViewMenuOrdenes(){
        openView("MenuOrdenes.fxml", null);
    }

    public void openViewMenuBicicletas(String serial){
        openView("MenuBicicletas.fxml", serial);
    }


    /*
    metodos ecenciales no tan ecenciales
     */

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * datos iniciales para el programa
     * Usuarios, Vehiculos, Mecanicos, Repuestos u Ordenes
     * Cualquier otro debe ser manejado con cuidado
     * NO AGREGAR TALLER
     */
    public void inicializarData(){
        taller.registrarCliente(new Cliente("cliente1", "1", "111", "dirrecion1"));
        taller.registrarCliente(new Cliente("cliente2", "2", "112", "dirrecion2"));
        taller.registrarCliente(new Cliente("cliente3", "3", "113", "dirrecion3"));
        taller.registrarBicicleta("1", new Bicicleta("reñol1", "tipo1", "blue1", "1", "1"));
        taller.registrarBicicleta("1", new Bicicleta("reñol2", "tipo2", "blue2", "2", "2"));
        taller.registrarBicicleta("2", new Bicicleta("reñol3", "tipo3", "blue3", "3", "3"));
        taller.registrarBicicleta("2", new Bicicleta("reñol4", "tipo4", "blue4", "4", "4"));
        taller.registrarBicicleta("3", new Bicicleta("reñol5", "tipo5", "blue5", "5", "5"));
        taller.registrarBicicleta("3", new Bicicleta("reñol6", "tipo6", "blue6", "6", "6"));

        taller.registrarMecanico(new Mecanico("mecanico2", "4", "1", Especializacion.BICICLETASELECTRICAS));

        taller.crearOrden(new Orden("1", "1", "1", "arreglo 1 de bici 1", 1, taller.buscarCliente("1").buscarBicicleta("1"), taller.buscarMecanico("4")));
    }
}