package 练习2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addstu1
 */
@WebServlet("/Addstu1")
public class Addstu1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstu1() {
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
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=STU";
		String user="sa";
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url,user,"12345");
			java.sql.Statement a= conn.createStatement();
			student stu=new student();
			stu.Stuid=request.getParameter("Stuid");
			stu.Stuname=request.getParameter("Stuname");
			stu.Stuclass=request.getParameter("Stuclass");
			String age=request.getParameter("Stuage");
			stu.Stuage=Integer.parseInt(age);
			String adsc=request.getParameter("Stuadsc");
			stu.Stuadsc=Integer.parseInt(adsc);
			stu.Remark=request.getParameter("Remark");
			String add="insert into STUDENT1(Stuid,Stuname,Stuclass,Stuage,Stuadsc,Remark) values ("
					+stu.Stuid+","+stu.Stuname+","+stu.Stuclass+","+stu.Stuage+","+stu.Stuadsc+","+stu.Remark+");";
		   	int f=a.executeUpdate(add);
			PrintWriter out=response.getWriter();
			out.print("<head>");
			out.print("<title>添加信息</title>");
			out.print("<style type='text/css'>");
			out.print("body{background-color:green;}");
			out.print("</style>");
			out.print("</head>");
			if(f==1) {
				out.print("<body>");
				out.print("<p>添加成功！</p>");
				out.print("</body>");
			}
			else {
				out.print("<body>");
				out.print("<p>添加失败！</p>");
				out.print("</body>");
			}
		}catch(InstantiationException | IllegalAccessException | ClassNotFoundException|SQLException e) {
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
