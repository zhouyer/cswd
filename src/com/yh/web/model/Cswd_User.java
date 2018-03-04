/**   
* @Title: Cswd_User.java 
* @Package com.yh.web.model 
* @Description: TODO 
* @author A18ccms A18ccms_gmail_com   
* @date 2018年3月3日 下午9:08:36 
* @version V1.0   
*/
package com.yh.web.model;

import java.util.Date;

/**
 * @author zhouy
 * 用户模型
 */
public class Cswd_User {
	private int user_id;
	private String user_name;
	private String user_pwd;
	private Date user_register_time;
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @return the user_pwd
	 */
	public String getUser_pwd() {
		return user_pwd;
	}
	/**
	 * @return the user_register_time
	 */
	public Date getUser_register_time() {
		return user_register_time;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @param user_pwd the user_pwd to set
	 */
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	/**
	 * @param user_register_time the user_register_time to set
	 */
	public void setUser_register_time(Date user_register_time) {
		this.user_register_time = user_register_time;
	}
}
