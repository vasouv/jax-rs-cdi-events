package vs.jax.rs.cdi.events.service;

import java.io.StringReader;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author vasouv
 */
@Stateless
public class ClientAPIExample {

    private Client client;
    private WebTarget target;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("https://jsonplaceholder.typicode.com");
    }

    public JsonArray fetchTodos() {
        
        JsonArrayBuilder todosWithoutCustomerID = Json.createArrayBuilder();

        //Gets the String response
        String todosResponse = target.path("todos").request().get(String.class);
        
        //Creates JSON object by reading the response String
        JsonArray initialResponse;
        try(JsonReader jsonReader = Json.createReader(new StringReader(todosResponse))){
            initialResponse = jsonReader.readArray();
        }
        
        //Gets the array of todos
        JsonArray jar = initialResponse.asJsonArray();
        
        //Extracting the fields without customer id
        for (JsonValue todo : jar) {
            JsonObject currentJson = todo.asJsonObject();
            JsonObject extracted = Json.createObjectBuilder()
                .add("id", currentJson.getInt("id"))
                .add("title", currentJson.getString("title"))
                .add("completed", currentJson.getBoolean("completed"))
                .build();
            
            //adding to the returned json array
            todosWithoutCustomerID.add(extracted);
        }
        
        
        return todosWithoutCustomerID.build();

    }

}
