package tests.enitities;

public class StudentRequest {
    private long studentId;
    private filter filter;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public filter getFilter() {
        return filter;
    }

    public void setFilter(filter filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "studentId=" + studentId +
                ", filter=" + filter +
                '}';
    }
}


