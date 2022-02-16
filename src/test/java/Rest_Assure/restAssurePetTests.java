package Rest_Assure;

import API.APIMethods;
import API.Config;
import API.RequestBody;
import org.testng.annotations.Test;

import static API.Elements.*;
import static org.hamcrest.Matchers.*;

public class restAssurePetTests extends Config {

    @Test
    public void testPetAvailableStatus() {
        APIMethods.getPetsStatus(availableStatus)
                .assertThat().body("status[0]", equalTo("available"));
    }

    @Test
    public void testPetsPendingStatus() {
        APIMethods.getPetsStatus(pendingStatus)
                .assertThat().body("status[0]", equalTo("pending"));
    }

    @Test
    public void testPetSoldStatus() {
        APIMethods.getPetsStatus(soldStatus)
                .assertThat().body("status[0]", equalTo("sold"));
    }

    @Test
    public void testAddNewPetToStore() {
        APIMethods.createPost("name", "Ania_test", createNewPet, 200);
    }

    @Test
    public void testAddNewPetsValidation() {
        APIMethods.createPostRequest(createNewPet, RequestBody.addNewPetsToStoreWrongBody, 405);
    }

    //CRUD
    @Test
    public void testAddNewPetToStoreHashMap() {
        APIMethods.createPostHashMap("id", 1, "name", "Test", "status", "available", createNewPet, 200);
    }

    @Test
    public void testGetPetByID() {
        APIMethods.getPetsStatusById(getPetById, 1)
                .assertThat().body("id", equalTo(1));
    }

    @Test
    public void testUpdatePet() {
        APIMethods.updatePutHashMap("id", 1, "name", "TestUpdate", "status", "sold", createNewPet, 200);
    }

    @Test
    public void testDeletePet() {
        APIMethods.deleteRequest(deletePet, 1, 200);
    }

    @Test
    public void testGetDeletedPet() {
        APIMethods.getPetsStatusById(getPetById, 1)
                .assertThat().body("message", equalTo( "Pet not found"))
                .assertThat().statusCode(404);
    }

}
