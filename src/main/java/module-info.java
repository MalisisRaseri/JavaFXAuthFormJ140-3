module com.example.javafxauthformj1403 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires javafx.base;


    opens com.example.javafxauthformj1403 to javafx.fxml, javafx.base, javafx.controls;
    opens com.example.javafxauthformj1403.Looks to javafx.fxml, javafx.base, javafx.controls;
    opens com.example.javafxauthformj1403.DBConnect to javafx.fxml, javafx.base, javafx.controls;
    opens com.example.javafxauthformj1403.DBInfo to javafx.fxml, javafx.base, javafx.controls;

    exports com.example.javafxauthformj1403;
}