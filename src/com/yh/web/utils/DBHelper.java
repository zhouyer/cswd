/**   
* @Title: DBHelper.java 
* @Package com.yh.web.utils 
* @Description: TODO 
* @author A18ccms A18ccms_gmail_com   
* @date 2018��3��2�� ����10:34:15 
* @version V1.0   
*/
package com.yh.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouy
 *
 */
public class DBHelper {
	public static final String DRIVENAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/yhcs";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement ppst = null;
	private ResultSet rs = null;

	/**
	 * ��������
	 */
	static {
		try {
			Class.forName(DRIVENAME).newInstance();
		} catch (Exception e) {
			System.out.println("��������ʧ�ܣ�" + e.getMessage());
		}
	}

	/**
	 * @Title: getConn
	 * @Description: �������ݿ�
	 * @param
	 * @return Connection
	 */
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�" + e.getMessage());
		}
		return conn;
	}

	/**
	 * @Title: getRes
	 * @Description: (�޲�)��ѯ
	 * @param sql
	 * @return ResultSet
	 */
	private ResultSet getRes(String sql) {
		conn = this.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("���޲Σ���ѯʧ�ܣ�" + e.getMessage());
		}
		return rs;
	}

	/**
	 * ��ѯ���
	 * 
	 * @param sql
	 * @param params
	 * @return ResultSet
	 */
	private ResultSet getRes(String sql, Object[] params) {
		conn = this.getConn();
		try {
			ppst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ppst.setObject(i + 1, params[i]);
				}
			}
			rs = ppst.executeQuery();
		} catch (Exception e) {
			System.out.println("��ѯ����" + e.getMessage());
		}
		return rs;
	}

	public List<Object> query(String sql, Object[] params) {
		List<Object> list = new ArrayList<Object>();
		ResultSet res = null;
		if (params != null) {
			res = this.getRes(sql, params);
		} else {
			res = this.getRes(sql);
		}

		ResultSetMetaData rsmd = null;
		int columnCount = 0;
		try {
			rsmd = res.getMetaData();
			columnCount = rsmd.getColumnCount();
			while (res.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			System.out.println("�������������" + e.getMessage());
		} finally {
			closeConn();
		}
		return list;
	}

	/**
	 * ���£��޲Σ�
	 * 
	 * @param @param
	 *            sql
	 * @param @return
	 * @return int
	 */
	public int update(String sql) {
		int affectedLine = 0;// ��Ӱ�����
		conn = this.getConn();
		try {
			st = conn.createStatement();
			affectedLine = st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("���£��޲Σ�ʧ�ܣ�" + e.getMessage());
		} finally {
			closeConn();
		}
		return affectedLine;
	}

	/**
	 * ��������
	 * 
	 * @param @param
	 *            sql
	 * @param @param
	 *            params
	 * @param @return
	 * @return int
	 */
	public int update(String sql, Object[] params) {
		int affectedLine = 0;// ��Ӱ�������
		conn = this.getConn();
		try {
			ppst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ppst.setObject(i + 1, params[i]);
				}
			}
			affectedLine = ppst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("���³���" + e.getMessage());
		} finally {
			closeConn();
		}
		return affectedLine;
	}

	/**
	 * �ر�����
	 * 
	 * @param
	 * @return void
	 */
	private void closeConn() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		if (ppst != null) {
			try {
				ppst.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
