package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.TimeServer;

public class TimeServerClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException{
		
		
		System.out.println("RMI registry bindings ");
		

		String name = "time_server";
		//TimeServer timeServer = (TimeServer) Naming.lookup("//localhost/Server");
		Registry registry = LocateRegistry.getRegistry();
		TimeServer timeServer = (TimeServer) registry.lookup(name);
		System.out.println("Invoking remote object...");
		System.out.println(timeServer.getTime());
	}

}
