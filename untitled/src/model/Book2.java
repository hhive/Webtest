package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book2 {
    private String bookId;
    private String title;

    private Author author;
    private Integer price;
    private String intro;
//    private String name;

    public Book2() {
    }

    public Book2(String bookId, String title,Author author, int price, String intro) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.intro = intro;
    }

    @Id
    @Column(name = "bookId")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "name")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book2 book2 = (Book2) o;
        return Objects.equals(bookId, book2.bookId) &&
                Objects.equals(title, book2.title) &&
                Objects.equals(author, book2.author) &&
                Objects.equals(price, book2.price) &&
                Objects.equals(intro, book2.intro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, price, intro);
    }

//    @Basic
//    @Column(name = "name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
