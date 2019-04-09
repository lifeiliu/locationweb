package info.lifeify.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.lifeify.location.entities.Location;
import info.lifeify.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepo;

	@Override
	public Location saveLocation(Location location) {
		
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepo.save(location);
	}

	@Override
	public void deleteLoction(Location location) {
		locationRepo.delete(location);

	}

	@Override
	public Location getLocationById(int id) {
		return locationRepo.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return locationRepo.findAll();
	}

	public LocationRepository getLocationRepo() {
		return locationRepo;
	}

	public void setLocationRepo(LocationRepository locationRepo) {
		this.locationRepo = locationRepo;
	}

	
}
