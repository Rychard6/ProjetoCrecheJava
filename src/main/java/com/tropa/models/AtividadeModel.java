package com.tropa.models;

import com.tropa.entities.Atividade;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AtividadeModel {
    private final SessionFactory sessionFactory;

    public AtividadeModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Atividade> findAll() {
        List<Atividade> atividades = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            atividades = session.createQuery("from Atividade").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            atividades = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return atividades;
    }

    public Atividade find(int codigo) {
        Atividade atividade = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            atividade = session.get(Atividade.class, codigo);
            transaction.commit();
        } catch (HibernateException e) {
            atividade = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return atividade;
    }

    public boolean create(Atividade atividade) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(atividade);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean update(Atividade atividade) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(atividade);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean delete(Atividade atividade) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(atividade);
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
