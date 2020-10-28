package commonLibs.util;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
	
	//creamos una java class Properties diseñada para leer config.properties files
	public static Properties readProperties(String filename) throws Exception {
		filename = filename.trim(); //remueve espacios en blanco del archivo
		
		InputStream fileReader = new FileInputStream(filename); //java class que nos ayuda a leer archivos externos
		
		Properties property = new Properties();
		
		property.load(fileReader);
		
		return property;
		
	}

}
