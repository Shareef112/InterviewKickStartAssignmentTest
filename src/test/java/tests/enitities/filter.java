package tests.enitities;

public class filter {
    private String experience;
    private String type;
    private String skill;
    private String companyName;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }



    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }




    @Override
    public String toString() {
        return "filter{" +
                "experience='" + experience + '\'' +
                ", type='" + type + '\'' +
                ", skill=" + skill +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }


}
