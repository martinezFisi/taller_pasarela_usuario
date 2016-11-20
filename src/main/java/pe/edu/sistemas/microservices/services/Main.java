package pe.edu.sistemas.microservices.services;

import pe.edu.sistemas.microservices.services.accounts.AccountsServer;
import pe.edu.sistemas.microservices.services.registration.RegistrationServer;
import pe.edu.sistemas.microservices.services.web.WebServer;

/**
 *  Permitir que los servidores se invocan desde la línea de comandos. 
 * con esto <code>Main-Class</code> in the jar's <code>MANIFEST.MF</code>.
 * 
 */
public class Main {

	public static void main(String[] args) {

		String serverName = "NO-VALUE";

		switch (args.length) {
		case 2:
			
			System.setProperty("server.port", args[1]);

		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			usage();
			return;
		}

		if (serverName.equals("registration") || serverName.equals("reg")) {
			RegistrationServer.main(args);
		} else if (serverName.equals("accounts")) {
			AccountsServer.main(args);
		} else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
			usage();
		}
	}

	protected static void usage() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println(
				"     where server-name is 'reg', 'registration', " + "'accounts' or 'web' and server-port > 1024");
	}
}
