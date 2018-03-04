/**   
* @Title: TestDao.java 
* @Package com.yh.web.dao 
* @Description: TODO 
* @author A18ccms A18ccms_gmail_com   
* @date 2018年3月2日 上午10:35:38 
* @version V1.0   
*/
package com.yh.web.dao;

import java.util.List;

import com.yh.web.model.Cswd_User;

/**
 * @author zhouy
 *  接口类
 */
public interface TestDao {
	List<Object> query(String sql,Object[] params);
	int update(String sql,Object[] params);
}
