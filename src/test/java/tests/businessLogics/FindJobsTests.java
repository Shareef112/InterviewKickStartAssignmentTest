package tests.businessLogics;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import tests.enitities.*;
import tests.utils.Apiutils;
import tests.utils.PropertiesConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindJobsTests extends Apiutils {
    private static final int NO_STUDENT_FOUND_CODE=401;
    private static final int NO_JOBS_FOUND_CODE=404;
    private static String baseURI;
    public static Response response;
    private static  StudentRequest request;

    private List<JobsVO> jobsList = new ArrayList<>(Arrays.asList(
            new JobsVO(2345,"ABC", "Hyderabad", "3-5","java,sql", "mid senior", "perm","1111111"),
            new JobsVO(8524,"xyz", "Banglore", "3-5","java,sql", "mid senior", "cont","5555555")
    ));
    private List<StudentVO> studentsList = new ArrayList<>(Arrays.asList(
            new StudentVO(123,"Students","Student1","s@gmail.com","9999999"),
            new StudentVO(124,"Student","Students1","s2@gmail.com","8888888")
    ));


    static {
        try {
            baseURI = PropertiesConfig.readProperties().getProperty("URI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    RequestSpecification httprequest = getRequestWithJSONHeaders();

    public void getJobsList(String requestString) throws FileNotFoundException {
        String uri = baseURI+"getJobs";
        JsonReader reader = new JsonReader(new FileReader("src/test/resources/testData/Jsons/getJobs.json"));
         request = new Gson().fromJson(reader, StudentRequest.class);
        if(!requestString.equals("")){
            filter filter = request.getFilter();
            String[] requests = requestString.split("&&");
            for(String requestStr:requests){
                if(requestStr.contains("studentId")){
                    request.setStudentId(Long.parseLong(requestStr.split(":")[1]));
                }
                else if(requestStr.contains("experience")){
                    filter.setExperience(requestStr.split(":")[1]);
                }
                else if(requestStr.contains("type")){
                    filter.setType(requestStr.split(":")[1]);
                }
                else if(requestStr.contains("skill")){
                    filter.setSkill(requestStr.split(":")[1]);
                }
                else if(requestStr.contains("companyName")){
                    filter.setCompanyName(requestStr.split(":")[1]);
                }
                else if(requestStr.contains("location")){
                    filter.setLocation(requestStr.split(":")[1]);
                }
                request.setFilter(filter);
            }
        }

        response= sendRequest(httprequest,Apiutils.GET_REQUEST,uri,request);


    }
    public void validate_reponse_code(int reponseCode){
        verifyResponseStatusValue(response,reponseCode);
    }

    public void validate_reponse_as_per_the_request(){

        JobsResponse serViceResponse = new Gson().fromJson(response.body().prettyPrint(), JobsResponse.class);
        JobsResponse jobsResponse = getJobs();

        Assert.assertEquals(jobsResponse.toString(),serViceResponse.toString());
    }
    private JobsResponse getJobs(){
        filter f = request.getFilter();
        JobsResponse jobsResponse = new JobsResponse();
        List<JobsVO> jobslist = new ArrayList<>();
        if(f.getLocation().equals("any") && f.getCompanyName().equals("any")){
            for(JobsVO jobs: jobsList){
                if(jobs.getExperience().equals(f.getExperience())&&jobs.getSkill().equals(f.getSkill())){
                    jobslist.add(jobs);
                }

            }
        }
        else if(f.getLocation().equals("any") && !f.getCompanyName().equals("any")){
            for(JobsVO jobs: jobsList){
                if(jobs.getExperience().equals(f.getExperience())&&jobs.getSkill().equals(f.getSkill())&&
                        jobs.getCompany().equals(f.getCompanyName())){
                    jobslist.add(jobs);
                }

            }
        }
        else if(!f.getLocation().equals("any") && f.getCompanyName().equals("any")){
            for(JobsVO jobs: jobsList){
                if(jobs.getExperience().equals(f.getExperience())&&jobs.getSkill().equals(f.getSkill())&&
                        jobs.getLocation().equals(f.getLocation())){
                    jobslist.add(jobs);
                }

            }
        }
        else {
            for(JobsVO jobs: jobsList){
                if(jobs.getExperience().equals(f.getExperience())&&jobs.getSkill().equals(f.getSkill())&&
                        jobs.getCompany().equals(f.getCompanyName()) && jobs.getLocation().equals(f.getLocation())){
                    jobslist.add(jobs);
                }

            }
        }
        jobsResponse.setJobslist(jobslist);
        return jobsResponse;
    }



    public void validate_error_reponse_as_per_the_request(){
        filter f = request.getFilter();
        StudentError error = new Gson().fromJson(response.body().prettyPrint(), StudentError.class);
       if(!getStudent(request.getStudentId())){
           Assert.assertEquals(error.getStatus_code(),401);
           Assert.assertEquals(error.getDescription(),"No Student found");
       }
       else if(getJobs().getJobslist().size()==0){
           Assert.assertEquals(error.getStatus_code(),404);
           Assert.assertEquals(error.getDescription(),"No Jobs found");
       }
    }

    private boolean getStudent(Long id){
        boolean flag = false;
        for(StudentVO studentVO : studentsList){
            if(studentVO.getStudentID() ==id){
                flag = true;
                break;
            }
        }
        return flag;
    }

}
