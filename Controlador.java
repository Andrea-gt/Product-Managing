import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controlador {
	FileInputStream fstream;
	
	public void readingFile(Map<String, List<String>> Map) throws IOException {

		fstream = new FileInputStream("ListadoProducto.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Leer Archivo Linea por Linea
		while ((strLine = br.readLine()) != null)   {
			String[] parts = strLine.split(":");
			
			//Las partes del Array temporal se asignan como categoria y producto de la estructura
			String category = parts[0].trim();
			List<String> product = new ArrayList<>();
			product.add(parts[1].trim());
			
			
			if(Map.containsKey(category))
				Map.get(category).add(parts[1].trim());
			
			else {
				Map.put(category, product);
			}
		}
		
		//Cerrar el input
		fstream.close();
	}
}
