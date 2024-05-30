package it.unicam.progettoids2324;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class Pr24idsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pr24idsApplication.class, args);
		openSwaggerUI();
	}

	private static void openSwaggerUI() {
		try {
			String url = "http://localhost:8080/swagger-ui/index.html";

			// Check if Desktop is supported
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(new URI(url));
			} else {
				// Try to open the browser using the command line
				Runtime runtime = Runtime.getRuntime();
				String os = System.getProperty("os.name").toLowerCase();
				if (os.contains("win")) {
					runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
				} else {
					System.out.println("Open the following URL manually in your browser: " + url);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
