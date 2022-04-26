package tests.enitities;

public class StudentError {
    private int status_code;
    private String description;

    public StudentError(int status_code, String description) {
        this.status_code = status_code;
        this.description = description;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StudentError{" +
                "status_code=" + status_code +
                ", description=" + description +
                '}';
    }
}
