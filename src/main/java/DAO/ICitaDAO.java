/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import modelos.Cita;
import modelos.Doctor;

/**
 *
 * @author HOME
 */
public interface ICitaDAO {
    public void registrarCita(Cita cita,Doctor doctor);
    public boolean busquedaCita(String fecha, String horario);
    public List<Cita> mostrarCitas(String nombreDoctor,String fecha);
    
}
