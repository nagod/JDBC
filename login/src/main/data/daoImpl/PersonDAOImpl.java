package main.data.daoImpl;

import main.bdo.Person;
import main.data.dao.PersonDAO;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

     List<Person> personList = new ArrayList<>();
    @Override
    public List<Person> add(Person person) {
        return null;
    }

    @Override
    public List<Person> delete(Person person) {
        return null;
    }
}
