package pucmm.inventarioequipos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "alquiler")
public class ClienteEquipo implements Serializable {

    private long id;
    private Cliente cliente;
    private Equipo equipo;

    @Column(name = "fechaInicioAlquiler")
    private Date fechaInicioAlquiler;
    @Column(name = "fechaFinAlquiler")
    private Date fechaFinAlquiler;

    public Date getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(Date fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public Date getFechaFinAlquiler() {
        return fechaFinAlquiler;
    }

    public void setFechaFinAlquiler(Date fechaFinAlquiler) {
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
    public long getId()
    {
        return id;
    }

    public void setId(long id){
        this.id  = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id")
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
