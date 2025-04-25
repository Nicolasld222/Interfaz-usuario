package model;

public class Apartamento {
    private int numero;
    private String dueno;
    private String inquilino;
    private int adultos;
    private int ninos;
    private double piscina;
    private double juegos;
    private double zonas;
    private double aseo;
    private double subtotal;
    private double descuento;
    private double totalPagar;

    public Apartamento(int numero, String dueno, String inquilino, int adultos, int ninos,
                       double piscina, double juegos, double zonas, double aseo,
                       double subtotal, double descuento, double totalPagar) {
        this.numero = numero;
        this.dueno = dueno;
        this.inquilino = inquilino;
        this.adultos = adultos;
        this.ninos = ninos;
        this.piscina = piscina;
        this.juegos = juegos;
        this.zonas = zonas;
        this.aseo = aseo;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.totalPagar = totalPagar;
    }

    public int getNumero() {
        return numero;
    }

    public String getDueno() {
        return dueno;
    }

    public String getInquilino() {
        return inquilino;
    }

    public int getAdultos() {
        return adultos;
    }

    public int getNinos() {
        return ninos;
    }

    public double getPiscina() {
        return piscina;
    }

    public double getJuegos() {
        return juegos;
    }

    public double getZonas() {
        return zonas;
    }

    public double getAseo() {
        return aseo;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }
}