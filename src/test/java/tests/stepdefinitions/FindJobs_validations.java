package tests.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tests.businessLogics.FindJobsTests;

public class FindJobs_validations extends FindJobsTests {

    @Given("^User executed the FindJobs api with \"([^\"]*)\"$")
    public void user_executed_the_FindJobs_api_with(String request) throws Throwable {
        getJobsList(request);
    }

    @Then("^User Should see (\\d+) response code in the status$")
    public void user_Should_see_response_code_in_the_status(int responseCode) throws Throwable {
        validate_reponse_code( responseCode);
    }

    @Then("^User should validate the response as per the request$")
    public void user_should_validate_the_response_as_per_the_request() throws Throwable {
        validate_reponse_as_per_the_request();
    }

    @Then("^User should validate the error response as per the request$")
    public void user_should_validate_the_error_response_as_per_the_request() throws Throwable {
        validate_error_reponse_as_per_the_request();
    }


}
