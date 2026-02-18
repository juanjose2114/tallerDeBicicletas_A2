package co.edu.uniquindio.poo.tallerdebicicletas.controller;

public class Mecanico extends Persona {

    private Especializacion especializacion;
    private String codigo;
    private boolean disponible;

    public Mecanico(String nombre, String id, String codigo, Especializacion especializacion) {
        super(nombre, id);
        this.codigo = codigo;
        this.especializacion =  especializacion;
        disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializacion especializacion) {
        this.especializacion = especializacion;
    }
}

