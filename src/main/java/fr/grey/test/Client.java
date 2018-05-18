package fr.grey.test;

import javax.persistence.*;

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


}
