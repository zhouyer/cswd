/**   
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018��3��3�� ����11:52:11   
 */
package com.yh.web.service;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface TestService {
	List<Object> getTestList();// ��ȡ�б�

	int insertTest(Object[] params);// ����һ������

	int modifyTest(Object[] params);// �޸�

	int deleteTest(Object[] parmas);// ɾ��
}
