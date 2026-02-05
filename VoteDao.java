package com.votingmachine.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.votingmachine.config.HibernateUtil;
import com.votingmachine.model.Vote;

public class VoteDao {
	
	
	public  void saveVote(Vote vote) {
		
		Transaction transaction=null;
		
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.save(vote);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
	}
	
	
	//  UPdate 
	
	
	public void updateVote(Vote vote) {
		Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			session.save(vote);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
		}
	}
	
	
	public Vote getVoteById(Long id) {
		
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()) {
			Vote vote=null;
			transaction =session.beginTransaction();
			
			vote=session.get( Vote.class,id);
			
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return null;
		
	}

	
	public void deleteVote(long id) {
		Transaction transaction=null;
		Vote vote=null;
		
		try(Session session =HibernateUtil.getSessionFactory().openSession()) {
			transaction=session.beginTransaction();
			vote =session.get(Vote.class,id);
			
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
		}
		
	}
}
