package pucmm.inventarioequipos.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Where(clause = "deleted = 0")
public class Rol implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "nombreRol")
    private String nombreRol;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "usuario_id", nullable = true, updatable = false)
    private Usuario usuario;

    private boolean deleted = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
