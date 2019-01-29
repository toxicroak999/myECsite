package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;

public class UserListAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private UserListDAO userListDAO=new UserListDAO();
	private ArrayList<UserListDTO> userList=new ArrayList<UserListDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(deleteFlg==null){
			userList=userListDAO.getUserList();
		}else if(deleteFlg.equals("1")){
			delete();
		}

		String result=SUCCESS;
		return result;
	}

	public void delete() throws SQLException{

		int res=userListDAO.UserListDelete();

		if(res>0){
			userList=null;
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res==0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}
	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public ArrayList<UserListDTO> getUserList(){
		return this.userList;
	}

	public void setUserList(ArrayList<UserListDTO> userList){
		this.userList=userList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

}
