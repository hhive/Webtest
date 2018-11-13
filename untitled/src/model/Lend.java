package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Lend {
    private int id;
    private String name;
    private String isbn;
    private Date ltime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "ltime")
    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lend lend = (Lend) o;
        return id == lend.id &&
                Objects.equals(name, lend.name) &&
                Objects.equals(isbn, lend.isbn) &&
                Objects.equals(ltime, lend.ltime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isbn, ltime);
    }
}
