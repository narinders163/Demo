package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlacePojo;
import pojo.Location;

public class TestDataResources {
	
	public Object addPlaceApyload(String name, String language, String address)
	{
		AddPlacePojo ap = new AddPlacePojo();
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setAccuracy(50);
		ap.setPhone_number("(+1)145-457-8958");
		ap.setWebsite("http://www.facebook.com");
		List<String> dummy = new ArrayList<String>();
		dummy.add("Shoe Park");
		dummy.add("Shop");
		ap.setTypes(dummy);
		
		Location l = new Location();
		l.setLat(-38.383754);
		l.setLng(33.427363);
		
		
		ap.setLocation(l);
		return ap;
	}

}
