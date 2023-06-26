package com.tropa.models;

import com.tropa.entities.Secretaria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SecretariaModel {
    private final SessionFactory sessionFactory;

    public SecretariaModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Secretaria> findAll() {
        List<Secretaria> secretarias = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            secretarias = session.createQuery("from Secretaria").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            secretarias = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return secretarias;
    }

    public Secretaria find(String cpf) {
        Secretaria secretaria = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            secretaria = session.get(Secretaria.class, cpf);
            transaction.commit();
        } catch (HibernateException e) {
            secretaria = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return secretaria;
    }

    public boolean create(Secretaria secretaria) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(secretaria);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean update(Secretaria secretaria) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(secretaria);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean delete(Secretaria secretaria) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(secretaria);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }
}
