import java.util.ArrayList;

public class Cliente {

    private String nombre, id, telefono, direccion;
    private ArrayList<Bicicleta> bicicletas;

    public Cliente(String nombre, String id, String telefono, String direccion){
        bicicletas = new ArrayList<>();
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public boolean agregarBicicleta(Bicicleta bicicleta){
        if (buscarBicicleta(bicicleta.getSerial()) != null) return false;
        return bicicletas.add(bicicleta);
    }

    public boolean eliminarBicicleta(String serial){
        Bicicleta bicicleta = buscarBicicleta(serial);
        if (bicicleta != null) return bicicletas.remove(bicicleta);
        return false;
    }

    public Bicicleta buscarBicicleta(String serial){
        for (Bicicleta bicicleta : bicicletas){
            if (serial.equals(bicicleta.getSerial())){
                return bicicleta;
            }
        }
        return null;
    }
}
