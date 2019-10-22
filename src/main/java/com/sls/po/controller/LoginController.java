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

import com.sls.po.dao.UserRepository;
import com.sls.po.model.Quality;
import com.sls.po.model.User;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/api/v1/{ids}/authenticateByUserName", method = RequestMethod.GET)
	public Boolean authenticateByUserName(@PathVariable String ids) {
		boolean result = false;
		List<User> list = new ArrayList<User>();
		User userObj = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 1) {
				list = userRepository.findByUserName(params[0]);
				if (null != list && list.size() > 0) {
					userObj = list.get(0);
					if (userObj.getPassword().equals(params[1])) {
						result = true;
					}
				}
			}
		}

		return result;

	}

}
