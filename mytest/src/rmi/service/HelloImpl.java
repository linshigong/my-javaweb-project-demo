package rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

	public HelloImpl() throws RemoteException{
	}
	
	@Override
	public String helloWorld() throws RemoteException {
		return "Hello World!";
	}

	@Override
	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException {
		return "你好"+someBodyName;
	}

	
	
}
