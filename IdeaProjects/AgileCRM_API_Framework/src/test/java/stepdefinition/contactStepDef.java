package stepdefinition;

import com.agilecrm.type.ContactUpdatePropertiesDto;
import com.agilecrm.type.ContactUpdateTags;
import com.agilecrm.type.ContactsDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import utility.BaseClass;
import utility.Utilities;

import io.cucumber.java.en.Given;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

public class contactStepDef extends BaseClass {
//    RequestSpecification requestSpecification;
//    Response response;

    ContactsDto contactsDto;
    ContactUpdatePropertiesDto contactUpdatePropertiesDto;
    ContactUpdateTags contactUpdateTags;
    Utilities utilities;
    List<Map<String, String>> contact;
    Map<String, String> dataTable;

    @Given("I create request structure to create contacts using Serialization")
    public void iCreateRequestStructureToCreateContactsUsingSerialization(DataTable table) {


        contact = table.asMaps();
        contactsDto = new ContactsDto();

        dataTable = contact.get(0);
        //Logic of this "if" only for partial update using PUT method {here we update the properties partially}
 /*       if (dataTable.get("Id")!=null)
        {
            utilities = new Utilities();
            contactsDto.setId(dataTable.get("Id"));
            List<Map<String, String>> properties = utilities.setProperties(dataTable);
            contactsDto.setProperties(properties);
            requestSpecification = RestAssured.given();
            requestSpecification.baseUri(prop.getProperty("baseUri"))
                    .basePath(prop.getProperty("basePath"))
                    .header("Accept", ContentType.JSON)
                    .auth()
                    .basic(prop.getProperty("username"), prop.getProperty("password"))
                    .body(contactsDto).log().all();

        }
*/
        contactsDto.setStar_value(dataTable.get("star_value"));

        contactsDto.setLead_score(dataTable.get("lead_score"));

        utilities = new Utilities();
        List<String> tags = utilities.setTagsForContacts(dataTable);
        contactsDto.setTags(tags);

        List<Map<String, String>> properties = utilities.setProperties(dataTable);
        contactsDto.setProperties(properties);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri")).basePath(prop.getProperty("basePath")).header("Accept", ContentType.JSON).header("Content-Type", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(contactsDto).log().all();

    }

  /*  @When("I Hit create contacts api using Serialization {string}")
    public void iHitCreateContactsApiUsingSerialization(String statuscode) {

        response = requestSpecification.post("/contacts");
        Assert.assertEquals(Integer.parseInt(statuscode), response.statusCode());
        response.prettyPrint();
    }*/

    @Then("I verify the contacts is created successfully by using serialization concept using {string}")
    public void iVerifyTheContactsIsCreatedSuccessfullyByUsingSerializationConceptUsing(String statuscode) {

        Assert.assertEquals(Integer.parseInt(statuscode), response.statusCode());
        if (response.statusCode() == Integer.parseInt(statuscode)) {
            int expStartValue = Integer.parseInt(contactsDto.getStar_value());
            int actStarValue = response.jsonPath().get("star_value");
            Assert.assertEquals("satrt value is not match ", expStartValue, actStarValue);

            int expLeadScore = Integer.parseInt(contactsDto.getLead_score());
            int actLeadScore = response.jsonPath().get("lead_score");
            Assert.assertEquals("Lead Score vale is not match", expLeadScore, actLeadScore);

            List<String> expTags = contactsDto.getTags();
            List<String> actTags = response.jsonPath().getList("tags");
            Assert.assertEquals("Tags values are nolt match ", expTags, actTags);

            List<Map<String, String>> expProperties = contactsDto.getProperties();
            List<Map<String, String>> actProperties = response.jsonPath().getList("properties");
            Assert.assertEquals("Properties are not match ", expProperties, actProperties);

        }
    }


    // Get contact by ID
    @Given("I prepare request structure to get the contact")
    public void iPrepareRequestStructureToGetTheContact() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri")).basePath(prop.getProperty("basePath")).header("Accept", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).log().all();
    }

    @When("I hit an api")
    public void iHitAnApi(Map<String, String> table) {

        String endpoint;
        if (table.get("pathParam") == null || table.get("pathParam").equals("null")) {
            endpoint = table.get("endpoint");
        } else {
            endpoint = table.get("endpoint") + "/" + table.get("pathParam");
        }
        utilities = new Utilities();
        String httpMethod = table.get("httpMethod");
        utilities.execute(httpMethod, endpoint);


    }

    @Then("I verify the contact information using {string} and status code should be {long}")
    public void VerifyTheContact(String expectedId, long expectedStatusCode, Map<String, String> table) {

        //verify with the status code
        long actualStatusCode = (long) response.statusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);

        //verify with the ID
        boolean valid = Boolean.parseBoolean(table.get("valid"));

        if (valid) {
            if (expectedId == null || expectedId.equalsIgnoreCase("null") || expectedId.isEmpty()) {
                System.out.println("pathParam is null or empty");
            } else {
                String actualId = response.jsonPath().getString("id");
                Assert.assertEquals("ActualId is not equal to expected Id", expectedId, actualId);
            }
        } else {
            System.out.println("API response has no content");
        }
    }

    //verify the Listing contacts
    @Then("I verify the contact List and status code should be {int}")
    public void iVerifyTheContactListAndStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode, response.statusCode());

    }

    //Update properties of existing contact by ID(Partial update by PUT method)
    @Then("I verify the Update properties of a contact by ID and status code should be {int}")
    public void iVerifyTheUpdatePropertiesOfAContactByIDAndStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());

    }

    //update lead score of existing contact by ID {Using String Concept}
    @Given("I create request structure to update lead score is {int}")
    public void iCreateRequestStructureToUpdateLeadScoreIs(int lead_score, Map<String, String> table) {

        String body = "{\n" + "    \"id\": \"" + table.get("Id") + "\",\n" + "    \"lead_score\": \"" + lead_score + "\"\n" + "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri")).basePath(prop.getProperty("basePath")).header("Accept", ContentType.JSON).header("Content-Type", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(body).log().all();

    }

    @Then("I verfiy the Update lead score {int} and status code should be {int}")
    public void iVerfiyTheUpdateLeadScoreByIdAndStatusCodeShouldBe(int expLead_score, int statusCode) {

        Assert.assertEquals("Status code does not match expected code :" + statusCode + "actual code :" + response.statusCode(), statusCode, response.statusCode());
        int actLeead_score = response.jsonPath().get("lead_score");
        Assert.assertEquals(expLead_score, actLeead_score);
    }

    //update star value of existing contact by ID {Using String Concept}
    @Given("I create request structure to update star value is {int}")
    public void iCreateRequestStructureToUpdateStarValueIs(int starValue, Map<String, String> table) {

        String body = "{\n" + "    \"id\": \"" + table.get("Id") + "\",\n" + "    \"star_value\": " + starValue + "\n" + "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri")).basePath(prop.getProperty("basePath")).header("Accept", ContentType.JSON).header("Content-Type", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(body).log().all();

    }

    @Then("I verfiy the Update star value {int} and status code should be {int}")
    public void iVerfiyTheUpdateStarValueAndStatusCodeShouldBe(int expStarValue, int statusCode) {

        Assert.assertEquals("Status code is not matched ", statusCode, response.statusCode());
        int actStartValue = response.jsonPath().get("star_value");
        Assert.assertEquals("Star value are not matched ", expStarValue, actStartValue);
    }

    //Logic to update properties of a contact partial update using PUT method {here we update the properties partially}
    @Given("I create request structure to update properties of a contacts by ID using Serialization")
    public void iCreateRequestStructureToUpdatePropertiesOfAContactsByIDUsingSerialization(DataTable table) {

        iPrepareRequestStructureToGetTheContact();
        contact = table.asMaps();
        dataTable = contact.get(0);
        utilities = new Utilities();
        utilities.execute("GET", "contacts/" + dataTable.get("Id"));

        //iterate the properties GET by ID and Update with SetUpdateProperties Method
        List<Map<String, String>> propDetails = response.jsonPath().get("properties");
        List<Map<String, String>> returnProperties = utilities.setUpdateProperties(propDetails, dataTable);


        contactUpdatePropertiesDto = new ContactUpdatePropertiesDto();
        contactUpdatePropertiesDto.setId(dataTable.get("Id"));
        contactUpdatePropertiesDto.setProperties(returnProperties);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri")).basePath(prop.getProperty("basePath")).header("Accept", ContentType.JSON).header("Content-Type", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(contactUpdatePropertiesDto).log().all();

    }

    //Update the Tags
    @Given("I create request structure to update tags value")
    public void iCreateRequestStructureToUpdateTagsValue(DataTable table) {

        iPrepareRequestStructureToGetTheContact();
        contact = table.asMaps();
        dataTable = contact.get(0);
        utilities = new Utilities();
        utilities.execute("GET", "contacts/" + dataTable.get("Id"));

        contactUpdateTags =new ContactUpdateTags();
        contactUpdateTags.setId(dataTable.get("Id"));
        List<String> tags = utilities.setTagsForContacts(dataTable);
        contactUpdateTags.setTags(tags);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri")).basePath(prop.getProperty("basePath")).header("Accept", ContentType.JSON).header("Content-Type", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(contactUpdateTags).log().all();


    }

    @Then("I verfiy the Update tags and status code should be {int}")
    public void iVerfiyTheUpdateTagsAndStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode, response.statusCode());
        Assert.assertEquals(contactUpdateTags.getTags(),response.jsonPath().getList("tags"));
    }
       //Delete Tags by ID
    @Given("I create request structure to delete tags value")
    public void iCreateRequestStructureToDeleteTagsValue(DataTable table) {
        contact = table.asMaps();
        dataTable = contact.get(0);
        utilities = new Utilities();
        contactUpdateTags =new ContactUpdateTags();
        contactUpdateTags.setId(dataTable.get("Id"));
        List<String> tags = utilities.setTagsForContacts(dataTable);
        contactUpdateTags.setTags(tags);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri"))
                .basePath(prop.getProperty("basePath")).
                header("Accept", ContentType.JSON).header("Content-Type", ContentType.JSON).auth().basic(prop.getProperty("username"), prop.getProperty("password")).body(contactUpdateTags).log().all();

    }

    @Then("I verfiy the Delete tags and status code should be {int}")
    public void iVerfiyTheDeleteTagsAndStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode,response.statusCode());
    }

    //Delete single contacts
    @Given("I create request structure to delete single contact")
    public void iCreateRequestStructureToDeleteSingleContact() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(prop.getProperty("baseUri"))
                .basePath(prop.getProperty("basePath"))
                .header("Accept", ContentType.JSON)
                .header("Content-Type", ContentType.JSON)
                .auth().basic(prop.getProperty("username"), prop.getProperty("password"))
                .log().all();

    }

    @Then("I verfiy the Delete single contacts and status code should be {int}")
    public void iVerfiyTheDeleteSingleContactsAndStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode,response.statusCode());
    }
}
