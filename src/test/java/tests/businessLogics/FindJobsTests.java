package tests.businessLogics;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tests.enitities.StudentRequest;
import tests.utils.Apiutils;
import tests.utils.PropertiesConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FindJobsTests extends Apiutils {
    private static final int NO_STUDENT_FOUND_CODE=401;
    private static final int NO_JOBS_FOUND_CODE=404;
    private static String baseURI;

    static {
        try {
            baseURI = PropertiesConfig.readProperties().getProperty("URI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    RequestSpecification httprequest = getRequestWithJSONHeaders();

    public Response getJobsList() throws FileNotFoundException {
        String uri = baseURI+"getJobs";
        JsonReader reader = new JsonReader(new FileReader("file.json"));
        StudentRequest request = new Gson().fromJson(reader, StudentRequest.class);
        return sendRequest(httprequest,Apiutils.GET_REQUEST,uri,request);


    }
}
