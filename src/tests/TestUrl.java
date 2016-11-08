package tests;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestUrl {
	public static void main(String[] args) {
		try {
			URL url = new URL("https", "docs.oracle.com", "/javase/specs/jvms/se8/jvms8.pdf");
			System.out.println(url.toString());
			System.out.println(url.toURI());
			URLConnection connex = url.openConnection();
			InputStream in = connex.getInputStream();
//			System.out.println(connex.getContent().getClass().getName());
//			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
