package models.interfaces;

import java.util.Collection;

import error.Error;

public interface IDoctor {
  public String getId();
	public String getSpecialty();
	public void addPatient(IPatient patient) throws Error;
	public void removePatient(String idPatient) throws Error;
	public Collection<IPatient> getPatients();
}
