package pucmm.inventarioequipos.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Where(clause = "deleted = 0")
public class Factura implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "fechaFacturacion")
    private Date fechaFacturacion;
    @Column(name = "montoTotal")
    private float montoTotal;

    @OneToMany(mappedBy = "factura")
    private Set<FacturaEquipo> facturaEquipos = new HashSet<FacturaEquipo>();

    public Set<FacturaEquipo> getFacturaEquipos() {
        return facturaEquipos;
    }

    public void setFacturaEquipos(Set<FacturaEquipo> equipos) {
        this.facturaEquipos = equipos;
    }

    private boolean deleted = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
