package API;


public class Pet {

    private int id;
    private String name;
    private String status;

    public Pet(){}

    //Used for post request
    public Pet(String name, String status) {
        setName(name);
        setStatus(status);
    }

    //Used for Update request
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
