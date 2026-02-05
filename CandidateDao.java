package com.votingmachine.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.votingmachine.config.HibernateUtil;
import com.votingmachine.model.Candidate;

public class CandidateDao {

    public void saveCandidate(Candidate candidate) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(candidate);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public void updateCandidate(Candidate candidate) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(candidate);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public Candidate getCandidateById(Long id) {
        Transaction transaction = null;
        Candidate candidate = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            candidate = session.get(Candidate.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
        return candidate;
    }

    public void deleteCandidate(Long id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Candidate candidate = session.get(Candidate.class, id);
            if (candidate != null) {
                session.delete(candidate);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }
}
