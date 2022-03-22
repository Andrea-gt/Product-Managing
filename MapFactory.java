import java.util.*;

public class MapFactory {
	public Map<String, List<String>> createMap(int mapType){	

		if (mapType == 1) {
			return new HashMap<String, List<String>>();
		}

		if (mapType == 2) {
			return new TreeMap<String, List<String>>();
		}

		if (mapType == 3) {
			return new LinkedHashMap<String, List<String>>();
		}
		return null;
	}
}
