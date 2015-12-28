package com.ez.admin.dao;


import java.util.List;

import com.ez.model.entity.BankEntity;

public interface BankDAO {
	
	public String addBank(BankEntity bankEntity);
	public String updateBank(BankEntity bankEntity);
	public String deleteBank(int[] bankId);
	public BankEntity bankById(int bankId);
	public List<BankEntity> bankList(); 

}

