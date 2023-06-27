module com.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens com.gui to javafx.fxml;
    opens com.hibernate to org.hibernate.orm.core;
    exports com.gui;
    exports com.utils;
    opens com.utils to javafx.fxml;
}