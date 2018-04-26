package com.hasu.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		Server server1 = Server.getServer();
		System.out.println(server1);
		
		
		Server server2 = Server.getServer();
		System.out.println(server2);
		
		System.out.println(server1 == server2);
	
		
	}
}
