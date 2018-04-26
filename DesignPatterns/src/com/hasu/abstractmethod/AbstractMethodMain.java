package com.hasu.abstractmethod;

public class AbstractMethodMain {
	public static void main(String[] args) {
		Resume r = new Resume();
		for(Page p : r.getPages()){
			System.out.println(p);
		}
	}
}
