package pucmm.inventarioequipos.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "deleted = 0")
public class SubFamilia implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "nombreSubFamilia")
    private String nombreSubFamilia;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "categoria_id", nullable = true, updatable = false)
    private Categoria categoria;

    @OneToMany(  mappedBy = "subFamilia", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Equipo> equipos = new ArrayList<>();

    private boolean deleted = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreSubFamilia() {
        return nombreSubFamilia;
    }

    public void setNombreSubFamilia(String nombreSubFamilia) {
        this.nombreSubFamilia = nombreSubFamilia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
