package com.hasu.singleton;

/**
 * A computer server
 * @author Umang
 *
 */
public class Server {
	
	private static Server server = null;
	protected int memory;
	protected int cpu;
	
	private Server(){
		memory = 1;
		cpu = 2;
	}
	
	public static Server getServer(){
		if(server == null){
			server = new Server();
		}
		return server;
	}
	
	@Override
	public String toString() {
		return String.format("Memory %dGB and cores %d", memory, cpu);
	}
}
