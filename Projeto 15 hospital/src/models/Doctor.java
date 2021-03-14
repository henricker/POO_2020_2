package models;

import java.util.ArrayList;
import java.util.Collection;

import error.Error;
import models.interfaces.IDoctor;
import models.interfaces.IPatient;

public class Doctor extends Human implements IDoctor {
  private String id;
  private String specialty;
  private Collection<IPatient> patients;

  public Doctor(String id, String specialty) {
    this.id = id;
    this.specialty = specialty;
    this.patients = new ArrayList<IPatient>();
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
}
