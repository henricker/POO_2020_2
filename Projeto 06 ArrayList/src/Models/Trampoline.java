package Models;

import java.util.ArrayList;

public class Trampoline {
    ArrayList <Kid> kidsWaiting = new ArrayList<Kid> ();
    ArrayList <Kid> kidsPlaying = new ArrayList<Kid> ();

    public void arrive(Kid kid) {
        //Before add the kid in the first position of the kidsWaiting
        kidsWaiting.add(0, kid);
    }

    public void in() { 

        if(kidsWaiting.isEmpty()) {
            System.out.println("Fail: Não existe nenhuma criança na fila de espera!");
            return;
        }

        //Take and remove a first kid in waiting queue
        Kid firstKid = kidsWaiting.get(kidsWaiting.size() - 1);
        kidsWaiting.remove(kidsWaiting.size() - 1);

        //Now, add the fistkid in first position of the kidsPlayling
        kidsPlaying.add(0, firstKid);
    }

    public void out() { 

        if(kidsPlaying.isEmpty()) {
            System.out.println("Fail: o pula pula já está vazio!");
            return;
        }

        //Take and remove a last kid in kidsPlaying
        Kid lastKid = kidsPlaying.get(kidsPlaying.size() - 1);
        kidsPlaying.remove(kidsPlaying.size() - 1);

        //Now, add the laskid in first position of the waiting queue
        kidsWaiting.add(0, lastKid);
    }

    public String toString() {
        String data = "";
        for(Kid obj : kidsWaiting) {
            data += obj.toString();
        }

        data += "=> [ ";
        for(Kid obj : kidsPlaying) {
            data += obj.toString();
        }
        data += "]";

        return data;
    }
}
