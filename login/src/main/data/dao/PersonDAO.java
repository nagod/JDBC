package main.data.dao;

import main.bdo.Person;
import java.util.List;
public interface PersonDAO {
    List<Person> add(Person person);
    List<Person> delete(Person person);
}
