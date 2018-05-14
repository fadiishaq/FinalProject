package windows;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import personClasses.Administator;


public class JsonExample {
	public static void main(String[] a) throws IOException {
		Administator admin = new Administator();
		ObjectMapper om = new ObjectMapper();
		String jsonString = om.writeValueAsString(admin);
		System.out.println(jsonString);
		Administator readValue = om.readValue(jsonString, Administator.class);
		System.out.println(readValue);
 
		List<Administator> admins = new ArrayList<Administator>();
		admins.add(new Administator());
		admins.add(new Administator());

		try {
			om.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = om.writeValueAsString(admins);
			System.out.println(jsonString);
			// This is how to read json list
			List<Administator> adminsList = om.readValue(jsonString, new TypeReference<List<Administator>>() {
			});
			System.out.println(admins);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}

	}
}