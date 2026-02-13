public class Bicicleta {
    //marca, tipo, color, serial, edad
    public String marca, tipo, color, serial;
    public int edad;

    public Bicicleta(String marca, String tipo, String color, String serial, int edad){
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
