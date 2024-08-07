package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao {
	
	public int insertStudent(StudentBean sbean)
	{
		Connection conn = DBConnection.getConnection();
		String insertquery = "INSERT INTO student(name,std,marks) values(?,?,?);";
		PreparedStatement pstmt = null;
		int rowseffected = 0;
		
		if(conn!=null)
		{
			try {
				pstmt = conn.prepareStatement(insertquery);
				
				pstmt.setString(1, sbean.getName());
				pstmt.setString(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				
				rowseffected = pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Student Dao: DBConnection is not connected");
		}
		return rowseffected;
	}
	
	public int deleteStudent(int rno)
	{
		Connection conn = DBConnection.getConnection();
		String deletequery = "delete from student where roll_no=?;";
		PreparedStatement pstmt = null;
		int rowseffected = 0;
		
		if(conn!=null)
		{
			try {
				pstmt = conn.prepareStatement(deletequery);
				pstmt.setInt(1, rno);
				rowseffected = pstmt.executeUpdate();
				System.out.println(rowseffected);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return rowseffected;
	}
	
	public int updateStudent(StudentBean sbean,int rno)
	{
		Connection conn = DBConnection.getConnection();
		String updatequery = "update student set name=?,std=?,marks=? where roll_no=?;";
		PreparedStatement pstmt = null;
		int rowseffected = 0;
		
		if(conn!=null)
		{
			try {
				pstmt = conn.prepareStatement(updatequery);
				
				pstmt.setString(1, sbean.getName());
				pstmt.setString(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				pstmt.setInt(4,rno);
				
				rowseffected = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		else
		{
			System.out.println("DBConnection is not connected");
		}
		return rowseffected;
	}
	
	public ArrayList<StudentBean> getAllRecords()
	{
		Connection conn =DBConnection.getConnection();
		String selectquery = "select * from student;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StudentBean sbean = null;
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		
		
		if(conn!=null)
		{
			try {
				pstmt = conn.prepareStatement(selectquery);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					String std = rs.getString(3);
					int marks = rs.getInt(4);
					
					sbean = new StudentBean(rno,name,std,marks);
					
					list.add(sbean);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		}
		return list;
	}
	
	public StudentBean getStudentByRno(int rno){
			
		Connection conn =DBConnection.getConnection();
		String selectquerybyrno = "select * from student where roll_no=?;";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		StudentBean s = null;
		
		if(conn!=null)
		{
				try {
					pstmt = conn.prepareStatement(selectquerybyrno);
					pstmt.setInt(1, rno);
					rs = pstmt.executeQuery();
					
					rs.next();
					rno = rs.getInt(1);
					String name = rs.getString(2);
					String std= rs.getString(3);
					int marks= rs.getInt(4);
					
					s = new StudentBean(rno,name,std,marks);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
			
			System.out.println("DBConnection connected : ");
		}else
		{
			System.out.println("DBConnection not connected");
		}
	
		
		return s;
		
	}
	
}
