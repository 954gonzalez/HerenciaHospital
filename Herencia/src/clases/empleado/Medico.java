package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{
	
	private String especialidad; 
	private int numeroDeConsultorio;
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		this.numeroDeConsultorio = numeroDeConsultorio;
	}
	
    @Override
    public void registrarDatos() {
    	super.registrarDatos();
    	
    	especialidad=JOptionPane.showInputDialog("ingrese su especialidad");
    	numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Num consultorio"));
    }
}
