package models;

import java.util.HashMap;

public class Event {
    private String name;
    private HashMap<String, Sector> sectorsRepository;

    public Event(String name) {
        this.name = name;
        sectorsRepository = new HashMap<String, Sector>();
    }

    public void addSector(Sector sector) {
        this.sectorsRepository.put(sector.getName(), sector);
    }

    //all getters
    public String getName() { return this.name; }
    public HashMap<String, Sector> getSectors() { return this.sectorsRepository; }
}
