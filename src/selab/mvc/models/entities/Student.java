package selab.mvc.models.entities;

import selab.mvc.models.Model;

import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;

    private ArrayList<Course> courses;

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void addCourse(Course course) {
        coureses.add(course);
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        // TODO: Calculate and return the average of the points
        return 0;
    }

    public String getCourses() {
        String result = "";
        for(Course course : this.courses) {
            result += course.getName() + ' - ';
        }

        return result;
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }
}
