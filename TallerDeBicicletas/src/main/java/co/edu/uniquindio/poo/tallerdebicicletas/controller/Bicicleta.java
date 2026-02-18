package co.edu.uniquindio.poo.tallerdebicicletas.controller;

public class Bicicleta {
    private String marca, tipo, color, serial, edad;

    public Bicicleta(String marca, String tipo, String color, String serial, String edad){
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.serial = serial;
        this.edad = edad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
