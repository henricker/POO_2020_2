package view;

//util
import util.MessageController;

//controller
import controller.TicketOffice;

//Exceptions
import exceptions.ClientAlreadyExist;
import exceptions.ClientNotFound;
import exceptions.SectorAlreadyExists;
import exceptions.SectorNotFound;
import exceptions.EventAlreadyExists;
import exceptions.EventNotFound;
import exceptions.NumberErrorException;
import exceptions.LimitOverflowException;


public class View {
    private TicketOffice tickerOffice;
    private MessageController messageController;

    public View() {
        tickerOffice = new TicketOffice();
        messageController = new MessageController();
    }

    public void run() throws ClientAlreadyExist, SectorAlreadyExists,
    EventNotFound, NumberErrorException, ClientNotFound {
        
        while(true) {
            String[] line = MessageController.getInputUser().split(" ");

            if(line[0].equals("Logout"))
                break;
            
            else if(line[0].equals("AddClient:")) {
                try {
                    this.tickerOffice.addClient(line[1], line[2].equals("half") ? true : false);
                    messageController.init("Success", "Client added successfully!", false);
                    messageController.showMessage();
                }catch(IndexOutOfBoundsException err) {
                    messageController.init("Error", "Few arguments!", true);
                    messageController.showMessage();
                }catch(ClientAlreadyExist err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }
            }

            else if(line[0].equals("AddEvent:")) {
                try {
                    this.tickerOffice.addEvent(line[1]);
                    messageController.init("Success", line[1] + " event added successfully!", false);
                    messageController.showMessage();
                }catch(IndexOutOfBoundsException err) {
                    messageController.init("Error", "Few arguments!", true);
                    messageController.showMessage();
                }catch(EventAlreadyExists err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }
            }

            else if(line[0].equals("AddSector:")) {
                try {
                    this.tickerOffice.addSector(line[1], line[2], Double.parseDouble(line[3]), Integer.parseInt(line[4]));
                    messageController.init("Success", line[1] + " sector added successfully!", false);
                    messageController.showMessage();
                }catch(NumberFormatException err) {
                    messageController.init("Error", "Invalid number!", true);
                    messageController.showMessage();
                }catch(IndexOutOfBoundsException err) {
                    messageController.init("Error", "Few arguments!", true);
                    messageController.showMessage();
                }catch(SectorAlreadyExists err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }catch(EventNotFound err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }catch(NumberErrorException err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }
            }

            else if(line[0].equals("Sale:")) {
                try {
                    this.tickerOffice.sale(line[1], line[2], line[3]);
                    messageController.init("Success", "ticket: { " + line[1] + " " + line[2] + " " + line[3] + " }" , false);
                    messageController.showMessage();
                }catch(IndexOutOfBoundsException err) {
                    messageController.init("Error", "Few arguments!", true);
                    messageController.showMessage();
                }catch(ClientNotFound err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }catch(SectorNotFound err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }catch(EventNotFound err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }catch(LimitOverflowException err) {
                    messageController.init("Error", err.getMessage(), true);
                    messageController.showMessage();
                }
            }

            else if(line[0].equals("ShowClients")) {
                messageController.init(
                    "--- Clients ---", 
                    this.tickerOffice.showClients(), 
                    false
                );
                messageController.showMessage();
            }

            else if(line[0].equals("ShowEvents")) {
                messageController.init(
                    "---- Event with sectors ---- ", 
                    this.tickerOffice.showEvents(),
                    false
                );
                messageController.showMessage();
            }

            else if(line[0].equals("ShowSales")) {
                messageController.init(
                    "---- Event with sectors ---- ", 
                    this.tickerOffice.showSales(),
                    false
                );
                messageController.showMessage();
            }

            else {
                messageController.init("Error", "Invalid command!", true);
                messageController.showMessage();
            }
        }
    }
}
