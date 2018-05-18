package fr.grey.dao;

import fr.grey.test.Book;
import fr.grey.test.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public static List<Client> getPurchasedBy(Book book){

        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        TypedQuery<Client> query = em.createQuery(
                "select distinct c " +
                        "from Book b " +
                        "inner join b.purchasedBy c " +
                        "where b.id=:id", Client.class);
        query.setParameter("id", book.getId());
        List<Client> clients = query.getResultList();
        book.setPurchasedBy(clients);
        DataBaseHelper.commitTxAndClose(em);
        return clients;
    }

}
