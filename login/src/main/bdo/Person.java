package main.bdo;

import java.util.Date;

public class Person {

    private String first_name, last_name, city,favorite_color;

    public Person(String first_name, String last_name, String city, String favorite_color) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.favorite_color = favorite_color;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFavorite_color() {
        return favorite_color;
    }

    public void setFavorite_color(String favorite_color) {
        this.favorite_color = favorite_color;
    }
}
