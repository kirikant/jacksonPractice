package practice.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import practice.dto.Student;
import practice.storage.StudentStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "student", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    private StudentStorage studentStorage = StudentStorage.getStudentStorage();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(objectMapper.writeValueAsString(studentStorage.getStudents()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = objectMapper.readValue(req.getInputStream(), Student.class);
        studentStorage.addStudent(student);
    }
}
