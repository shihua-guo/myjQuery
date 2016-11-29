package com.briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EChart
 */
@WebServlet("/data.json")
public class EChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EChart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我是EChart的json");
		/*设置编码*/
		response.setContentType("UTF-8");
		/*获取pw*/
		PrintWriter pw = response.getWriter();
		/*设置json*/
		String json = "{"
				+ "\"data1\": [\"Smtra\", \"Jawa\", \"Klmtn\", \"Sulwsi\", \"Maluku\"]"
				+ "\"data2\": [149739, 244347, 54462, 59869, 6713],"
				+ "\"data3\": [150089, 223519, 49523, 58881, 6152],"
				+ "\"data4\": [141625, 200745, 46966, 54637, 6733],"
				+ "\"data5\": [120428, 173979, 42208, 45067, 6034],"
				+ "\"data6\": [114254, 164168, 39415, 38750, 5301]"
				+ "}";
		pw.write(json);
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
