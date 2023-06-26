package com.tropa.models;

import com.tropa.entities.Aluno;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AlunoModel {
    private final SessionFactory sessionFactory;

    public AlunoModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            alunos = session.createQuery("from Aluno").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            alunos = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return alunos;
    }

    public Aluno find(int codigo) {
        Aluno aluno = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            aluno = session.get(Aluno.class, codigo);
            transaction.commit();
        } catch (HibernateException e) {
            aluno = null;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return aluno;
    }

    public boolean create(Aluno aluno) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(aluno);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean update(Aluno aluno) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(aluno);
            transaction.commit();
        } catch (HibernateException e) {
            success = false;
            if (transaction != null) transaction.rollback();
        } finally {
            if (session != null) session.close();
        }

        return success;
    }

    public boolean delete(Aluno aluno) {
        boolean success = true;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(aluno);
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
