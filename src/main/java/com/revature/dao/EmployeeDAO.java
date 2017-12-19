////package com.revature.dao;
////
////public class EmployeeDAO {
////
////}
//
//
//
//
//package com.revature.dao;
//
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.revature.beans.Employee;
//import com.revature.util.ConnectionUtil;
//
//public class EmployeeDAO {
//	public List<Employee> getAllEmployees() {
//		PreparedStatement ps = null;
//		Employee e = null;
//
//		List<Employee> employees = new ArrayList<>();
//
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM EMPLOYEE";
//			ps = conn.prepareStatement(sql);
//			// add any variables to ps
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				int eid = rs.getInt("EMP_ID");
//				String name = rs.getString("F_NAME");
//				e = new Employee(eid, name);
//				e.toString();
//				employees.add(e);
//			}
//			rs.close();
//			ps.close();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		return employees;
//	}
//}
