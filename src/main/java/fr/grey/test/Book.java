package fr.grey.test;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", initialValue = 1)
    @GeneratedValue(generator = "book_id_seq")
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @ManyToMany(mappedBy = "purchasedBooks")
    private List<Client> purchasedBy;

    public Book() {
    }

    public Book(String title, String author) {
        this();
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Client> getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(List<Client> purchasedBy) {
        this.purchasedBy = purchasedBy;
    }


}
