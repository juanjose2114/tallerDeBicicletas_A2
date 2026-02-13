public class Main {
    static void main() {
        Taller t = new Taller();
        Cliente c = new Cliente("n", "1", "1", "d");
        t.registrarCliente(c);
        Bicicleta b = new Bicicleta("m", "m", "c", "s", 1);
        System.out.println(t.registrarBicicleta("1", b));
    }

}
