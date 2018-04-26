package com.hasu.abstractmethod;

import java.util.ArrayList;

public abstract class Document {
	protected ArrayList<Page> pages = new ArrayList<Page>();
	
	Document(){
		pages.addAll(this.createPages());
	}
	
	protected abstract ArrayList<Page> createPages();
	
	public ArrayList<Page> getPages(){
		return pages;
	}
	
	public void printStats(){
		System.out.println(String.format("Document has %d pages", pages.size()));
		int length = pages.stream().map(page -> page.getContent().length()).reduce(0, (x,y) -> x + y);
		System.out.println(String.format("Document length is %d", length));
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		pages.forEach(page -> sb.append(page.getContent()));
		return sb.toString();
	}
}
