package com.xz.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xz.user.entity.User;
import com.xz.user.service.IUserManager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserManager userManager;

	@RequestMapping("/addUser")
	public String addUser(User user) {
		if (userManager.addUser(user))
			return "redirect:/user/getAllUser";
		else
			return "/fail";
	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {
		if (userManager.updateUser(user)) {
			user = userManager.getOneUser(user);
			request.setAttribute("user", user);
			return "/UserEdit";
		} else {
			return "/fail";
		}
	}

	@RequestMapping("/delUser")
	public void delUser(User user, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (userManager.delUser(user))
			result = "{\"result\":\"success\"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "/UserAdd";
	}

	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(User user, HttpServletRequest request) {
		User user1 = userManager.getOneUser(user);
		request.setAttribute("user1", user1);
		return "/UserEdit";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {
		List<User> userList = userManager.getAllUser();
		request.setAttribute("userlist", userList);
		return "/UserMain";
	}
}
