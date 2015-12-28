package com.ez.admin.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ez.admin.dao.impl.BankDAOImpl;
import com.ez.model.Bank;
import com.ez.model.entity.BankEntity;

/**
 * @author nagendra.yadav
 *  This is junit for service layer
 *  Here we have mocked DAO Layer using mockito mocking framework
 *  
 */
@RunWith(MockitoJUnitRunner.class)
public class BankServiceImplTest {

	//mocking dao layer
	@Mock
	 private BankDAOImpl bankDAOImpl;
	
	//Actual business layer which has to be tested
	private BankServiceImpl bankServiceImpl;
	
	@Before
	public void init() {
		
		bankServiceImpl=new BankServiceImpl();
		//injecting mock DAL into the service layer
		bankServiceImpl.setBankDAO(bankDAOImpl);
		//stub the data stubbing
		BankEntity bank=new BankEntity();
		bank.setBankId(0);
		bank.setAddress("Fremont");
		bank.setBranch("FremontB");
		bank.setContact("9999900000");
		bank.setName("amog");
		//Stubbing 
		when(bankDAOImpl.addBank(bank)).thenReturn("success");
		
		
		//Stubbing delete functionality
		when(bankDAOImpl.deleteBank(new int[]{1000})).thenReturn("success");
		
		//Creating mock data for displaying the list of the banks registered into the application
		List<BankEntity> bankEntities=new ArrayList<BankEntity>();
		BankEntity bankEntity1=new BankEntity();
		bankEntity1.setBankId(100);
		bankEntity1.setAddress("Fremont");
		bankEntity1.setBranch("FremontB");
		bankEntity1.setContact("9999900000");
		bankEntity1.setName("amog");
		
		BankEntity bankEntity2=new BankEntity();
		bankEntity2.setBankId(200);
		bankEntity2.setAddress("COLO");
		bankEntity2.setBranch("Mock");
		bankEntity2.setContact("432234");
		bankEntity2.setName("mkkaa");
		
		bankEntities.add(bankEntity1);
		bankEntities.add(bankEntity2);
		//Stubbing list banks functionality
		when(bankDAOImpl.bankList()).thenReturn(bankEntities);
		
		
		//Stubbing update bank by id functionality
		when(bankDAOImpl.updateBank(bankEntity2)).thenReturn("success");
		
		//Stubbing find bank by id functionality
		when(bankDAOImpl.bankById(0)).thenReturn(bank);
		
	}
	
	@Test
	public void testAddBank() {
		Bank pbank=new Bank();
		pbank.setBankId(0);
		pbank.setAddress("Fremont");
		pbank.setBranch("FremontB");
		pbank.setContact("9999900000");
		pbank.setName("amog");
		String result=bankServiceImpl.addBank(pbank);
		assertNotNull("Result cannot be null",result);
		assertEquals("Result should be success","success", result);
	}

	@Test
	public void testDeleteBank() {
		String result=bankServiceImpl.deleteBank(new int[]{1000});
		assertNotNull("Result cannot be null",result);
		assertEquals("Bank record could not be deleted","success", result);
	}

	@Test
	public void testBankList() {
		List<Bank> banks=bankServiceImpl.bankList();
		assertNotNull("Bank list cannot be null",banks);
		assertEquals("Bank list cannot be empty",true, banks.size()>0);
	}

	@Test
	public void testUpdateBank() {
		Bank pbank=new Bank();
		pbank.setBankId(200);
		pbank.setAddress("COLO");
		pbank.setBranch("Mock");
		pbank.setContact("432234");
		pbank.setName("mkkaa");
		String result=bankServiceImpl.updateBank(pbank);
		assertNotNull("Result should not be null",result);
		assertEquals("Record could not updated","success", result);
	}

	@Test
	public void testBankById() {
		Bank bank=bankServiceImpl.bankById(0);
		assertNotNull("bank cannot be null",bank);
		assertEquals("Bank id is mismatched",0, bank.getBankId());
		assertEquals("Bank name is not matched","amog", bank.getName());
		assertEquals("Bank Address is not matched","Fremont", bank.getAddress());
	}

}
