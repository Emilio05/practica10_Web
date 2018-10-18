package pucmm.inventarioequipos.model;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Where(clause = "deleted = 0")
public class Cliente implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Loader
    @Column(name = "imagen", columnDefinition = "BLOB")
    private byte[] imagen;

    private boolean deleted = false;

    @OneToMany(mappedBy = "cliente")
    private Set<ClienteEquipo> clienteEquipos = new HashSet<ClienteEquipo>();


    public Set<ClienteEquipo> getClienteEquipos() {
        return clienteEquipos;
    }

    public void setClienteEquipos(Set<ClienteEquipo> clienteEquipos) {
        this.clienteEquipos = clienteEquipos;
    }


    public  Cliente(){

    }
    public Cliente(String cedula, String nombre, LocalDate fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
