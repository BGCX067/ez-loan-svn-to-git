package com.ez.admin.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.ez.admin.dao.BankDAO;
import com.ez.model.entity.BankEntity;


/**
 * 
 * @author Sid
 * This is the add,update and delete for Banks
 *
 */

@Repository("BankDAOImpl")
@Scope("singleton")
@Transactional
public class BankDAOImpl implements BankDAO {

	@PersistenceContext(unitName="JPAezLoan")
	private EntityManager entityManager;
	
	

	@Override
	public String addBank(BankEntity bankEntity) {
		boolean  bbb=TransactionSynchronizationManager.isActualTransactionActive();
		System.out.println("bbbbbbb  =  "+bbb);
		entityManager.persist(bankEntity);
		return "bankAdded";
	}

	@Override
	public String updateBank(BankEntity bankEntity) {
		BankEntity bankEntity2 = entityManager.find(BankEntity.class,
				bankEntity.getBankId());
		bankEntity2.setAddress(bankEntity.getAddress());
		bankEntity2.setBranch(bankEntity.getBranch());
		bankEntity2.setContact(bankEntity.getContact());
		bankEntity2.setName(bankEntity.getName());
		entityManager.merge(bankEntity2);
		return "bankUpdated";
	}

	@Override
	public String deleteBank(int[] bankId) {
		for (int i : bankId) {
			Query query = entityManager
					.createQuery("delete from BankEntity bE where bE.bankId = :id");
			query.setParameter("id", i);
			int deleteRecord = query.executeUpdate();
		}
		return "banksDeleted";
	}

	@Override
	public List<BankEntity> bankList() {
		Query query = entityManager.createQuery("from BankEntity");
		List<BankEntity> bankList = (List<BankEntity>) query.getResultList();
		return bankList;
	}

	@Override
	public BankEntity bankById(int bankId) {
		BankEntity bankEntity = entityManager.find(BankEntity.class, bankId);
		return bankEntity;
	}
}
