package episode3.jdbc;

public class Account {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(String name) {
        this.name = name;
    }

    public Account() {
    }
}
