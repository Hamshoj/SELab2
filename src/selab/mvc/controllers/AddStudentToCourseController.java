package selab.mvc.controllers;

import org.json.JSONObject;
import selab.mvc.models.DataContext;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;

public class AddStudentToCourseController extends Controller {

    public AddStudentToCourseController(DataContext dataContext) {
        super(dataContext);
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        if (!method.equals("POST"))
            throw new IOException("Method not supported");

        JSONObject input = readJson(body);
        String studentNo = input.getString("studentNo");
        String courseNo = input.getString("courseNo");
        String points = input.getString("points");

        Course course = dataContext.getCourseByCourseNo(courseNo);
        Student student = dataContext.getStudentByStudentNo(studentNo);

        course.addStudent(student);
        student.addCourse(course);

        return null;
    }
}
