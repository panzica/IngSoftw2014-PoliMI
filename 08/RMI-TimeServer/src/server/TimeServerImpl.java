package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class TimeServerImpl extends UnicastRemoteObject implements TimeServer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3842615073102918623L;
	
	public TimeServerImpl() throws RemoteException{
		super();
	}

	@Override
	public String getTime() throws RemoteException {		
		return  new Date().toString();
	}
	
	
	

}
