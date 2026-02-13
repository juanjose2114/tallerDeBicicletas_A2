import java.util.ArrayList;

public class Taller {

    private ArrayList<Cliente> clientes;
    private ArrayList<Mecanico> mecanicos;
    private ArrayList<Orden> ordenes;

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

}
