import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Controlador {
	FileInputStream fstream;

	public void readingFile(Map<String, List<String>> Map) throws IOException {

		fstream = new FileInputStream("ListadoProducto.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Leer Archivo Linea por Linea
		while ((strLine = br.readLine()) != null)   {
			String[] parts = strLine.split("\\|");

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

	public static void printMap(Map<String, List<String>> Map) {
		for (Entry<String, List<String>> entry : Map.entrySet())
			System.out.println("Categoria = " + entry.getKey() +
					", Productos = " + entry.getValue());   
	}

	public static void sortbykey(Map<String, List<String>> Map)
	{
		TreeMap<String,List<String>> sorted = new TreeMap<>(Map);

		// Display the TreeMap which is naturally sorted
		for (Entry<String, List<String>> entry : sorted.entrySet())
			System.out.println("Categoria = " + entry.getKey() +
					", Productos = " + entry.getValue());       
	}

	public static String searchProduct(String name, Map<String, List<String>> Map) {
		for(Entry<String, List<String>> entry : Map.entrySet()) {
			if(entry.getValue().contains(name)==true) {
				return entry.getKey();
			}
		}
		return null;
	}

	//Metodo obtenido de GeeksforGeeks.com
	public static void countFreq(Map<String, List<String>> Map)
	{
		for (Entry<String, List<String>> entry : Map.entrySet())
			for (int i = 0; i < entry.getValue().size(); i++) {
				int cantidad = 1;
				for (int j = i + 1 ; j < entry.getValue().size(); j++) {
					if (entry.getValue().get(i).equals(entry.getValue().get(j))) {
						cantidad++;
						System.out.println(entry.getValue().get(i));
					}

					System.out.println("Categoria = " + entry.getKey() +
							", Producto " + entry.getValue().get(i) + ", Cantidad " + cantidad); 
				}


			}
	}
	
	public static void countFreqSort(Map<String, List<String>> SortedMap)
	{
		for (Entry<String, List<String>> entry : SortedMap.entrySet())
			for (int i = 0; i < entry.getValue().size(); i++) {
				int cantidad = 1;
				for (int j = i + 1 ; j < entry.getValue().size(); j++) {
					if (entry.getValue().get(i).equals(entry.getValue().get(j))) {
						cantidad++;
						System.out.println(entry.getValue().get(i));
					}

					System.out.println("Categoria = " + entry.getKey() +
							", Producto " + entry.getValue().get(i) + ", Cantidad " + cantidad);
				}


			}
	}
}
