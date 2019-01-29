package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;

public class UserListDeleteCompleteAction extends ActionSupport{
	private UserListDeleteCompleteDAO dao=new UserListDeleteCompleteDAO();

	public String execute(){
		dao.UserListDelete();

		String result=SUCCESS;
		return result;
	}

}