package fr.grey.test;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @ManyToMany(mappedBy = "purchasedBooks")
    private List<Client> purchasedBy;

}
