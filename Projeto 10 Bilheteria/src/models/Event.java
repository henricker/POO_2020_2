package models;

//util
import java.util.HashMap;

//exceptions
import exceptions.SectorAlreadyExists;

public class Event {
    private String name;
    private HashMap<String, Sector> sectorsRepository;

    public Event(String name) {
        this.name = name;
        sectorsRepository = new HashMap<String, Sector>();
    }

    public void addSector(Sector sector) throws SectorAlreadyExists {
        if(this.sectorsRepository.containsKey(sector.getName()))
            throw new SectorAlreadyExists(sector.getName() + " sector already exists in event " + this.name);
        this.sectorsRepository.put(sector.getName(), sector);
    }

    //all getters
    public String getName() { return this.name; }
    public HashMap<String, Sector> getSectors() { return this.sectorsRepository; }
}
