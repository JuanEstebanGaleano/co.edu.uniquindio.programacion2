package co.edu.uniquindio.programacion2trabajos.gestionBiblioteca.model;
import java.math.BigDecimal;
public class Multa {
    private Miembro miembro; // Debe ser del tipo Miembro
    private BigDecimal monto;
    private boolean pagada;
    public Multa(Miembro miembro, BigDecimal monto) {
        this.miembro = miembro;
        this.monto = monto;
        this.pagada = false; // Inicialmente no pagada
    }
    // Getters y Setters
    public Miembro getMiembro() {
        return miembro;
    }
    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public boolean isPagada() {
        return pagada;
    }
    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
    @Override
    public String toString() {
        return "Multa: " +
                "miembro=" + miembro.getIdMiembro() + // Mostrar ID del miembro
                ", monto=" + monto +
                ", pagada=" + pagada;
    }
}