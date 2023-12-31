package com.example.javafxauthformj1403.Looks;
import com.example.javafxauthformj1403.DBConnect.DomainRep;
import com.example.javafxauthformj1403.DBConnect.DomainRepImpl;
import com.example.javafxauthformj1403.DBConnect.PersonRep;
import com.example.javafxauthformj1403.DBConnect.PersonRepImpl;
import com.example.javafxauthformj1403.DBInfo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonLookController implements Initializable {

    @FXML
    private TableView<PersonTable> personTable;
    @FXML
    private TableColumn<PersonTable, Integer> idColumn;
    @FXML
    private TableColumn<PersonTable, String> jobTitleColumn;
    @FXML
    private TableColumn<PersonTable, String> firstNameLastNameColumn;
    @FXML
    private TableColumn<PersonTable, String> phoneColumn;
    @FXML
    private TableColumn<PersonTable, String> emailColumn;
    @FXML
    private TableColumn<PersonTable, Integer> domainsNumberColumn;

    public static Person person;
    private final PersonRep personRepository;
    private final DomainRep domainRepository;

    public PersonLookController(){
        personRepository = new PersonRepImpl();
        domainRepository = new DomainRepImpl();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList();
        personRepository.getPersons().forEach(person -> {
            int domainsNumber = domainRepository.getDomainByPersonId(person.getId()).size();
            observableList.add(new PersonTable(
                    person.getId(),
                    person.getJobTitle(),
                    person.getFirstNameLastName(),
                    person.getPhone(),
                    person.getEmail(),
                    domainsNumber
            ));
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobTitle"));
        firstNameLastNameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("firstNameLastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        domainsNumberColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("domainsNumber"));
        personTable.setItems(observableList);

        personTable.setOnMouseClicked(e->{
            if(e.getClickCount()==2){
                try {
                    person = personRepository.getPersonById(personTable.getSelectionModel().getSelectedItem().getId());
                    new DomainLook().init();
                } catch (IOException ex) {
                    Logger.getLogger(PersonLookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


}

