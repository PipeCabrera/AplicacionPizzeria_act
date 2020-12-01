package Clases;

public class Clientes {

    private String id;
    private String Nombre;
    private String Destino;
    private String Promocion;

    public Clientes()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getPromocion() {
        return Promocion;
    }

    public void setPromocion(String promocion) {
        Promocion = promocion;

    }
    public String toString() {return Nombre;}
}
