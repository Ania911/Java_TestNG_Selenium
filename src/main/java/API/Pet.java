package API;


public class Pet {

    public int id;
    public String name;
    public String status;

    //Used for post request
    public Pet(int id, String name, String status) {
        setId(id);
        setName(name);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
