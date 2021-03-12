package models.interfaces;

import error.Error;
import models.Message;

import java.util.List;

public interface IBatePapense {
	public void sendMessage(Message msg, IBatePapense batePapense) throws Error;
	public void addMessage(Message msg);
	public List<Message> getInbox(); 
}
