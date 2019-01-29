package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.ItemInfoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;

public class ItemInfoAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ItemInfoDAO itemInfoDAO=new ItemInfoDAO();
	private ArrayList<ItemInfoDTO> itemInfoList=new ArrayList<ItemInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(deleteFlg==null){
			itemInfoList=itemInfoDAO.getItemInfo();
		}else if(deleteFlg.equals("1")){
			delete();
		}

		String result=SUCCESS;
		return result;
	}

	public void delete() throws SQLException{

		int res=itemInfoDAO.ItemInfoDelete();

		if(res>0){
			itemInfoList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
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
	public ArrayList<ItemInfoDTO> getItemInfoList(){
		return this.itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList){
		this.itemInfoList=itemInfoList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message=message;
	}

}
