package tests.enitities;

import java.util.List;

public class JobsResponse {
    private List<JobsVO> jobslist;

    public List<JobsVO> getJobslist() {
        return jobslist;
    }

    public void setJobslist(List<JobsVO> jobslist) {
        this.jobslist = jobslist;
    }

    @Override
    public String toString() {
        return "JobsResponse{" +
                "jobslist=" + jobslist +
                '}';
    }
}


