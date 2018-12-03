package pucmm.topograpp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Entity(name = "Practica")
@Table(name = "Practica")
@Where(clause = "deleted = 0")

public class Practica implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name ="plano", columnDefinition="BLOB", nullable = true)
    private byte[] plano;

    @Column(name = "area")
    private Float area;


    @Column(name = "owner")
    private String owner;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name = "conclusion")
    private String conclusion;

    @Column(name = "estado")
    private String estado;

    @JsonIgnore
    @OneToMany(  mappedBy = "practica", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Peticion> peticiones = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Practice_User",
            joinColumns = { @JoinColumn(name = "practice_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Usuario> integrantes = new HashSet<>();


    @JsonIgnore
    @OneToOne(mappedBy = "practica", cascade = CascadeType.ALL, orphanRemoval =  true, fetch = FetchType.EAGER)
    private Levantamiento levantamiento;

    public void setId(long id) {
        this.id = id;
    }

    public Set<Usuario> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Set<Usuario> integrantes) {
        this.integrantes = integrantes;
    }

    public Set<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(Set<Peticion> peticiones) {
        this.peticiones = peticiones;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }



    private boolean deleted = false;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Levantamiento getLevantamiento() {
        return levantamiento;
    }

    public void setLevantamiento(Levantamiento levantamiento) {
        this.levantamiento = levantamiento;
    }

    public Float getArea() {
        if(area == null)this.area=0f;
        return area;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPlano() {
        if(plano !=null) {
            return Base64.getEncoder().encodeToString(plano);
        }
        else{
            return "";
        }
    }

    public void setPlano(byte[] plano) {
        this.plano = plano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
