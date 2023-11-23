module Controladores {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens Controladores to javafx.fxml;
    exports Controladores;
    opens modelos;//Importar los modelos a todo el sistema

   
}
