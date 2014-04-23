package publisher;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.TimeServerImpl;

public class Publisher {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException{
		System.out.println("Constructing server implementation");
		TimeServerImpl timeServerImpl = new TimeServerImpl();
		//Metodo alternativo
		//TimeServer timeServerStub = (TimeServer)UnicastRemoteObject.exportObject(timeServerImpl, 0);
		
		
		
		System.out.println("Binding server implementation to registry..."); 
		Registry registry = LocateRegistry.createRegistry(1099);
		String name = "time_server";
		registry.bind(name, timeServerImpl);
		//Metodo alternativo
		//registry.bind(name, timeServerStub);
		
		


		
		System.out.println("Waiting for invocations from clients...");
	}
}
