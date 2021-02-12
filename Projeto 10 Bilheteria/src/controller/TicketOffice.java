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
    private ArrayList<Sector> sectorsRepository;
    private double checkout;

    public TicketOffice() {
        this.salesRepository = new ArrayList<Sale>();
        this.clientRepository = new HashMap<String, Person>();
        this.eventsRepository = new HashMap<String, Event>();
        this.sectorsRepository = new ArrayList<Sector>();
        this.checkout = 0;
    }

    public void sale(String client, String sector, String event)
            throws ClientNotFound, SectorNotFound, EventNotFound, LimitOverflowException {
        
        Person searchClient = this.clientRepository.get(client);
        Event searchEvent = this.eventsRepository.get(event);
        

        if(searchClient == null)
            throw new ClientNotFound(client + " client not found!");
        if(searchEvent == null)
            throw new EventNotFound(event + " event not found!");

        Sector searchSector = searchEvent.getSectors().get(sector);
        
        if(searchSector == null)
            throw new SectorNotFound(sector + " sector not found!");
        
        
        searchSector.saled(searchClient);
        if(searchClient.getHalf()){
            this.salesRepository.add(new Sale(searchClient, searchSector, searchEvent, searchSector.getPrice()/2));
            this.checkout += DoubleTwoDecimal.doubleToDecimal(searchSector.getPrice()/2);
            return;
        }

        this.salesRepository.add(new Sale(searchClient, searchSector, searchEvent, searchSector.getPrice()));
        this.checkout += searchSector.getPrice();
    }

    public void addClient(String name, boolean half) throws ClientAlreadyExist {
        if(this.clientRepository.containsKey(name))
            throw new ClientAlreadyExist(name + " already exists!");

        this.clientRepository.put(name, new Person(name, half));
    }

    public void addEvent(String name) throws EventAlreadyExists {
        if(this.eventsRepository.containsKey(name))
            throw new EventAlreadyExists(name + " event already exists!");
        
        this.eventsRepository.put(name, new Event(name));
    }

    public void addSector(String name, String event, double price, int capacity) throws SectorAlreadyExists,
            EventNotFound, NumberErrorException {
        
        Event searchEvent = this.eventsRepository.get(event);

        if(searchEvent == null)
            throw new EventNotFound(event + " event not found!");
        if(capacity <= 0)
            throw new NumberErrorException("Capacity can't be negative!");
        if(price <= 0)
            throw new NumberErrorException("price can't be negative!");
        
        Sector newSector = new Sector(name, searchEvent, price, capacity);
        searchEvent.addSector(newSector);
        this.sectorsRepository.add(newSector);
    }

    public String showClients() {
        StringBuilder sb = new StringBuilder();

        this.clientRepository.values().forEach(client -> {
            sb.append(client + "\n");
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
        sb.append("R$ " + this.checkout + "\n");
        return sb.toString();
    }
}
