package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import error.Error;
import models.interfaces.IBatePapense;
import models.interfaces.IDoctor;
import models.interfaces.IPatient;

public class Patient implements IPatient, IBatePapense {
  private String id;
  private String diagnosys;
  private List<Message> inbox;
  private Collection<IDoctor> doctors;

  public Patient(String id, String diagnosys) {
    this.id = id;
    this.diagnosys = diagnosys;
    this.doctors = new ArrayList<IDoctor>();
    this.inbox = new ArrayList<Message>();
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getDiagnosys() {
    return this.diagnosys;
  }

  @Override
  public void addDoctor(IDoctor doctor) throws Error {
    
    if(this.doctors.contains(doctor))
      throw new Error("Doctor is already on the list of doctors responsible for the patient", "DoctorAlreadyExists");
    
    if(this.getDoctorBySpecialty(doctor.getSpecialty()) != null)
      throw new Error("There is already another doctor of the same specialization responsible for the patient", "SpecialtyAlreadyExists");

    this.doctors.add(doctor);
  }

  @Override
  public void removeDoctor(String idDoctor) throws Error {
    IDoctor doctor = this.getDoctor(idDoctor);

    if(doctor == null)
      throw new Error("Doctor does not exist on the doctor's responsibility list", "DoctorNotFound");
    
    this.doctors.remove(doctor);    
  }

  @Override
  public Collection<IDoctor> getDoctors() {
    return this.doctors;
  }

  private IDoctor getDoctorBySpecialty(String specialty) {

    for(IDoctor doctor : this.doctors) {
      if(doctor.getSpecialty().equals(specialty))
        return doctor;
    }
    return null;
  }

  private IDoctor getDoctor(String id) {
    for(IDoctor doctor : this.doctors) {
      if(doctor.getId().equals(id))
        return doctor;
    }
    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Pat: " + this.id + ":" + this.diagnosys + " Doc: [ ");

    this.doctors.forEach(doctor -> {
      sb.append(doctor.getId() + " ");
    });

    sb.append("]");

    return sb.toString();
  }

  @Override
  public void sendMessage(Message msg, IBatePapense batePapense) throws Error {
    if(!(batePapense instanceof Doctor))
      throw new Error("This is not instance of doctor", "InstanceError");
    if(!this.doctors.contains((Doctor) batePapense))
      throw new Error("Patient does not know this doctor","DoctorNotFound");
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
