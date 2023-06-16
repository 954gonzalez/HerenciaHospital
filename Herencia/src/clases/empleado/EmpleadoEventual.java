package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
	private double honorariosPorHora; 
	private String fechaTerminoContrato;
	
	public double getHonorariosPorHora() {
		return honorariosPorHora;
	}
	public void setHonorariosPorHora(double honorariosPorHora) {
		this.honorariosPorHora = honorariosPorHora;
	}
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	 @Override
	    public void registrarDatos() {
	    	super.registrarDatos();
	    	
	    	honorariosPorHora=Double.parseDouble(JOptionPane.showInputDialog("ingrese el salario mensual")) ;
	    	fechaTerminoContrato=JOptionPane.showInputDialog("ingrese fecha de nacimiento(dd/mm/aa)");
	    }

}

