package com.tropa.models;

import com.tropa.entities.Turma;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TurmaModel {
    private final SessionFactory sessionFactory;

    public TurmaModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Turma> findAll() {
        List<Turma> turmas = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            turmas = session.createQuery("from Turma").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            turmas = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return turmas;
    }

    public Turma find(Long id) {
        Turma turma = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            turma = session.get(Turma.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            turma = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return turma;
    }

    public boolean create(Turma turma) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(turma);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean update(Turma turma) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(turma);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean delete(Turma turma) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(turma);
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
