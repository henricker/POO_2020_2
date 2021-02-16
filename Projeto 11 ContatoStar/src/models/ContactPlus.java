package models;

public class ContactPlus extends Contact {
    
    private boolean starred;
    
    public ContactPlus(String name) {
        super(name);
        this.starred = false;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public boolean getStarred() {
        return this.starred;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append((this.starred ? "@ " : "- ") + this.getName() + " : [ ");
        for(int i = 0; i < this.getPhones().size(); i++) {
            data.append("[ " + i + " : " + this.getPhones().get(i).toString() + " ]");
        }

        return data.append(" ]").toString();
    }
}
