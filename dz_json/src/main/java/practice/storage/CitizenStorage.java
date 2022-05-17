package practice.storage;

import practice.dto.Citizen;
import practice.dto.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitizenStorage {

    private static CitizenStorage citizenStorage= new CitizenStorage();

    private CitizenStorage() {
    }

    private List<Citizen> citizens = new ArrayList<>();

    public  List<Citizen> getCitizens() {
        return Collections.unmodifiableList(citizens);
    }

    public  void addCitizen (Citizen citizen){
        citizens.add(citizen);
    }

    public static CitizenStorage getCitizenStorage() {
        return citizenStorage;
    }

}
