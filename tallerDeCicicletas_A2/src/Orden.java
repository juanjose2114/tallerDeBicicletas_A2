import java.util.ArrayList;

public class Orden {
    private String  fecha, hora, describcion, codigo;
    private double costo;
    private Bicicleta bicicleta;
    private Mecanico mecanico;
    private ArrayList<Repuesto> repuestos;

    public Orden(String codigo, String fecha, String hora, String describcion, double costo, Bicicleta bicicleta, Mecanico mecanico) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.describcion = describcion;
        this.costo = costo;
        this.bicicleta = bicicleta;
        this.mecanico = mecanico;
        repuestos = new ArrayList<>();
        // mecanico.setDisponible(false);
    }

    public boolean registrarRepuesto(Repuesto repuesto){
        if (buscarRepuesto(repuesto.getCodigo()) != null) return false;
        return repuestos.add(repuesto);
    }

    public Repuesto buscarRepuesto(String codigo){
        for (Repuesto repuesto : repuestos){
            if (codigo.equals(repuesto.getCodigo())){
                return repuesto;
            }
        }
        return null;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescribcion() {
        return describcion;
    }

    public void setDescribcion(String describcion) {
        this.describcion = describcion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;

    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
