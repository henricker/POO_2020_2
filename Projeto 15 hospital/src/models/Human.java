package models;

import java.util.ArrayList;
import java.util.List;

import models.interfaces.IBatePapense;
import error.Error;

public abstract class Human implements IBatePapense {
  private List<Message> inbox;

  public Human() {
    this.inbox = new ArrayList<Message>();
  }

  @Override
  public void sendMessage(Message msg, IBatePapense batePapense) throws Error {
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