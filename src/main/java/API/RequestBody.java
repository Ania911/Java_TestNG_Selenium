package API;


public class RequestBody {

    public static final String requestBodyAddNewPetsToStore = """
            {
              "id": 5,
              "category": {
                "id": 5,
                "name": "Test"
              },
              "name": "doggie",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "string"
                }
              ],
              "status": "available"
            }""";

    public static final String addNewPetsToStoreWrongBody = "  ";


}
