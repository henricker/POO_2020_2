package controller;

//Models
import models.*;

//Util
import java.util.ArrayList;
import java.util.HashMap;
import util.DoubleTwoDecimal;

//Exceptions
import exceptions.ClientNotFound;
import exceptions.EventNotFound;
import exceptions.LimitOverflowException;
import exceptions.NumberErrorException;
import exceptions.SectorAlreadyExists;
import exceptions.SectorNotFound;
import exceptions.ClientAlreadyExist;
import exceptions.EventAlreadyExists;

public class TicketOffice {
    private ArrayList<Sale> salesRepository;
    private HashMap<String, Person> clientRepository;
    private HashMap<String, Event> eventsRepository;
    private HashMap<String, Sector> sectorsRepository;
    private double checkout;

    public TicketOffice() {
        this.salesRepository = new ArrayList<Sale>();
        this.clientRepository = new HashMap<String, Person>();
        this.eventsRepository = new HashMap<String, Event>();
        this.sectorsRepository = new HashMap<String, Sector>();
        this.checkout = 0;
    }

    public void sale(String client, String sector, String event)
            throws ClientNotFound, SectorNotFound, EventNotFound, LimitOverflowException {
        
        Person searchClient = this.clientRepository.get(client);
        Sector searchSector = this.sectorsRepository.get(sector);
        Event searchEvent = this.eventsRepository.get(event);

        if(searchClient == null)
            throw new ClientNotFound("Client not found!");
        if(searchSector == null)
            throw new SectorNotFound("Sector not found!");
        if(searchEvent == null)
            throw new EventNotFound("Event not found!");
        
        if(searchClient.getHalf()){
            this.salesRepository.add(new Sale(searchClient, searchSector, searchEvent, searchSector.getPrice()/2));
            this.checkout += DoubleTwoDecimal.doubleToDecimal(searchSector.getPrice()/2);
            return;
        }

        this.salesRepository.add(new Sale(searchClient, searchSector, searchEvent, searchSector.getPrice()));
        this.checkout += searchSector.getPrice();
        searchSector.saled(searchClient);
    }

    public void addClient(String name, boolean half) throws ClientAlreadyExist {
        if(this.clientRepository.containsKey(name))
            throw new ClientAlreadyExist(name + " already exists!");

        this.clientRepository.put(name, new Person(name, half));
    }

    public void addEvent(String name) throws EventAlreadyExists {
        if(this.eventsRepository.containsKey(name))
            throw new EventAlreadyExists(name + " already exists!");
        
        this.eventsRepository.put(name, new Event(name));
    }

    public void addSector(String name, String event, double price, int capacity) throws SectorAlreadyExists,
            EventNotFound, NumberErrorException {
        
        if(this.sectorsRepository.containsKey(name))
            throw new SectorAlreadyExists(name + " already exists!");
        
        Event searchEvent = this.eventsRepository.get(event);

        if(searchEvent == null)
            throw new EventNotFound("Event not found!");

        if(capacity <= 0)
            throw new NumberErrorException("Capacity cant be negative!");
        if(price <= 0)
            throw new NumberErrorException("price cant be negative!");
        
        this.sectorsRepository.put(name, new Sector(name, searchEvent, price, capacity));
    }

    public String showClients() {
        StringBuilder sb = new StringBuilder();

        this.eventsRepository.values().forEach(event -> {
            sb.append(event.getName() + ":\n");
            event.getSectors().values().forEach(sector -> {
                sb.append("  " + sector.getName() + ":\n");
                sb.append("    [ ");
                sector.getClients().values().forEach(client -> {
                    sb.append(client.getName() + " ");
                });
                sb.append("]\n");
            });
        });

        return sb.toString();
    }

    public String showEvents() {
        StringBuilder sb = new StringBuilder();
        
        this.eventsRepository.values().forEach(event -> {
            sb.append(event.getName() + ":\n");
            event.getSectors().values().forEach(sector -> {
                sb.append("    - " + sector + "\n");
            });
        });

        return sb.toString();
    }

    public String showSales() {
        StringBuilder sb = new StringBuilder();
        
        this.salesRepository.forEach(sale -> {
            sb.append(sale + "\n");
        });

        return sb.toString();
    }
}
