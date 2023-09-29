package user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.ConnectDatabase;
import utils.SQLQueries;

import java.sql.Connection;


public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection connect = ConnectDatabase.connectToMySql();
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			boolean checkUserExists = SQLQueries.checkUser(connect, email);
			if(checkUserExists) {
				SQLQueries.insertIntoUsers(connect, firstName, lastName, username, email, password);
			}
			
			connect.close();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
