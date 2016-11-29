package com.briup.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JsonSer
 */
@WebServlet("/jsonSer")
public class JsonSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我是jsonSer");   
		//设置编码和获取pw
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		
		/*直接通过String发送设置json记得转义*/
		String jsonStr="{\"name\":\"lisi\",\"age\":40,\"gender\":\"female\"}";
		
		
		/*把json封装成对象（kv对）*/
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "alan");
		jsonObj.put("age", 40);
		
		
		/*通过其他类的get方法来构建json对象（转化）*/
		JSONObject jsonObjFromObj = JSONObject.fromObject(new User("jade",20));
		System.out.println("jsonObjFromObj: "+jsonObjFromObj.toString());
		
		
		/*把java集合转化为json数组*/
		List<String> list = new ArrayList<>();
		list.add("alan");
		list.add("alan1");
		list.add("alan2");
		JSONArray jsonArray = JSONArray.fromObject(list);
		/*传去格式如下：
		["alan", "alan1", "alan2"]
		0----alan
		1----alan1
		2----alan2
		*/
		
		
		/*把json数据封装成对象，然后再把多个对象存入json数组中再进行发送*/
		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("name", "郭仕华");
		jsonObj2.put("age", 40);
		JSONObject jsonObj3 = new JSONObject();
		jsonObj3.put("name", "jade");
		jsonObj3.put("age", 20);
		JSONArray jsonArray2 = new JSONArray();
		jsonArray2.add(jsonObj2);
		jsonArray2.add(jsonObj3);
		/*接收格式如下，在前台可直接通过.name获取属性
		0:Object
		age:40
		name:"郭仕华"
			
		1:Object
		age:20
		name:"jade"
		*/
			
		
		/*直接把2个对象放入list中然后再通过jsonArray发送*/
		List<User> list2 = new ArrayList<>();
		User user1 = new User("alan",23);
		User user2 = new User("jade",20);
		list2.add(user1);
		list2.add(user2);
		JSONArray jsonArray3 = JSONArray.fromObject(list2);
		
		//{"user":[{},{}]}  需要key:value，那么就是使用map
		/*把jsonArray放入到jsonObj中*/
		JSONArray jsonArray4 = JSONArray.fromObject(list2);
		JSONObject jsonObj4 = new JSONObject();
		jsonObj4.put("user", jsonArray4);
		
		
		//发送
		pw.write(jsonObj4.toString());
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

