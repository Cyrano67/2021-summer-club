package com.cestc.vspace.pojo;

import java.io.Serializable;

public class Result implements Serializable {
	
	private boolean resultTag;
	
	private String Msg;
	
	public boolean getResultTag() {
		return this.resultTag;
	}

	public void setResultTag(boolean resutlTag) {
		this.resultTag = resutlTag;
	}
	
	public String getMsg() {
		return this.Msg;
	}

	public void setMsg(String msg) {
		this.Msg = msg;
	}
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

}
