package 练习2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Allstu
 */
@WebServlet("/Allstu")
public class Allstu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allstu() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("allstu");
		PrintWriter out=response.getWriter();
		out.print("<head>");
		out.print("<title>所有学生列表</title>");
		out.print("<style type='text/css'>");
		out.print("body{background-color:green;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2 align='center'>"+name+"</h2>");
		out.print("<table border='1' width=400px>");
		out.print("<tr><td>学号</td>");
		out.print("<td>姓名</td>");
		out.print("<td>班级</td>");
		out.print("<td>年龄</td>");
		out.print("<td>入学成绩</td>");
		out.print("<td>备注</td></tr>");
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=STU";
		String user="sa";
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url,user,"12345");
			java.sql.Statement a= conn.createStatement();
			ResultSet a1=a.executeQuery("select * from STUDENT1");
			while(a1.next()) {
				out.print("<tr><td>"+a1.getString("Stuid")+"</td>");
				out.print("<td>"+a1.getString("Stuname")+"</td>");
				out.print("<td>"+a1.getString("Stuclass")+"</td>");
				out.print("<td>"+a1.getInt("Stuage")+"</td>");
				out.print("<td>"+a1.getInt("Stuadsc")+"</td>");
				out.print("<td>"+a1.getString("Remark")+"</td></tr>");
			}
			out.print("</table>");
			out.print("</body>");
			a.close();
		}
		catch(InstantiationException | IllegalAccessException | ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
