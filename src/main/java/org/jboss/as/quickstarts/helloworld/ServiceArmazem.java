package org.jboss.as.quickstarts.helloworld;

import Armazem.Armazem;

import javax.persistence.*;
import java.util.List;

public class ServiceArmazem {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("SDP_Project");



    public static void registerProduct(int id, String nome, String tipo, String descricao) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try{
            et = em.getTransaction();
            et.begin();
            Armazem produto = new Armazem();
            produto.setId(id);
            produto.setNome(nome);
            produto.setTipo(tipo);
            produto.setDescricao(descricao);
            em.persist(produto);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();

        }
    }


    public static void addProduct(int id, int quantidade) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Armazem produto = null;

        try{
            et = em.getTransaction();
            et.begin();
            produto = em.find(Armazem.class, id);
            produto.setQuantidade(quantidade);
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

    public static void altDescricao(int id, String descricao){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Armazem produto = null;
        try {
            et = em.getTransaction();
            et.begin();
            produto = em.find(Armazem.class, id);
            produto.setDescricao(descricao);
            em.persist(produto);
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

    public static String getProduto(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Armazem c WHERE c.id = :item_id";
        TypedQuery<Armazem> tq = em.createQuery(query, Armazem.class);
        tq = tq.setParameter("item_id", id);
        Armazem prod = null;


        try {
            prod = tq.getSingleResult();
            System.out.println(prod.getNome() + " " + prod.getQuantidade() + " " +
                    prod.getTipo() + " " + prod.getDescricao());
        } catch (NoResultException e) {
            e.printStackTrace();
        } finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
        return query;
    }

    public static String getProdutos(String tipo) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT c FROM Armazem c WHERE c.tipo IS NOT NULL";
        TypedQuery<Armazem> tq = em.createQuery(strQuery, Armazem.class);
        List<Armazem> prods;
        try {
            prods = tq.getResultList();
            prods.forEach(prod -> System.out.println(prod.getNome() + " " +
                    prod.getQuantidade() + " " +
                    prod.getTipo() + " " +
                    prod.getDescricao()));

        } catch (NoResultException e) {
            e.printStackTrace();
        }
        finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();

        }
        return strQuery;

    }

    public static void deleteProduto(int id){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Armazem produto;
        try {
            et = em.getTransaction();
            et.begin();
            produto = em.find(Armazem.class , id);
            em.remove(produto);
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

    public static void getStock() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT c FROM Armazem c WHERE c.quantidade IS NOT NULL";
        TypedQuery<Armazem> tq = em.createQuery(strQuery, Armazem.class);
        List<Armazem> prods;
        try {
            prods = tq.getResultList();
            prods.forEach(prod -> System.out.println(prod.getNome() + " " +
                    prod.getTipo() + " " +
                    prod.getDescricao()));

        } catch (NoResultException e) {
            e.printStackTrace();
        }
        finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();

        }

    }

}
