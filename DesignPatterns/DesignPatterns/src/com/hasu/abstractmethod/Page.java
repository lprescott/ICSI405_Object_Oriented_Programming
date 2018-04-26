package com.hasu.abstractmethod;

public abstract class Page {
	private StringBuffer content = new StringBuffer();
	
	protected void addContent(String content){
		this.content.append(content);
	}
	
	public String getContent(){
		// Return a copy
		return new String(content);
	}
}
