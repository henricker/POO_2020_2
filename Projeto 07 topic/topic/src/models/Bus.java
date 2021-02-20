package models;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import Exceptions.ExceptionController;

public class Bus {
    private ArrayList<Passenger> normalChairs;
    private ArrayList<Passenger> preferredChairs;
    private static int minAgeToOldPassenger = 60;

    public Bus (int capacity, int preferredChairs) {
        try{
            this.normalChairs = new ArrayList<Passenger>(Collections.nCopies(capacity - preferredChairs, null));
            this.preferredChairs = new ArrayList<Passenger>(Collections.nCopies(preferredChairs, null));
        }catch(IllegalArgumentException err){
            JOptionPane.showMessageDialog(
                null,
                "Fail: Capacity needs to be greater than preferred chairs number",
                "Error!",
                0
            );
        }
    }

    public void in (Passenger person) throws ExceptionController {
        int indexNormal = this.normalChairs.indexOf(null);
        int indexPreferred = this.preferredChairs.indexOf(null);

        if(indexNormal == -1 && indexPreferred == -1)
            throw new ExceptionController("Error", "Not vacant chairs");
        

        //Case old person and exists vacant preferred chairs
        else if(person.getAge() >= Bus.minAgeToOldPassenger && indexPreferred != -1)
            this.preferredChairs.set(indexPreferred, person);
        
        //Case old person and not exists vacant preferred chairs
        else if(person.getAge() >= Bus.minAgeToOldPassenger && indexPreferred == -1 && indexNormal != -1)
            this.normalChairs.set(indexNormal, person);
       

        //Case not old person and exists vacant on normal chairs
        else if(person.getAge() < Bus.minAgeToOldPassenger && indexNormal != -1)
            this.normalChairs.set(indexNormal, person);
       

        //Case not old person and not exists vacant normal chairs, but exists vacant on preferred chairs
        else if(person.getAge() < Bus.minAgeToOldPassenger && indexNormal == -1 && indexPreferred != -1)
            this.preferredChairs.set(indexPreferred, person);
    }

    public void out(String name) throws ExceptionController {

        for(int i = 0; i < this.preferredChairs.size(); i++) {
            if(this.preferredChairs.get(i) == null)
                continue;
            if(this.preferredChairs.get(i).getName().equals(name)) {
                this.preferredChairs.set(i, null);
                return;
            }
        }

        for(int i = 0; i < this.normalChairs.size(); i++) {
            if(this.normalChairs.get(i) == null)
                continue;
            if(this.normalChairs.get(i).getName().equals(name)) {
                this.normalChairs.set(i, null);
                return;
            }
        }

        throw new ExceptionController("Error", "Fail: Dont exists one passenger with this name");
        

    }

    public String toString() { 
        String solve = "[ ";
        for(Passenger obj : this.preferredChairs) {
            if(obj == null) {
                solve += "@ ";
                continue;
            }
            solve += "@" + obj.toString() + " ";
        }
        for(Passenger obj : this.normalChairs) {
            if(obj == null) {
                solve += "= ";
                continue;
            }
            solve += "=" + obj.toString() + " ";
        }
        solve += "]";
        return solve;
    }
}
