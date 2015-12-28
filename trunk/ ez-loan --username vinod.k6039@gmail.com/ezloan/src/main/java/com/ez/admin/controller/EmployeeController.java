package com.ez.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.admin.service.DepartmentService;
import com.ez.admin.service.EmployeeService;
import com.ez.aop.exception.advice.EZLoanException;
import com.ez.model.Department;
import com.ez.model.Employee;
import com.ez.model.EmployeeListWrapper;
import com.ez.model.SpringFormItems;

@Controller
@RequestMapping("/admin")
public class EmployeeController {

	@Autowired
	@Qualifier("DepartmentServiceImpl")
	private DepartmentService departmentService;

	@Autowired
	@Qualifier("EmployeeServiceImpl")
	private EmployeeService employeeService;

	private String department = "ALL";

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Method which would be called from java script
	 * to generated list of employees as a json response by department name 
	 * @param departmentName
	 *  department name send from ajax call. 
	 * @return
	 * json response to render on the view
	 */
	@RequestMapping(value = "employeeByDepartmentName", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody EmployeeListWrapper findEmployeeByDepartmentName(
			@RequestParam(value = "departmentName", required = false) String departmentName) {
		this.department=departmentName;
		List<Employee> empList = employeeService.employeeList(departmentName);
		EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
		employeeListWrapper.setEmployees(empList);
		return employeeListWrapper;
	}

	@RequestMapping(value = "populateEmp.htm", method = RequestMethod.GET)
	public String populateEmp(Model model) {
		try {
		List<Department> deptList = departmentService.departmentList();
		addDepttOption(deptList);
		// <option>Select Employees</option>
		// <option>ALL</option>
		model.addAttribute("departmentList", deptList);
		List<Employee> empList = employeeService.employeeList(this
				.getDepartment());
		model.addAttribute("empList", empList);
		SpringFormItems formItems = new SpringFormItems();
		formItems.setSelecteddept(this.getDepartment());
		model.addAttribute("formItems", formItems);
		}catch (EZLoanException e) {
		   System.out.println(e.getMessage());
		   System.out.println(e.getCause());
		   return "sorry";
		}
		return "employees";
	}

	/**
	 * 
	 * @param deptList
	 */
	private void addDepttOption(List<Department> deptList) {
		Department select = new Department();
		select.setName("Select Employees");
		Department all = new Department();
		all.setName("ALL");
		if (deptList != null) {
			deptList.add(0, select);
			deptList.add(1, all);
		}
	}

	@RequestMapping(value = "empByDept.htm", method = RequestMethod.GET)
	public String getEmpList(
			@ModelAttribute("formItems") SpringFormItems department, Model model) {
		this.setDepartment(department.getSelecteddept());
		return "redirect:populateEmp.htm";
	}

	@RequestMapping(value = "addEmp.htm", method = RequestMethod.POST)
	public String addEmployee(@RequestParam(value = "empName") String empName,
			@RequestParam(value = "designation") String designation,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "contact") String contact,
			@RequestParam(value = "department") String department) {

		Employee emp = new Employee();
		emp.setContact(contact);
		emp.setDesignation(designation);
		emp.setEmail(email);
		emp.setEmpName(empName);
		String success = employeeService.addEmployee(emp, department);
		return "redirect: populateEmp.htm";
	}

}
