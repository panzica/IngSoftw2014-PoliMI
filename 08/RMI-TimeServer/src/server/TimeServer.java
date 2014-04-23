package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeServer extends Remote{
	public String getTime() throws RemoteException;

}
