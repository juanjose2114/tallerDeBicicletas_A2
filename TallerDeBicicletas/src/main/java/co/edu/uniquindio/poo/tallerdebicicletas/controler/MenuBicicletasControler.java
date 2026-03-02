package co.edu.uniquindio.poo.tallerdebicicletas.controler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Bicicleta;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Cliente;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Orden;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Taller;

import java.util.ArrayList;
import java.util.Collection;

public class MenuBicicletasControler {

    Taller taller = App.taller;

    public Cliente buscarPropietario(String serial){
        for (Cliente c : taller.getClientes()){
            if (c.buscarBicicleta(serial) != null){
                return c;
            }
        }
        return null;
    }

    public Bicicleta buscarBicicleta(String id, String serial) {
        Cliente cliente = taller.buscarCliente(id);
        if (cliente != null){
            return cliente.buscarBicicleta(serial);
        }
        return null;
    }

    public Collection<Orden> getHistorial(String serial) {
        ArrayList<Orden> historialBici = new ArrayList<>();
        for (Orden o : taller.getOrdenes()){
            if (serial.equals(o.getBicicleta().getSerial())){
                historialBici.add(o);
            }
        }
        return historialBici;
    }

    public boolean setBicicleta(String id, String serial, String marca, String tipo, String color, String edad){
        if (taller.buscarCliente(id) == null || taller.buscarCliente(id).buscarBicicleta(serial) == null ) {
            return false;
        }
        Bicicleta bicicleta = taller.buscarCliente(id).buscarBicicleta(serial);
        if (marca != null || !marca.isBlank()){
            bicicleta.setMarca(marca);
        }
        if (tipo != null || !tipo.isEmpty()){
            bicicleta.setTipo(tipo);
        }
        if (color != null || color.isBlank()){
            bicicleta.setColor(color);
        }
        if (edad != null || edad.isBlank()){
            bicicleta.setEdad(edad);
        }
        return true;
    }

    public void quitarBici(String id, String serial){
        if (taller.buscarCliente(id) != null && taller.buscarCliente(id).buscarBicicleta(serial) != null ) {
            taller.buscarCliente(id).eliminarBicicleta(serial);
        }
    }

    public void agregarBici(String id, String serial, String marca, String tipo, String edad, String color) {
        taller.buscarCliente(id).agregarBicicleta(new Bicicleta(marca, tipo, color, serial, edad));
    }
}
