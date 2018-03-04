/**   
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018年3月3日 下午11:52:27   
 */
package com.yh.web.service;

import java.util.List;

import com.yh.web.dao.TestDao;
import com.yh.web.impl.TestImpl;

/**
 * @author Administrator
 *
 */
public class TestServiceImpl implements TestService {
	TestDao testDao= new TestImpl();
	@Override
	public List<Object> getTestList() {
		String sql="select * from cswd_user";
		return testDao.query(sql, null);
	}

	@Override
	public int insertTest(Object[] params) {
		String sql="insert into cswd_user(user_name,user_pwd) "
				 + "values(?,?)";
		return testDao.update(sql, params);
	}

	@Override
	public int modifyTest(Object[] params) {
		String sql = "update cswd_user set user_pwd=? where user_id=?;";
		return testDao.update(sql, params);
	}

	@Override
	public int deleteTest(Object[] params) {
		String sql = "delete from cswd_user where user_id=?";
		return testDao.update(sql, params);
	}

}
