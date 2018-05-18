package fr.grey.dao;

import fr.grey.test.Book;
import fr.grey.test.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDAO {
    public static void createClient(Client client){
        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        em.persist(client);
        DataBaseHelper.commitTxAndClose(em);
    }

    public static void updateClient(Client client){
        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        em.merge(client);
        DataBaseHelper.commitTxAndClose(em);
    }

    public static List<Book> getPurchasedBooks(Client client){

        EntityManager em =  DataBaseHelper.createEntityManager();
        DataBaseHelper.beginTx(em);
        TypedQuery<Book> query = em.createQuery(
                "select distinct b " +
                        "from Client c " +
                        "inner join c.purchasedBooks b " +
                        "where c.id=:id", Book.class);
        query.setParameter("id", client.getId());
        List<Book> books = query.getResultList();
        client.setPurchasedBooks(books);
        DataBaseHelper.commitTxAndClose(em);
        return books;
    }

}
