package fr.grey.dao;

import fr.grey.test.Book;

import javax.persistence.EntityManager;

public class BookDAO {

    public static void createBook(Book book){
        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        em.persist(book);
        DataBaseHelper.commitTxAndClose(em);
    }

    public static void updateBook(Book book){
        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        em.merge(book);
        DataBaseHelper.commitTxAndClose(em);
    }

}
