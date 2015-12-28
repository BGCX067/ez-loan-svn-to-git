package com.ez.admin.service;

import java.util.ArrayList;


import com.ez.model.Bank;



public interface BankService {
	
	public String addBank(Bank bank);
	public String updateBank(Bank bank);
	public String deleteBank(int[] bankId);
	public Bank bankById(int bankId);
	
	public ArrayList<Bank> bankList();
	
}
