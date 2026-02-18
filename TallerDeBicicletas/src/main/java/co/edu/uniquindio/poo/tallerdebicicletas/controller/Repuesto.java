package co.edu.uniquindio.poo.tallerdebicicletas.controller;

public class Repuesto {

    private String nombre, codigo;

    public Repuesto(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

