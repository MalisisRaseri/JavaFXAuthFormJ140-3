package com.example.javafxauthformj1403.Looks;
import com.example.javafxauthformj1403.DBConnect.DomainRep;
import com.example.javafxauthformj1403.DBConnect.DomainRepImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.javafxauthformj1403.Looks.PersonLookController.person;

public class DomainLookController  implements Initializable {

    @FXML
    private TableView<DomainTable> domainTable;
    @FXML
    private TableColumn<DomainTable, String> webNameColumn;
    @FXML
    private TableColumn<DomainTable, String> domainNameColumn;
    @FXML
    private TableColumn<DomainTable, String> ipColumn;
    @FXML
    private TableColumn<DomainTable, LocalDate> registrationDateColumn;
    @FXML
    private TableColumn<DomainTable, String> countryColumn;

    private final DomainRep domainRepository;
    private final PersonLookController personLookController;

    public DomainLookController(){
        domainRepository = new DomainRepImpl();
        personLookController = new PersonLookController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<DomainTable> observableList = FXCollections.observableArrayList();
        domainRepository.getDomainByPersonId(person.getId()).forEach(domain -> {
            observableList.add(new DomainTable(
                    domain.getWebName(),
                    domain.getDomainName(),
                    domain.getIp(),
                    domain.getRegistrationDate(),
                    domain.getCountry()
            ));
        });

        webNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webName"));
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainName"));
        ipColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("ip"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, LocalDate>("registrationDate"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("country"));
        domainTable.setItems(observableList);
    }


}
