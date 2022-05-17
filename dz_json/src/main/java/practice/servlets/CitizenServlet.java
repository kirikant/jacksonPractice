package practice.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import practice.dto.Citizen;
import practice.storage.CitizenStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "citizen", urlPatterns = "/citizens")
public class CitizenServlet extends HttpServlet {

    private CitizenStorage citizenStorage = CitizenStorage.getCitizenStorage();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(objectMapper
                .writeValueAsString(citizenStorage.getCitizens()));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        citizenStorage.addCitizen(objectMapper.readValue(req.getInputStream(), Citizen.class));
    }
}
