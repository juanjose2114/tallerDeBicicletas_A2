package co.edu.uniquindio.poo.tallerdebicicletas.controler;

import co.edu.uniquindio.poo.tallerdebicicletas.App;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Especializacion;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Mecanico;
import co.edu.uniquindio.poo.tallerdebicicletas.model.Taller;

public class MenuMecanicosControler {

    Taller taller = App.taller;

    public void agregarMecanico(String nombre, String id, String codigo){
        taller.registrarMecanico(new Mecanico(nombre, id, codigo, Especializacion.BICICLETASELECTRICAS));
    }

    public void quitarMecanico(String id){
        //pendiente
    }

    public void modificarMecanico(String nombre, String id, String codigo, String espec, String disponibilidad){
        Mecanico mecanico = taller.buscarMecanico(id);
        if (mecanico != null){
            if (nombre.isBlank()){
                mecanico.setNombre(nombre);
            }
            if (codigo.isBlank()){
                mecanico.setCodigo(codigo);
            }
        }
    }

    public Mecanico buscarMecanico(String id){
        return taller.buscarMecanico(id);
    }
}
