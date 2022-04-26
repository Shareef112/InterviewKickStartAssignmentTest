package tests.enitities;

public class JobsVO {
    private long jobId;
    private String company;
    private String location;
    private String experience;
    private String skill;
    private String description;
    private String type;
    private String Contact;

    public JobsVO(long jobId, String company, String location, String experience,String skill, String description, String type, String contact) {
        this.jobId = jobId;
        this.company = company;
        this.location = location;
        this.experience = experience;
        this.skill = skill;
        this.description = description;
        this.type = type;
        Contact = contact;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return "JobsVO{" +
                "jobId=" + jobId +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", experience='" + experience + '\'' +
                ", description='" + description + '\'' +
                ", skill='" + skill + '\'' +
                ", type='" + type + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }


}
