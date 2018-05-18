package fr.grey.test;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String lastname;

    @Column
    private String firstname;

    @Column
    private Gender genre;

    @ManyToOne
    private Book favoriteBook;

}
