package main.data.dao;

import main.bdo.Person;
import java.util.List;
public interface PersonDAO {
    List<Person> getAll();
    List<Person> delete(Person person);
    void createPerson(String first_name, String last_name, String city, String favorite_color);
}
