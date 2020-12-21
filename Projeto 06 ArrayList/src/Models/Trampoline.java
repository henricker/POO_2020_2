package Models;

import java.util.ArrayList;

public class Trampoline {
    private ArrayList <Kid> kidsWaiting = new ArrayList<Kid> ();
    private ArrayList <Kid> kidsPlaying = new ArrayList<Kid> ();

    public void arrive(Kid kid) {
        //Before add the kid in the first position of the kidsWaiting
        this.kidsWaiting.add(0, kid);
    }

    public void in() { 

        if(this.kidsWaiting.isEmpty()) {
            System.out.println("Fail: Não existe nenhuma criança na fila de espera!");
            return;
        }

        //Take and remove a first kid in waiting queue
        Kid firstKid = this.kidsWaiting.get(this.kidsWaiting.size() - 1);
        this.kidsWaiting.remove(this.kidsWaiting.size() - 1);

        //Now, add the fistkid in first position of the kidsPlayling
        this.kidsPlaying.add(0, firstKid);
    }

    public void out() { 

        if(this.kidsPlaying.isEmpty()) {
            System.out.println("Fail: o pula pula já está vazio!");
            return;
        }

        //Take and remove a last kid in kidsPlaying
        Kid lastKid = kidsPlaying.get(this.kidsPlaying.size() - 1);
        this.kidsPlaying.remove(this.kidsPlaying.size() - 1);

        //Now, add the laskid in first position of the waiting queue
        this.kidsWaiting.add(0, lastKid);
    }

    public String toString() {
        String data = "";
        for(Kid obj : this.kidsWaiting) {
            data += obj.toString();
        }

        data += "=> [ ";
        for(Kid obj : this.kidsPlaying) {
            data += obj.toString();
        }
        data += "]";

        return data;
    }
}
