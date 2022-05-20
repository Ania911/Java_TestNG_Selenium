package API;

public class Elements {

    // Get all pets by status
    public static final String availableStatus = "/pet/findByStatus?status=available";
    public static final String soldStatus = "/pet/findByStatus?status=sold";
    public static final String pendingStatus = "/pet/findByStatus?status=pending";

    // Create new pet
    public static final String createNewPet = "/pet";
    //Get pets by id
    public static final String getPetById = "/pet/";
    //Delete pets by id
    public static final String deletePet = "/pet/";
}
