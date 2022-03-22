import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in); 
		Controlador ctr = new Controlador();
		MapFactory factory = new MapFactory();
		boolean flag =true;

		System.out.println("Bienvenido, por favor ingrese que tipo de estructura desea ultizar");
		System.out.println("1. HashMap");
		System.out.println("2. TreeMap");
		System.out.println("3. LinkedHashMap");

		int selection = sn.nextInt();
		sn.nextLine();

		Map<String, List<String>> Map = factory.createMap(selection);

		try {
			ctr.readingFile(Map);

			while(flag) {
				System.out.println("\nQue desea hacer");
				System.out.println("1. Agregar un Producto a la Colección");
				System.out.println("2. Categoria del Producto");
				System.out.println("3. Datos de Producto");
				System.out.println("4. Datos de Producto Ordenados");
				System.out.println("5. Categoria y Producto de Todo Inventario");
				System.out.println("6. Categoria y Producto de Todo Inventario de Manera Ordenada\n");

				int option = sn.nextInt();
				sn.nextLine();

				switch(option) {

				case 1:
					System.out.println("Ingrese a que categoria desea agregar");
					String category = sn.nextLine();

					if(Map.containsKey(category)) {
						System.out.println("Ingrese los productos separados por una coma");
						String productos = sn.nextLine();
						String[] productosLista = productos.split(",");

						for (int i=0; i<productosLista.length; i++) 
						{ 
							Map.get(category).add(productosLista[i]);
						}
					}

					else {
						System.out.println("No existe la categoria");
					}

					break;

				case 2:
					System.out.println("Ingrese el nombre del producto");
					String productName = sn.nextLine();

					if(ctr.searchProduct(productName, Map)==null) {
						System.out.println("Producto no encontrado");
					}

					if(ctr.searchProduct(productName, Map) !=null) {
						System.out.println("Producto encontrado en:" + " " + ctr.searchProduct(productName, Map));
					}
					break;

				case 3:
					ctr.countFreq(Map);
					break;
					
				case 4:
					TreeMap<String,List<String>> SortedMap = new TreeMap<>(Map);
					ctr.countFreqSort(SortedMap);
					break;
					
				case 5:
					ctr.printMap(Map);
					break;

				case 6:
					ctr.sortbykey(Map);
					break;

				}
			}
		} 
		catch (IOException e) {
		}
	}
}
