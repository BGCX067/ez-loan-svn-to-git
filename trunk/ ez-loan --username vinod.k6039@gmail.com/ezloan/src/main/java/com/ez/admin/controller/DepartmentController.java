package com.ez.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.admin.service.DepartmentService;
import com.ez.common.util.JUtils;
import com.ez.model.Department;

@Controller
@RequestMapping("/admin")
public class DepartmentController {
	
	@Autowired
	@Qualifier("DepartmentServiceImpl")
	private DepartmentService departmentService;
	
	@RequestMapping(value = "getdepartments.htm", method = RequestMethod.GET)
	public String showDepartments(Model model) {	
		List<Department> deptList = departmentService.departmentList();
		model.addAttribute("departmentList", deptList);
		return "departments";
	}
	
	@RequestMapping(value="addDepartment.htm",method=RequestMethod.POST)
	public String addDepartment(@RequestParam(value="name") String name, 
			@RequestParam(value="code") String code,
			@RequestParam(value="contact") String contact){
		
		Department department = new Department();
		department.setName(name);
		department.setContact(contact);
		department.setCode(code);
		String success = departmentService.addBank(department);
		return "redirect: getdepartments.htm";
	}
	
	@RequestMapping(value="deleteDepartment.htm", method=RequestMethod.POST)
	public String deleteBank(@RequestParam(value="checkboxids", required=false) String[] Id){
		
		if(Id != null){
		JUtils jUtils = new JUtils();
		int[] idArray = jUtils.convertStringArraytoIntArray(Id);
		String result = departmentService.deleteDept(idArray);
		}
		return "redirect: getdepartments.htm";
	}
	
	
	@RequestMapping(value = "updateDepartment.htm", method = RequestMethod.POST)
	public String updateBank(
			@RequestParam("updateId") String Id,@RequestParam("name") String name,
			@RequestParam("code") String code,
			@RequestParam("contact") String contact) {

		Department department = new Department();
		int id = Integer.parseInt(Id);
		department.setDeptId(id);
		department.setName(name);
		department.setCode(code);
		department.setContact(contact);
		String result = departmentService.updateDepartment(department);

		return "redirect:getdepartments.htm";
	}
	
	@RequestMapping(value = "goToDepartmentUpdate.htm", method = RequestMethod.GET)
	public String updateBank(@RequestParam("updateId") String Id, Model model) {

		int departmentId = Integer.parseInt(Id);
		Department department = departmentService.departmentById(departmentId);
		model.addAttribute("departmentById", department);
		
		/*Bank bank = bankService.bankById(bankId);
		model.addAttribute("bankById", bank);*/
		
		return "updateDepartment";
	}
	
}
