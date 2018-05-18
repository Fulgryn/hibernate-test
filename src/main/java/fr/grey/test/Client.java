package fr.grey.test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {



    @Id
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", initialValue = 1)
    @GeneratedValue(generator = "client_id_seq")
    private Long id;

    @Column
    private String lastname;

    @Column
    private String firstname;

    @Column
    private Gender genre;

    @ManyToOne
    private Book favoriteBook;

    @ManyToMany
    private List<Book> purchasedBooks;

    public Client() {
    }

    public Client(String lastname, String firstname, Gender genre) {
        this();
        this.lastname = lastname;
        this.firstname = firstname;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Gender getGenre() {
        return genre;
    }

    public void setGenre(Gender genre) {
        this.genre = genre;
    }

    public Book getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(Book favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(List<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public void addPurcharsedBook(Book book){
        if (this.purchasedBooks == null) {
            this.purchasedBooks = new ArrayList<>();
        }
        purchasedBooks.add(book);
    }
}
