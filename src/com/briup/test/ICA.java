package com.briup.test;

/**
 * 此对象用于存放ics业务
 * @author alan
 * @date Nov 26, 2016 10:35:51 AM
 */
public class ICA {
	private String numBigClass;
	private String nameBigClass;
	private String numSmallClass;
	private String nameSmallClass;
	
	public ICA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ICA(String numBigClass, String nameBigClass, String numSmallClass, String nameSmallClass) {
		super();
		this.numBigClass = numBigClass;
		this.nameBigClass = nameBigClass;
		this.numSmallClass = numSmallClass;
		this.nameSmallClass = nameSmallClass;
	}
	public ICA(String[] atts){
		this.numBigClass = atts[0];
		this.nameBigClass = atts[1];
		this.numSmallClass = atts[2];
		this.nameSmallClass = atts[3];
	}
	public String getNumBigClass() {
		return numBigClass;
	}
	public void setNumBigClass(String numBigClass) {
		this.numBigClass = numBigClass;
	}
	public String getNameBigClass() {
		return nameBigClass;
	}
	public void setNameBigClass(String nameBigClass) {
		this.nameBigClass = nameBigClass;
	}
	public String getNumSmallClass() {
		return numSmallClass;
	}
	public void setNumSmallClass(String numSmallClass) {
		this.numSmallClass = numSmallClass;
	}
	public String getNameSmallClass() {
		return nameSmallClass;
	}
	public void setNameSmallClass(String nameSmallClass) {
		this.nameSmallClass = nameSmallClass;
	}
	@Override
	public String toString() {
		return numBigClass + "	" + nameBigClass + "	" + numSmallClass
				+ "	" + nameSmallClass + "	";
	}
	
}
