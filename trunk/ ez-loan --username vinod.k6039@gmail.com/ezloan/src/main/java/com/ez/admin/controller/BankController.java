/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ez.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.admin.service.BankService;
import com.ez.common.util.JUtils;
import com.ez.model.Bank;

/**
 * 
 * @author nagendra.yadav
 * 
 */
@Controller
@RequestMapping("/admin")
public class BankController {

	@Autowired
	@Qualifier("BankServiceImpl")
	private BankService bankService;

	/**
	 * 
	 * @param name
	 * @param branch
	 * @param address
	 * @param contact
	 * @return
	 */
	@RequestMapping(value = "addBank.htm", method = RequestMethod.POST)
	public String addBank(@RequestParam("name") String name, 
			@RequestParam("branch") String branch, 
			@RequestParam("address") String address, 
			@RequestParam("contact") String contact, Model model ) {
		Bank bank = new Bank();
		model.addAttribute("BANK", bank);
		bank.setName(name);
		bank.setBranch(branch);
		bank.setContact(contact);
		bank.setAddress(address);
		String sucess = bankService.addBank(bank);
		return "redirect: banks.htm";
	}

	@RequestMapping(value = "addBank.htm", method = RequestMethod.GET)
	public String addBank(ModelMap model) {
		Bank bank = new Bank();
		model.addAttribute("BANK", bank);
		return "addBank";
	}

	@RequestMapping(value = "deleteBank.htm", method = RequestMethod.POST)
	public String deleteBank(@RequestParam(value="checkboxids", required = false) String[] Id) {

		if(Id != null){
		JUtils jUtils = new JUtils();
		int[] idArray = jUtils.convertStringArraytoIntArray(Id);
		String result = bankService.deleteBank(idArray);
		}
		return "redirect: banks.htm";
	}

	@RequestMapping(value = "welcome.htm", method = RequestMethod.GET)
	public String showHome() {
		return "welcome";
	}

	@RequestMapping(value = "goToUpdate.htm", method = RequestMethod.GET)
	public String updateBank(@RequestParam("updateId") String Id, Model model) {

		int bankId = Integer.parseInt(Id);
		Bank bank = bankService.bankById(bankId);
		model.addAttribute("bankById", bank);
		
		return "updateBank";
	}

	@RequestMapping(value = "updateBank.htm", method = RequestMethod.POST)
	public String updateBank(@RequestParam("updateId") String Id,
			@RequestParam("name") String name,
			@RequestParam("branch") String branch,
			@RequestParam("contact") String contact,
			@RequestParam("address") String address) {

		Bank bank = new Bank();
		bank.setBankId(Integer.parseInt(Id));
		bank.setName(name);
		bank.setAddress(address);
		bank.setBranch(branch);
		bank.setContact(contact);
		String result = bankService.updateBank(bank);

		return "redirect:banks.htm";
	}

	// This controller will get all the Bank Names and Details from the
	// Database and populate it in the Banks.jsp page !!
	@RequestMapping(value = "banks.htm", method = RequestMethod.GET)
	public String getBanks(Model model) {
		List<Bank> temp = bankService.bankList();
		model.addAttribute("bankList", temp);

		return "banks";
	}

}
