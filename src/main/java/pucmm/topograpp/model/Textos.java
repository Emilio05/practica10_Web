package pucmm.topograpp.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "Textos")
@Table(name = "Textos")
@Where(clause = "deleted = 0")
public class Textos implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "content", nullable = false)
    private String content;



    private boolean deleted = false;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
