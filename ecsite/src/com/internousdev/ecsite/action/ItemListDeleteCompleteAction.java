package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;

public class ItemListDeleteCompleteAction extends ActionSupport{
	private ItemListDeleteCompleteDAO dao=new ItemListDeleteCompleteDAO();

	public String execute(){
		dao.ItemInfoDelete();

		String result=SUCCESS;
		return result;
	}

}
