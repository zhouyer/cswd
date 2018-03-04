/**   
* @Title: TestImpl.java 
* @Package com.yh.web.impl 
* @Description: TODO 
* @author A18ccms A18ccms_gmail_com   
* @date 2018年3月3日 下午9:25:02 
* @version V1.0   
*/
package com.yh.web.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yh.web.dao.TestDao;
import com.yh.web.model.Cswd_User;
import com.yh.web.utils.DBHelper;

/**
 * @author zhouy 接口实现类
 */
public class TestImpl implements TestDao {
	@Override
	public List<Object> query(String sql, Object[] params) {
		DBHelper db= new DBHelper();
		return db.query(sql, params);
	}

	@Override
	public int update(String sql, Object[] params) {
		DBHelper db= new DBHelper();
		return db.update(sql, params); 
	}
}
