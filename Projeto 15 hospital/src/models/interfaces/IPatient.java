package src.models.interfaces;

import java.util.Collection;

import src.error.Error;

public interface IPatient {
	public String getId();
	public String getDiagnosys(); 
	public void addDoctor(IDoctor doctor) throws Error;
	public void removeDoctor(String idDoctor) throws Error;
	public Collection<IDoctor> getDoctors();
}
