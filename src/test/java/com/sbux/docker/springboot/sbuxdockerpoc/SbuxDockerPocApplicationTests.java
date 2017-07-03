package com.sbux.docker.springboot.sbuxdockerpoc;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbuxDockerPocApplicationTests {

	public static final String BASE_URI = "http://localhost:8085/rest/docker/hello";
	
	@Ignore
	@Test
	public void contextLoads() throws IOException {
		URL obj = new URL(BASE_URI);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + BASE_URI);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		assertEquals("hello, docker", response.toString());
	}

}
