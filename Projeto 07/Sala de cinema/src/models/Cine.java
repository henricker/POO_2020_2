package models;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Cine {
    private ArrayList<Client> clients;
    private int maxChairs;

    public Cine(int size) { this.clients = new ArrayList<Client>(Collections.nCopies(size, null)); this.maxChairs = size; }

    //reserve one chair to client
    public void toReserve(String name, String phone, int index) {

        //If index is invalid
        if(index >= this.maxChairs || index < 0) {
            JOptionPane.showMessageDialog(
                null,
                "fail: This chair do not exists!",
                "Error!", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

         //If the index alredy reserved
         if(clients.get(index) != null) {
            JOptionPane.showMessageDialog(
                null, 
                "fail: Chair alredy reserved!", 
                "Error!", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Others validations
        for(Client obj : clients) {
            //If name client alredy exists
            if(obj != null && obj.getName().equals(name)) {
                JOptionPane.showMessageDialog(
                    null, 
                    "fail: Client is alredy in cinema!", 
                    "Error!", 
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        clients.add(index, new Client(name, phone));

    }

    //cancel the reserve with client
    public boolean cancel(String name) {
        for(int i = 0; i < this.maxChairs; i++) {
            if( clients.get(i) != null && clients.get(i).getName().equals(name) ) {
                clients.set(i, null);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String solve = "[ ";
        
        for(int i = 0; i < this.maxChairs; i++) {
            if(this.clients.get(i) == null){
                solve += "- ";
                continue;
            }
            solve += this.clients.get(i).toString() + " ";
        }
        solve += "]";

        return solve;
    }

}
