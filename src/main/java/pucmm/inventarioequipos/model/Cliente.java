package pucmm.inventarioequipos.model;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;


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
    private Date fechaNacimiento;

    @Loader
    @Column(name = "imagen", columnDefinition = "BLOB")
    private byte[] imagen;

    private boolean deleted = false;


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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public byte[] getImagen() {
        return imagen;
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
