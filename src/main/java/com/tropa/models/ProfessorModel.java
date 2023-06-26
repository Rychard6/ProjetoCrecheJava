package com.tropa.models;

import com.tropa.entities.Professor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProfessorModel {
    private final SessionFactory sessionFactory;

    public ProfessorModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Professor> findAll() {
        List<Professor> professores = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            professores = session.createQuery("from Professor").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            professores = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return professores;
    }

    public Professor find(int codigo) {
        Professor professor = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            professor = session.get(Professor.class, codigo);
            transaction.commit();
        } catch (HibernateException e) {
            professor = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return professor;
    }

    public boolean create(Professor professor) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(professor);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean update(Professor professor) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(professor);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean delete(Professor professor) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(professor);
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
