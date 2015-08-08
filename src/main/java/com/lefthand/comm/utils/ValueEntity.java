package com.lefthand.comm.utils;
/**
 * 
 * @author hegc 2013年11月1日 下午3:44:04
 * 值对象
 */
public class ValueEntity {

	private String name;
	
	private String value;
	
	private boolean checked = false;
	
	public ValueEntity() {
		
	}
	
	public ValueEntity(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public ValueEntity(String name, String value, boolean checked) {
		this(name, value);
		this.checked = checked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}