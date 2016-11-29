package com.briup.test;

/**
 * 此类用于存放dpi业务
 * @author alan
 * @date Nov 26, 2016 10:40:17 AM
 */
public class DPI {
	private String type;
	private String name;
	private String num;
	private String subClassName;
	
	public DPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DPI(String type, String name, String num, String subClassName) {
		super();
		this.type = type;
		this.name = name;
		this.num = num;
		this.subClassName = subClassName;
	}
	public DPI(String[] atts){
		this.type = atts[0];
		this.name = atts[1];
		this.num = atts[2];
		this.subClassName = atts[3];
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSubClassName() {
		return subClassName;
	}
	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}
	@Override
	public String toString() {
		return type + "	" + name + "	" + num + "	" + subClassName + "	";
	}
	
}
