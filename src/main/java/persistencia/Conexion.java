/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ll621
 */
public class Conexion {
    Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost/farmaceutica_luis_alejandro";//Guardarmos la URL de nuestra base de datos
    private static final String USUARIO = "root";//Contraseña de acceso al servidor
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";//Ruta del driver que estaremos utilizando, en este caso Mysql

    
    
    public Connection obtenerConexion() {
        System.out.println("Conectando a la base de datos...");
        try { // Se carga el driver JDBC-ODBC
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver JDBC");//No localizo la base de datos
        }
        //En caso de que no haya sido localizado, es porque no fue descargado el archivo, verificar en el pom.xml si fue descargado en las dependencias
        
        try { // Se establece la conexión con la base de datos
            conn = DriverManager.getConnection(URL + "?" + "user=" + USUARIO);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {

            System.out.println("No se pudo establecer la conexión con la base de datos.");
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
    /*
    public static void main(String[] args){
        Conexion c1=new Conexion();
        c1.obtenerConecxion();
    }
*/
}
