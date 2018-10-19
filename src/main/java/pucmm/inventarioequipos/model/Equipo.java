package pucmm.inventarioequipos.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Entity
@Where(clause = "deleted = 0")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "nombreEquipo")
    private String nombreEquipo;
    @Column(name = "precio")
    private float precio;
    @Column(name = "existencia")
    private int existencia;
    @Loader
    @Column(name = "imagen", columnDefinition = "BLOB")
    private byte[] imagen;


    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "categoria_id", nullable = true, updatable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "subfamilia_id", nullable = true, updatable = false)
    private SubFamilia subFamilia;


    private boolean deleted = false;

    @OneToMany(mappedBy = "equipo")
    private Set<ClienteEquipo> clienteEquipos = new HashSet<ClienteEquipo>();


    public Set<ClienteEquipo> getClienteEquipos() {
        return clienteEquipos;
    }

    public void setClienteEquipos(Set<ClienteEquipo> clienteEquipos) {
        this.clienteEquipos = clienteEquipos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getImagen() {
        return Base64.getEncoder().encodeToString(imagen);

    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public SubFamilia getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(SubFamilia subFamilia) {
        this.subFamilia = subFamilia;
    }
}
