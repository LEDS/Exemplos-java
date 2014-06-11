package br.edu.ifes.leds.generator.fakedata;

import org.fluttercode.datafactory.impl.DataFactory;
//http://www.andygibson.net/blog/article/generate-test-data-with-datafactory/
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataFactory df = new DataFactory();

		for (int i = 0; i < 100; i++) {

			String name = df.getFirstName() + " "+ df.getLastName();

		    System.out.println(name);

		}

	}

}
