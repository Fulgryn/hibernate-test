package fr.grey.dao;

import fr.grey.test.Client;

import javax.persistence.EntityManager;

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


}
