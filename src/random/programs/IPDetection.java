package random.programs;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Comparator;

public class IPDetection {

	static String[] ips = new String[] { "fe80::8c6:932c:c292:9afb%5", "152.140.152.3" };

	public static void main(String[] args) {
		validateIps();
	}

	private static void validateIps() {
		
	for(String ip:ips) {
		InetAddress in;
		try {
			in = Inet6Address.getByName(ip);
			//Collections.sort(list, c);
			//System.out.println(in.);
		} catch (UnknownHostException e) {
			System.out.println("Unknown Host");
		}
	}
	}

}
