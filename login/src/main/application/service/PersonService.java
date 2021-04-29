package main.application.service;

import main.bdo.Person;
import main.data.dao.PersonDAO;
import main.data.daoImpl.PersonDAOImpl;

import java.util.List;

public class PersonService {
    private static PersonService instance;
    private  PersonDAO personDAO;

    private PersonService(){
        personDAO = new PersonDAOImpl();
    }
    public static PersonService getInstance(){
        if(instance == null)
            instance = new PersonService();
        return  instance;
    }
    public void createPerson(String first_name, String last_name, String city, String favorite_color) {
        personDAO.createPerson(first_name,last_name,city,favorite_color);
    }
    public List<Person> getAll(){
        return  personDAO.getAll();
    }

    public List<Person> delete(Person person){
        return  personDAO.delete(person);
    }

}
