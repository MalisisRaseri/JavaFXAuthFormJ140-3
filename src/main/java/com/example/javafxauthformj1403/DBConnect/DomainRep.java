package com.example.javafxauthformj1403.DBConnect;

import com.example.javafxauthformj1403.DBInfo.Domain;
import com.example.javafxauthformj1403.DBInfo.Person;

import java.util.List;

public interface DomainRep {
        List<Domain> getDomains();
        List<Domain> getDomainByPerson(Person person);
        List<Domain> getDomainByPersonId(Integer personId);

    }

