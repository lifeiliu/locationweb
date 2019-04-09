package info.lifeify.location.service;


import java.util.List;

import info.lifeify.location.entities.Location;

public interface LocationService {
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLoction(Location location);
	Location getLocationById(int id);
	List<Location> getAllLocations();
}
