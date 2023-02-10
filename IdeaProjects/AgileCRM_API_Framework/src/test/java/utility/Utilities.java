package utility;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.*;

public class Utilities extends BaseClass {

    //    Response response;
//   RequestSpecification requestSpecification;
    public List<String> setTagsForContacts(Map<String, String> data) {
        List<String> tagsData = new ArrayList<>();
        Map<String, String> tagsDataObj = new HashMap<>();
        if (Objects.nonNull(data.get("tags"))) ;
        {
            String[] dataObject = data.get("tags").split(",");
            for (String tagss : dataObject) {
//                tagsData.add(tagss);
                String tags = tagss;
                tagsData.add(tags);
            }

          /*  tagsDataObj.put("tag1",dataObject[0]);
            tagsDataObj.put("tag2",dataObject[1]);
            tagsData.add(tagsDataObj);*/
        }
        return tagsData;


           /* List<String> td=new ArrayList<>();

            if (Objects.nonNull(data.get("tags")));
            {
                String [] dataObj= data.get("tags").split(",");
                td.add(dataObj[0]);
                td.add(dataObj[1]);

            }*/
    }

    public List<Map<String, String>> setProperties(Map<String, String> data) {
        List<Map<String, String>> returnProperties = new ArrayList<>();

        Map<String, String> firstNameObj = new LinkedHashMap<>();
        firstNameObj.put("type", data.get("type"));
        firstNameObj.put("name", "first_name");
        firstNameObj.put("value", data.get("first_name"));
        returnProperties.add(firstNameObj);


        Map<String, String> lastNameObj = new LinkedHashMap<>();
        lastNameObj.put("type", data.get("type"));
        lastNameObj.put("name", "last_name");
        lastNameObj.put("value", data.get("last_name"));
        returnProperties.add(lastNameObj);

        Map<String, String> emailObj = new LinkedHashMap<>();
        emailObj.put("type", data.get("type"));
        emailObj.put("name", "email");
        emailObj.put("subtype", "work");
        emailObj.put("value", data.get("email"));
        returnProperties.add(emailObj);

        Map<String, String> phoneObj = new LinkedHashMap<>();
        phoneObj.put("type", data.get("type"));
        phoneObj.put("name", "phone");
        phoneObj.put("value", data.get("phone"));
        returnProperties.add(phoneObj);

        return returnProperties;
    }


    public static List<Map<String, String>> setUpdateProperties(List<Map<String, String>> propDetails, Map<String, String> dataTable) {

        String firstName = null;
        String lastName = null;

        String email = null;
        String phone = null;
        List<Map<String, String>> returnProperties = new ArrayList<>();
        ;

        for (Map<String, String> properties : propDetails) {

            if (properties.get("name").equals("first_name")) {
                if (Objects.nonNull(dataTable.get("first_name")))
//                if (dataTable.get("first_name") != null || dataTable.get("first_name").equals("null"))
                {
                    properties.get("name").equals("first_name");
                    firstName = properties.get("value");
                    firstName = dataTable.get("first_name");
                    Map<String, String> firstNameObj = new LinkedHashMap<>();
                    firstNameObj.put("type", properties.get("type"));
                    firstNameObj.put("name", "first_name");
                    firstNameObj.put("value", firstName);
                    returnProperties.add(firstNameObj);
                } else {
                    Map<String, String> firstNameObj = new LinkedHashMap<>();
                    firstNameObj.put("type", properties.get("type"));
                    firstNameObj.put("name", "first_name");
                    firstNameObj.put("value", properties.get("first_name"));
                    returnProperties.add(firstNameObj);
                }
            }


            if (properties.get("name").equals("last_name")) {
                if (Objects.nonNull(dataTable.get("last_name")))
//                if (dataTable.get("last_name") != null || dataTable.get("last_name").equals("null"))
                {
                    properties.get("name").equals("last_name");
                    lastName = properties.get("value");
                    lastName = dataTable.get("last_name");
                    Map<String, String> lastNameObj = new LinkedHashMap<>();
                    lastNameObj.put("type", properties.get("type"));
                    lastNameObj.put("name", "last_name");
                    lastNameObj.put("value", lastName);
                    returnProperties.add(lastNameObj);
                } else {
                    Map<String, String> lastNameObj = new LinkedHashMap<>();
                    lastNameObj.put("type", properties.get("type"));
                    lastNameObj.put("name", "last_name");
                    lastNameObj.put("value", properties.get("last_name"));
                    returnProperties.add(lastNameObj);
                }
            }
            if (properties.get("name").equals("email")) {
                if (Objects.nonNull(dataTable.get("last_name")))
//                if (dataTable.get("email") != null || dataTable.get("email").equals("null"))
                {
                    properties.get("name").equals("email");
                    email = properties.get("value");
                    email = dataTable.get("email");
                    Map<String, String> emailObj = new LinkedHashMap<>();
                    emailObj.put("type", properties.get("type"));
                    emailObj.put("name", "email");
                    emailObj.put("subtype", "work");
                    emailObj.put("value", email);
                    returnProperties.add(emailObj);
                } else {
                    Map<String, String> emailObj = new LinkedHashMap<>();
                    emailObj.put("type", properties.get("type"));
                    emailObj.put("name", "email");
                    emailObj.put("subtype", "work");
                    emailObj.put("value", properties.get("email"));
                    returnProperties.add(emailObj);
                }
            }
            if (properties.get("name").equals("phone")) {
                if (Objects.nonNull(dataTable.get("last_name")))
//                if (dataTable.get("phone") != null || dataTable.get("phone").equals("null"))
                {
                    properties.get("name").equals("phone");
                    phone = properties.get("value");
                    phone = dataTable.get("phone");
                    Map<String, String> phoneObj = new LinkedHashMap<>();
                    phoneObj.put("type", properties.get("type"));
                    phoneObj.put("name", "phone");
                    phoneObj.put("value", phone);
                    returnProperties.add(phoneObj);
                } else {
                    Map<String, String> phoneObj = new LinkedHashMap<>();
                    phoneObj.put("type", properties.get("type"));
                    phoneObj.put("name", "phone");
                    phoneObj.put("value", properties.get("phone"));
                    returnProperties.add(phoneObj);
                }
            }

        }
        return returnProperties;
    }

    public void execute(String httpMethod, String endpoint) {

        try {
            switch (httpMethod) {
                case "GET":
                    response = requestSpecification.get(endpoint);
                    break;

                case "POST":
                    response = requestSpecification.post(endpoint);
                    break;

                case "DELETE":
                    response = requestSpecification.delete(endpoint);
                    break;

                case "PUT":
                    response = requestSpecification.put(endpoint);
                    break;

                default:
                    System.out.println("Invalid httpMethod please check the method in feature file");
                    throw new Exception("http method did not match");
            }
            response.prettyPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
