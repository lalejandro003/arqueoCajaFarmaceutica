/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HOME
 */
public class Doctor {
    private String nombreDoctor;
    private String cedulaProfesional;

    public Doctor(){
        
    }

    @Override
    public String toString() {
        return this.nombreDoctor;
    }
    public Doctor(String nombreDoctor, String cedulaProfesional) {
        this.nombreDoctor = nombreDoctor;
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }
    
}
