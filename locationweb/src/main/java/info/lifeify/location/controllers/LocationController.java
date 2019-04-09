package info.lifeify.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.lifeify.location.entities.Location;
import info.lifeify.location.service.LocationService;

@Controller 
public class LocationController {
	@Autowired
	LocationService service;
	@RequestMapping("/showCreate")
	public String showCreate(){
		return "createLocation";
	}
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: "+ locationSaved.getId();
		modelMap.addAttribute("msg",msg);
		return "createLocation";
	}
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		//Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLoction(location);
		List<Location> newLocations=service.getAllLocations();
		modelMap.addAttribute("locations", newLocations);
		return "displayLocations";
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "editLocation";
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> newLocations=service.getAllLocations();
		modelMap.addAttribute("locations", newLocations);
		return "displayLocations";
	}
}
