package com.ez.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ez.admin.dao.BankDAO;
import com.ez.admin.service.BankService;
import com.ez.model.Bank;
import com.ez.model.entity.BankEntity;

@Service("BankServiceImpl")
public class BankServiceImpl implements BankService {
	
	public void show(){
		//TODO
		System.out.println("___FONE____");
		System.out.println("___FONE____");
		System.out.println("___FONE____");
		System.out.println("___FONE____");
		System.out.println("___FONE____");
	}

	@Autowired
	@Qualifier("BankDAOImpl")
	private BankDAO bankDAO;
	
	public BankDAO getBankDAO() {
		return bankDAO;
	}

	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}

	@Override
	public String addBank(Bank bank) {
		BankEntity bankEntity = BeanUtils.instantiate(BankEntity.class);
		BeanUtils.copyProperties(bank, bankEntity, new String[] { "bankId" });
		String success = bankDAO.addBank(bankEntity);
		return success;
	}

	@Override
	public String deleteBank(int[] bankId) {
		return bankDAO.deleteBank(bankId);
	}

	@Override
	public ArrayList<Bank> bankList() {
		List<BankEntity> bankEntityList = bankDAO.bankList();
		List<Bank> bankList = new ArrayList<Bank>();
		for (BankEntity entity : bankEntityList) {
			Bank bank = new Bank(entity.getBankId(), entity.getName(),
					entity.getAddress(), entity.getBranch(),
					entity.getContact());
			bankList.add(bank);
		}
		return (ArrayList<Bank>) bankList;

	}

	@Override
	public String updateBank(Bank bank) {

		BankEntity bankEntity = BeanUtils.instantiate(BankEntity.class);
		BeanUtils.copyProperties(bank, bankEntity);
		return bankDAO.updateBank(bankEntity);

	}

	@Override
	public Bank bankById(int bankId) {

		Bank bank = BeanUtils.instantiate(Bank.class);
		BankEntity bankEntity = bankDAO.bankById(bankId);
		BeanUtils.copyProperties(bankEntity, bank);
		return bank;

	}

}
