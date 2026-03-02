package co.edu.uniquindio.poo.tallerdebicicletas.controler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Bicicleta;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Cliente;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Taller;

import javax.swing.*;
import java.util.Collection;

public class MenuClientesControler {

    Taller taller = App.taller;

    public Collection<Bicicleta> getBicicletas(String idCliente){
        return taller.buscarCliente(idCliente).getBicicletas();
    }

    public Cliente buscarCliente(String id){
        return taller.buscarCliente(id);
    }

    public void actualizarCliente(String nombre, String id, String telefono, String direccion){
        Cliente cliente = taller.buscarCliente(id);
        if (cliente != null){

            if (!nombre.isBlank() && !nombre.isEmpty()){
                cliente.setNombre(nombre);
            }

            if (!telefono.isBlank() && !telefono.isEmpty()){
                cliente.setTelefono(telefono);
            }

            if (!direccion.isBlank() && !direccion.isEmpty()){
                cliente.setDireccion(direccion);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente No Encontrado");
        }


    }

    public void quitarCliente(String id) {
        if (id != null && !id.isBlank()){
            if(!taller.eliminarCliente(id)){
                System.out.println("ERROR, cliente no eliminado");
            }
        }
    }

    public boolean verificarBici(String id, String serial) {
        if (taller.buscarCliente(id).buscarBicicleta(serial) != null){
            return true;
        }
        return false;
    }
}
