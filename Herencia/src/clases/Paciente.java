package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paciente extends Persona{
	private int numeroHistoriaClinica;
	private String sexo; 
	private String grupoSanguineo; 
	private ArrayList<String> listaMeicamentosAlergico;
	
	public int getNumeroHistoriaClinica() {
		return numeroHistoriaClinica;
	}
	public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
		this.numeroHistoriaClinica = numeroHistoriaClinica;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getGruposSanguineo() {
		return grupoSanguineo;
	}
	public void setGruposSanguineo(String gruposSanguineo) {
		this.grupoSanguineo = gruposSanguineo;
	}
	public ArrayList<String> getListaMeicamentosAlergico() {
		return listaMeicamentosAlergico;
	}
	public void setListaMeicamentosAlergico(ArrayList<String> listaMeicamentosAlergico) {
		this.listaMeicamentosAlergico = listaMeicamentosAlergico;
	}
	
	@Override
	public void registrarDatos() {
		
		super.registrarDatos();
		
		//llenamos los siguientes datos especificos del paciente
		
		listaMeicamentosAlergico=new ArrayList<String>();
		numeroHistoriaClinica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia del clinica: "));
		sexo=JOptionPane.showInputDialog("Ingrese el sexo: ");
		grupoSanguineo=JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
		
		String pregunta= JOptionPane.showInputDialog("�Es alegico a algun medicamento? ingrese si o no ");
		
		if (pregunta.equalsIgnoreCase("si")) {
			String medicamento="";
			String continuar="";
			do {
				medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento:");
				listaMeicamentosAlergico.add(medicamento);
				continuar=JOptionPane.showInputDialog("Ingrese si, si desea continuar: ");
				
			}while(continuar.equalsIgnoreCase("si"));
			
		}
		
	}
	
	

}

