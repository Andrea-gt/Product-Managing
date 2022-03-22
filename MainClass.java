import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in); 
		Controlador ctr = new Controlador();
		MapFactory factory = new MapFactory();
		
		System.out.println("Bienvenido, por favor ingrese qué tipo de estructura desea ultizar");
		System.out.println("1. HashMap");
		System.out.println("2. TreeMap");
		System.out.println("3. LinkedHashMap");
		
		int selection = sn.nextInt();
		sn.nextLine();
		
		Map<String, List<String>> Map = factory.createMap(selection);
		 
		try {
			ctr.readingFile(Map);
			System.out.println(Map);
			
		} catch (IOException e) {
		}
	}
}
