package src.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import src.error.Error;
import src.models.interfaces.IBatePapense;
import src.models.interfaces.IDoctor;
import src.models.interfaces.IPatient;

public class Doctor implements IDoctor, IBatePapense {
  private String id;
  private String specialty;
  private List<Message> inbox;
  private Collection<IPatient> patients;

  public Doctor(String id, String specialty) {
    this.id = id;
    this.specialty = specialty;
    this.patients = new ArrayList<IPatient>();
    this.inbox = new ArrayList<Message>();
  }
  
  private IPatient getPatient(String idPatient) {
    for(IPatient patient : this.patients) {
      if(patient.getId().equals(idPatient))
        return patient;
    }
    return null;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getSpecialty() {
    return this.specialty;
  }

  @Override
  public void addPatient(IPatient patient) throws Error {
    if(this.patients.contains(patient))
      throw new Error("Patient already exist on the doctor's responsibility list", "PatientAlreadyExists");
    
    this.patients.add(patient);
  }

  @Override
  public void removePatient(String idPatient) throws Error {
    IPatient patient = this.getPatient(idPatient);

    if(patient == null)
      throw new Error("Patient does not exist on the doctor's responsibility list", "PatientNotFound");
    
    this.patients.remove(patient);
  }

  @Override
  public Collection<IPatient> getPatients() {
    return this.patients;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Doc: " + this.id + ":" + this.specialty + " Pat: [ ");

    this.patients.forEach(patient -> {
      sb.append(patient.getId() + " ");  
    });

    sb.append("]");

    return sb.toString();
  }

  @Override
  public void sendMessage(Message msg, IBatePapense batePapense) throws Error {
    if(!(batePapense instanceof Patient))
      throw new Error("This is not instance of patient", "InstanceError");
    if(!this.patients.contains((Patient) batePapense))
      throw new Error("Doctor does not know this patient","DoctorNotFound");
    batePapense.addMessage(msg);
  }

  @Override
  public void addMessage(Message msg) {
    this.inbox.add(msg);
  }

  @Override
  public List<Message> getInbox() {
    List<Message> msgs = new ArrayList<Message>(this.inbox);
    this.inbox.clear();

    return msgs;
  }
}
