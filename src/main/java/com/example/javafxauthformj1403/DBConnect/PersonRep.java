package com.example.javafxauthformj1403.DBConnect;


import com.example.javafxauthformj1403.DBInfo.Person;

import java.util.List;

public interface PersonRep {
        List<Person> getPersons();
        Person getPersonById(int id);

    }


