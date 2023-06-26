package com.tropa.models;

import com.tropa.entities.Mensalidade;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MensalidadeModel {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public List<Mensalidade> findAll() {
        List<Mensalidade> mensalidades = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            mensalidades = session.createQuery("from Mensalidade").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            mensalidades = null;
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
        
        return mensalidades;
    }
    
    public Mensalidade find(int codigo) {
        Mensalidade mensalidade = null;

        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            mensalidade = session.get(Mensalidade.class, codigo);
            transaction.commit();
        } catch (HibernateException e) {
            mensalidade = null;
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
        
        return mensalidade;        
    }
    
    public boolean create(Mensalidade mensalidade) {
        boolean res = true;

        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(mensalidade);
            transaction.commit();
        } catch (HibernateException e) {
            res = false;
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
        
        return res;          
    }
    
    public boolean update(Mensalidade mensalidade) {
        boolean res = true;

        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(mensalidade);
            transaction.commit();
        } catch (HibernateException e) {
            res = false;
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
        
        return res;          
    }
        
    public boolean delete(Mensalidade mensalidade) {
        boolean res = true;

        Session session = null;
        Transaction transaction = null;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(mensalidade);
            transaction.commit();
        } catch (HibernateException e) {
            res = false;
            if(transaction != null) transaction.rollback();
        } finally {
            if(session != null) session.close();
        }
        
        return res;          
    }
}
