package org.jboss.as.quickstarts.helloworld;

import Entrega.Entrega;

import javax.persistence.*;
import java.util.List;

public class ServiceEntrega {


    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("SDP_Project");



    public static void getDelivery(int id_entrega) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Entrega c WHERE c.id_entrega = :id_entrega";
        TypedQuery<Entrega> tq = em.createQuery(query, Entrega.class);
        tq = tq.setParameter("id_entrega", id_entrega);
        Entrega entrega = null;

        try {
            entrega = tq.getSingleResult();
            System.out.println(entrega.getNome_item() + " " +
                    entrega.getLocal() + " " +
                    entrega.getQuantidade_entrega() + " " +
                    entrega.getTelemovel());
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    public static void altLocal(int id_entrega, String local){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Entrega entrega = null;
        try {
            et = em.getTransaction();
            et.begin();
            entrega = em.find(Entrega.class, id_entrega);
            entrega.setLocal(local);
            em.persist(entrega);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }




}
