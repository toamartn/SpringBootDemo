package com.mss.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.demo.bean.Employee;
import com.mss.demo.dao.EmployeeDAODataJPA;
import com.mss.demo.entities.EmployeeMapping;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAODataJPA employeeDAO;

	public List<Employee> getAllEmployees() {
		
		List<EmployeeMapping> empMapList = employeeDAO.findAll();
		List<Employee> employeeList = new ArrayList<Employee>();
		
		for(EmployeeMapping rec : empMapList) {
			Employee emp = new Employee();
			employeeList.add(emp);
			BeanUtils.copyProperties(rec, emp);
		}
		return employeeList;
	}

	public Employee getEmployee(int id) {
		EmployeeMapping empMapping = employeeDAO.findOne(id);
		Employee emp = new Employee();
		BeanUtils.copyProperties(empMapping, emp);
		return emp;
	}

	public Employee createEmployee(Employee emp) {
		EmployeeMapping employeeMapping = new EmployeeMapping();
		BeanUtils.copyProperties(emp, employeeMapping);
		employeeMapping = employeeDAO.save(employeeMapping);
		BeanUtils.copyProperties(employeeMapping, emp);
		return emp;
	}

	public Employee updateEmployee(Employee employee) {
		
		if(employee == null || !employeeDAO.exists(employee.getEmpId()) ){
			System.out.println(employeeDAO.exists(employee.getEmpId()));
			System.out.println("No record exist with id "+employee.getEmpId());
			return null;
		}
		EmployeeMapping employeeMapping = new EmployeeMapping();
		BeanUtils.copyProperties(employee, employeeMapping);
		employeeMapping = employeeDAO.save(employeeMapping);
		BeanUtils.copyProperties(employeeMapping, employee);
		return employee;
	}

	public Employee deleteEmployee(int id) {
		
		EmployeeMapping employeeMapping = employeeDAO.findOne(id);
		if(employeeMapping!=null) {
			employeeDAO.delete(new Integer(id));
		}
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeMapping, employee);
		return employee;
	}
}