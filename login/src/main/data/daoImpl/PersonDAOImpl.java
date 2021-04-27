package main.data.daoImpl;

import main.bdo.Person;
import main.data.dao.PersonDAO;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

     List<Person> personList = new ArrayList<>();
    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public List<Person> delete(Person person) {
        List<Person> tmp = new ArrayList<>();
        for(Person P : personList){
           if (P.getFirst_name().equals(person.getFirst_name()) && P.getLast_name().equals(person.getLast_name()) &&
                   P.getCity().equals(person.getCity()) && P.getFavorite_color().equals(person.getFavorite_color()) ){
               personList.remove(P);
               return personList;
           }
        }
        return personList;
    }

    @Override
    public void createPerson(String first_name, String last_name, String city, String favorite_color) {
        Person tmp = new Person(first_name,last_name, city, favorite_color);
        personList.add(tmp);
    }
}
