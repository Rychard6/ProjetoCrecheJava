package com.tropa.models;

import com.tropa.entities.Responsavel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ResponsavelModel {
    private final SessionFactory sessionFactory;

    public ResponsavelModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Responsavel> findAll() {
        List<Responsavel> responsaveis = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            responsaveis = session.createQuery("from Responsavel").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            responsaveis = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return responsaveis;
    }

    public Responsavel find(String cpf) {
        Responsavel responsavel = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            responsavel = session.get(Responsavel.class, cpf);
            transaction.commit();
        } catch (HibernateException e) {
            responsavel = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return responsavel;
    }

    public boolean create(Responsavel responsavel) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(responsavel);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean update(Responsavel responsavel) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(responsavel);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean delete(Responsavel responsavel) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(responsavel);
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
