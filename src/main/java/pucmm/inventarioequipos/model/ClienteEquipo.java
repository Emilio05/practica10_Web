package pucmm.inventarioequipos.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "alquiler")
@Where(clause = "deleted = 0")
public class ClienteEquipo implements Serializable {


    @Column(name = "fechaInicioAlquiler")
    private LocalDate fechaInicioAlquiler;
    @Column(name = "fechaFinAlquiler")
    private LocalDate fechaFinAlquiler;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "costo")
    private float costo;
    @Column(name = "subtotal")
    private float subtotal;
    @Column(name = "total")
    private float total;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(LocalDate fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public LocalDate getFechaFinAlquiler() {
        return fechaFinAlquiler;
    }

    public void setFechaFinAlquiler(LocalDate fechaFinAlquiler) {
        this.fechaFinAlquiler = fechaFinAlquiler;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "estado")
    private String estado;

    @Id
    @GeneratedValue
    @Column(name = "alquiler_id")
    private long id;

    private boolean deleted = false;

    public long getId()
    {
        return id;
    }

    public void setId(long id){
        this.id  = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
