package com.ez.admin.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ez.admin.dao.BankDAO;
import com.ez.model.entity.BankEntity;


/**
 * 
 * @author nagendra.yadav
 *  
 *  JUNIT for DAO Layer and for running all these Junit
 *   we are using seperate test db
 *    
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(inheritLocations = true, locations = { "classpath*:test-ezloan-spring-root-application-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class BankDAOImplTest {
	
	@Autowired
	@Qualifier("BankDAOImpl")
	private BankDAO bankDAO;
	
	@BeforeClass
	public static  void init(){
		//System.out.println("This will execute only once");
		//Code for inserting testing data into database
	}

	@Test
	public void testAddBank() {
		BankEntity bankEntity=new BankEntity();
		bankEntity.setName("AMOG");
		bankEntity.setContact("9999900000");
		bankEntity.setBranch("FREMONT");
		bankEntity.setAddress("CA100");
		String success=bankDAO.addBank(bankEntity);
		assertNotNull("Result cannot be null",success);
		assertEquals("Result should be success","bankAdded", success);
	}
	
	@Test
	public void testBankById() {
		BankEntity dbank=bankDAO.bankById(1);
		assertNotNull("bank cannot be null",dbank);
		assertEquals("Bank id is mismatched",1, dbank.getBankId());
		assertEquals("Bank name is not matched","AMOG", dbank.getName());
		assertEquals("Bank Address is not matched","CA100", dbank.getAddress());
	}

	@Test
	public void testUpdateBank() {
		BankEntity bankEntity=new BankEntity();
		bankEntity.setBankId(1);
		bankEntity.setName("AMOG");
		bankEntity.setContact("55555");
		bankEntity.setBranch("FREMONT");
		bankEntity.setAddress("CA100");
		String result=bankDAO.updateBank(bankEntity);
		assertNotNull("Result should not be null",result);
		assertEquals("Record could not updated","bankUpdated", result);
		
		//Now fetching the data and validating it
		BankEntity dbank=bankDAO.bankById(1);
		assertNotNull("bank cannot be null",dbank);
		assertEquals("Bank id is mismatched",1, dbank.getBankId());
		assertEquals("Bank contact is not matched","55555", dbank.getContact());
	}

	@Test
	public void testBankList() {
		List<BankEntity> banks=bankDAO.bankList();
		assertNotNull("Bank list cannot be null",banks);
		assertEquals("Bank list cannot be empty",true, banks.size()>0);
	}

	@Test
	public void testDeleteBank() {
		String result=bankDAO.deleteBank(new int[]{1});
		assertNotNull("Result cannot be null",result);
		assertEquals("Bank record could not be deleted","banksDeleted", result);
	}

}
