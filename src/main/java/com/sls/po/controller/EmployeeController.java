package com.sls.po.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sls.po.bo.IndentBo;
import com.sls.po.bo.IndentBoImpl;
import com.sls.po.dao.*;
import com.sls.po.model.*;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/api/v1/getallemployee", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {

		List<Employee> list = new ArrayList<Employee>();

		for (Employee customer : employeeRepository.findAll()) {
			list.add(customer);
			// System.out.println(customer);
		}

		return list;

	}

}
