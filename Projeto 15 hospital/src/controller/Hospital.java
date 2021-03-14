package controller;

import java.util.ArrayList;
import java.util.List;

import error.Error;
import models.Doctor;
import models.Message;
import models.Patient;

public class Hospital {
  private List<Patient> patients;
  private List<Doctor> doctors;

  public Hospital() {
    this.doctors = new ArrayList<Doctor>();
    this.patients = new ArrayList<Patient>();  
  }

  public void addPatient(String id, String diagnosys) throws Error {
    if(this.getPatient(id) != null)
      throw new Error("Patient already exists", "PatientAlreadyExists");

    Patient patient = new Patient(id, diagnosys);
    this.patients.add(patient);
  }

  public void addDoctor(String id, String specialty) throws Error {
    if(this.getDoctor(id) != null)
      throw new Error("Doctor already exists", "DoctorAlreadyExists");
      
    Doctor doctor = new Doctor(id, specialty);
    this.doctors.add(doctor);
  }

  public void tie(String idPatient, String idDoctor) throws Error {
    Patient patient = this.getPatient(idPatient);
    Doctor doctor = this.getDoctor(idDoctor);

    if(patient == null)
      throw new Error("Pacient not found", "PatientNotFound");
    
    if(doctor == null)
      throw new Error("Doctor not found", "DoctorNotFound");

    patient.addDoctor(doctor);
    doctor.addPatient(patient);
  }

  public void sendMessage(String sender, String recipient, String message) throws Error {
    Patient patientSender = this.getPatient(sender);
    Doctor doctorRecipient = this.getDoctor(recipient);

    Patient patientRecipient = this.getPatient(recipient);
    Doctor doctorSender = this.getDoctor(sender);

    if(patientSender == null && patientRecipient == null)
      throw new Error("Pacient not found", "PatientNotFound");
    
    if(doctorSender == null && doctorRecipient == null)
      throw new Error("Doctor not found", "DoctorNotFound");
    
    if(patientSender != null && doctorRecipient != null) {
      if(!patientSender.getDoctors().contains(doctorRecipient))
        throw new Error("Doctor does not exist on the doctor's responsibility list", "DoctorNotFound");

      patientSender.sendMessage(new Message(patientSender.getId(), message), doctorRecipient);
      return;
    }

    if(doctorSender != null && patientRecipient != null) {
      if(!doctorSender.getPatients().contains(patientRecipient))
        throw new Error("Patient does not exist on the doctor's responsibility list", "PatientNotFound");
        
      doctorSender.sendMessage(new Message(doctorSender.getId(), message), patientRecipient);
      return;
    }
  }

  public String inbox(String id) throws Error {
    StringBuilder sb = new StringBuilder();
    List<Message> inbox = new ArrayList<Message>();

    Patient patient = this.getPatient(id);
    Doctor doctor = this.getDoctor(id);

    if(patient == null && doctor == null)
      throw new Error("User not found", "UserNotFound");

    if(patient != null)
      inbox = patient.getInbox();
    
    if(doctor != null)
      inbox = doctor.getInbox();
    
    inbox.forEach(message -> {
      sb.append(message + "\n");
    });

    if(inbox.isEmpty())
      sb.append("Empty!");
      
    return sb.toString();
  }

  public String show() {
    StringBuilder sb = new StringBuilder();

    this.patients.forEach(patient -> {
      sb.append(patient + "\n");
    });

    this.doctors.forEach(doctor -> {
      sb.append(doctor + "\n");
    });

    return sb.toString();
  }

  private Patient getPatient(String id) {
    for(Patient patient : this.patients) {
      if(patient.getId().equals(id))
        return patient;
    }
    return null;
  }

  private Doctor getDoctor(String id) {
    for(Doctor doctor : this.doctors) {
      if(doctor.getId().equals(id))
        return doctor;
    }
    return null;
  }
}
