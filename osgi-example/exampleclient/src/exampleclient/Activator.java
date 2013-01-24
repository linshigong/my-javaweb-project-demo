package exampleclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import example.service.NameService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@SuppressWarnings("unchecked")
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		ServiceReference<NameService>[] refs = (ServiceReference<NameService>[])context.getServiceReferences(
				NameService.class.getName(), "(ClassRoom=*)");
		if (refs != null) {
			try {
				System.out.println("Enter a blank line to exit.");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				String name = "";
				// Loop endlessly.
				while (true) {
					// Ask the user to enter a name.
					System.out.print("Enter a Name: ");
					name = in.readLine();
					// If the user entered a blank line, then
					// exit the loop.
					if (name.length() == 0) {
						break;
					}
					// First, get a name service and then check
					// if the name is correct.
					NameService nameservice = (NameService) context
							.getService(refs[0]);
					if (nameservice.checkName(name)) {
						System.out.println("The Name is Correct.");
					} else {
						System.out.println("The Name is Incorrect.");
					}
					// Unget the name service.
					context.ungetService(refs[0]);
				}
			} catch (IOException ex) {
			}
		} else {
			System.out.println("Couldn't find any name service...");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
