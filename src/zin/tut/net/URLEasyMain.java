package zin.tut.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.TreeMap;

import static zin.tools.ZIO.*;

public class URLEasyMain {

	public void printCurrentSystemInfo() throws UnknownHostException {
		InetAddress myLocalIP = InetAddress.getLocalHost();
		// 192.168.1.4 depends on the connection, if no connection then 127.0.0.1
		print(myLocalIP.getHostAddress());
		// Prints PC name (Anurag3153567)
		print(myLocalIP.getHostName());
		// Anurag3153567.Nagarro.local
		print(myLocalIP.getCanonicalHostName());
	}
	
	public void openInputStreamToAURL() throws IOException {
		URL url = new URL(
				//"http://help.websiteos.com/websiteos/example_of_a_simple_html_page.htm"
				//"https://facebook.com"
				"https://google.com"
				);
		try (
				InputStream inputStream = url.openStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			) {
			String line = "";
			String response = "";
			while((line = bufferedReader.readLine()) != null) {
				response += (line + "\r\n");
			}
			print("Site content :\r\n" + response);
		} finally {
			
		}
	}
	
	public void getAndSendDataToURL() {
		// using url.openConnection
	}
	
	public static void main(String[] args) {
		runAllMethod(URLEasyMain.class);
	}
}
