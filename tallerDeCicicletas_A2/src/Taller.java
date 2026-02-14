import java.util.ArrayList;

public class Taller {

    private ArrayList<Cliente> clientes;
    private ArrayList<Mecanico> mecanicos;
    private ArrayList<Orden> ordenes;
    private ArrayList<Repuesto> repuestos;

    public Taller(){
        clientes = new ArrayList<>();
        mecanicos = new ArrayList<>();
        ordenes = new ArrayList<>();
    }

    public boolean registrarCliente(Cliente cliente){
        if (buscarCliente(cliente.getId()) != null) return false;
        return clientes.add(cliente);
    }

    public Cliente buscarCliente(String id){
        for (Cliente cliente : clientes){
            if (id.equals(cliente.getId())){
                return cliente;
            }
        }
        return null;
    }

    public boolean registrarBicicleta(String idCliente, Bicicleta bicicleta){
        if (buscarCliente(idCliente) == null) return false;
        return buscarCliente(idCliente).agregarBicicleta(bicicleta);
    }

    public boolean registrarMecanico(Mecanico mecanico){
        if (buscarMecanico(mecanico.getId()) != null) return false;
        return mecanicos.add(mecanico);
    }

    public Mecanico buscarMecanico(String id){
        for (Mecanico mecanico : mecanicos){
            if (id.equals(mecanico.getId())){
                return mecanico;
            }
        }
        return null;
    }

    public boolean crearOrden(Orden orden){
        if (buscarOrden(orden.getCodigo()) != null) return false;
        return ordenes.add(orden);
    }

    public Orden buscarOrden(String codigo){
        for (Orden orden : ordenes){
            if (codigo.equals(orden.getCodigo())){
                return orden;
            }
        }
        return null;
    }

    public ArrayList<Orden> ordenesPorDia(String fecha){
        ArrayList<Orden> ordenesDia = new ArrayList<>();
        for (Orden orden : ordenes){
            if (fecha.equals(orden.getFecha())){
                ordenesDia.add(orden);
            }
        }
        return ordenesDia;
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

    /**
     * Elimina el repuesto con codigo x, si el repuesto no es encontrado retorna false, de lo contrario retorna el resultado de la operacion repuestos.remove(repuesto)
     * @param  codigo
     * @return resultado
     **/
    public boolean eliminarRepuesto(String codigo){
        if (buscarRepuesto(codigo) == null) return false;
        return repuestos.remove(buscarRepuesto(codigo));
    }

    /**
     * Registra Repuesto en una orden y se asegura de que no este registrado en otra orden
     * @param repuesto
     * @param orden
     * @return resultado de agregar repuesto en orden y eliminarlo del taller
     */
    public boolean agregarRepuestoEnOrden(String repuesto, String orden){
        if (buscarRepuesto(repuesto) == null && buscarOrden(orden) == null) return false;
        return buscarOrden(orden).registrarRepuesto(buscarRepuesto(repuesto));
    }

}
