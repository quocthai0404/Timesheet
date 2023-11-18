package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import database.JdbcUlti;


public class Test {

	public static void main(String[] args) {
		try {
			Connection con = JdbcUlti.getConnection();
			if(con != null) {
				System.out.println("ok");
			}
			
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
