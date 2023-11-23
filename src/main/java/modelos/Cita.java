/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HOME
 */
public class Cita {
    private String nombrePaciente;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaCita;
    private String horario;
    private Doctor medico;
    private int constultorioCita;
    private String analisisCita;
    private String estatus;

    public Cita(){
        
    }
    public Cita(String nombrePaciente, String apellidoPaterno, String apellidoMaterno, String fechaCita, String horario, Doctor medico, int constultorioCita, String analisisCita,String estatus) {
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaCita = fechaCita;
        this.horario = horario;
        this.medico = medico;
        this.constultorioCita = constultorioCita;
        this.analisisCita = analisisCita;
        this.estatus=estatus;
    }
    public Cita(String nombre,String fecha,String analisisCita)
    {
        this.nombrePaciente=nombre;
        this.fechaCita=fecha;
        this.analisisCita=analisisCita;
    }
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Doctor getMedico() {
        return medico;
    }

    public void setMedico(Doctor medico) {
        this.medico = medico;
    }

    public int getConstultorioCita() {
        return constultorioCita;
    }

    public void setConstultorioCita(int constultorioCita) {
        this.constultorioCita = constultorioCita;
    }

    public String getAnalisisCita() {
        return analisisCita;
    }

    public void setAnalisisCita(String analisisCita) {
        this.analisisCita = analisisCita;
    }

}
