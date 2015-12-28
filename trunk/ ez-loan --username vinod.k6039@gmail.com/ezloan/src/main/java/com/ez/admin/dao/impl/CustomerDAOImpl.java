package com.ez.admin.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.ez.admin.dao.CustomerDAO;
import com.ez.model.entity.CustomerEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Repository("CustomerDAOImpl")
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(CustomerDAOImpl.class);
	

	//This is similar to session in hibernate
	@PersistenceContext(unitName="JPAezLoan")
	private EntityManager entityManager;
	public Query customerquery;
/*	
	@PersistenceContext(unitName="JPAHistory")
	private EntityManager historyEntityManager;*/

	@Override
	public String addCustomer(CustomerEntity customerEntity) {
		System.out.println("TransactionSynchronizationManager.isActualTransactionActive()   =  "+TransactionSynchronizationManager.isActualTransactionActive());
		entityManager.persist(customerEntity);
		if(logger.isDebugEnabled())
			logger.debug("_____data is persisted into ezload database____");
		System.out.println("___PERSISTING DATA IN entityManagerFactory");
		return "CustomerSaved";
	}
	
	/**
	 * Method which return whole customer data as per user name
	 * @param username
	 * @return CustomerEntity object when user name exist otherwise null
	 * when user name is not present inside the application name.
	 */
	@Override
	public CustomerEntity findCustomerByUserName(String username){
		Query query = entityManager.createQuery("FROM CustomerEntity cle WHERE cle.uname = :cleUserName");
		query.setParameter("cleUserName", username);
		List<CustomerEntity> loginlist = (List<CustomerEntity>) query
				.getResultList();
		if (loginlist != null && loginlist.size() == 1) { 
			return loginlist.get(0); 
		}	
		return null; 
	}


	@Override
	public String validateCustomer(String username, String password) {
		Query query = entityManager.createNamedQuery("getUsersByUnamePassword");
		query.setParameter("cleUserName", username);
		query.setParameter("clePassword", password);
		List<CustomerEntity> loginlist = (List<CustomerEntity>) query
				.getResultList();
		if (loginlist != null && loginlist.size() == 0) { 
			for (CustomerEntity customerLoginEntity : loginlist) {
				System.out.println("UNAME " + customerLoginEntity.getUname());
			}
			return "InvalidSession"; 
		} else {
			return "welcome";
		}
	}


	@Override
	public List<CustomerEntity> customerList(String applicationStatus) {
		
		if(applicationStatus.equalsIgnoreCase("ALL")){
		customerquery = entityManager.createQuery("from CustomerEntity");
		}
		else{
			customerquery = entityManager.createQuery("from CustomerEntity ce where ce.applicationStatus = :applicationStatus");;
			customerquery.setParameter("applicationStatus", applicationStatus);
		}
		List<CustomerEntity> customerList = (List<CustomerEntity>)customerquery.getResultList();
		return customerList;
	}


	@Override
	public String decideCustomer(CustomerEntity customerEntity) {
		CustomerEntity entity = entityManager.find(CustomerEntity.class,customerEntity.getId());
		entity.setApplicationStatus(customerEntity.getApplicationStatus());
		entityManager.merge(entity);
		return "CustomerUpdated";
	}

}
