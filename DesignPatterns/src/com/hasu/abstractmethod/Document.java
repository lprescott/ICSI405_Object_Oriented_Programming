package com.hasu.abstractmethod;

import java.util.ArrayList;

public abstract class Document {
	protected ArrayList<Page> pages = null;
	
	Document(){
		pages = new ArrayList<Page>();
		this.createPages();
	}
	
	public abstract void createPages();
	
	public ArrayList<Page> getPages(){
		return pages;
	}
}
