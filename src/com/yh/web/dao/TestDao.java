/**   
* @Title: TestDao.java 
* @Package com.yh.web.dao 
* @Description: TODO 
* @author A18ccms A18ccms_gmail_com   
* @date 2018��3��2�� ����10:35:38 
* @version V1.0   
*/
package com.yh.web.dao;

import java.util.List;

import com.yh.web.model.Cswd_User;

/**
 * @author zhouy
 *  �ӿ���
 */
public interface TestDao {
	List<Object> query(String sql,Object[] params);
	int update(String sql,Object[] params);
}
