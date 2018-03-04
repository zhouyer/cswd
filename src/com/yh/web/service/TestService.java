/**   
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018年3月3日 下午11:52:11   
 */
package com.yh.web.service;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface TestService {
	List<Object> getTestList();// 获取列表

	int insertTest(Object[] params);// 插入一条数据

	int modifyTest(Object[] params);// 修改

	int deleteTest(Object[] parmas);// 删除
}
