module com.mycompany.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.assignment2 to javafx.fxml;
    exports com.mycompany.assignment2;
}
