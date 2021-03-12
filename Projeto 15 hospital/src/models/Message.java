package models;

public class Message {
  private String authorId;
  private String content;

  public Message(String authorId, String content) {
    this.authorId = authorId;
    this.content = content;
  }

  @Override
  public String toString() {
    return "[ " + this.authorId + ": " + this.content + "]";
  }

}
