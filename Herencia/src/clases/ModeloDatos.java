package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class ModeloDatos {
	
	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual>empleadosEventualMap ;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica>citasList;

	public ModeloDatos() {
		pacientesMap=new HashMap<String,Paciente>();
		empleadosPlanillaMap=new HashMap<String, EmpleadoPlanilla>();
		medicosMap=new HashMap<String, Medico>();
		empleadosEventualMap=new HashMap<String,EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();	
	}
	public void registrarPersona(Paciente miPaciente) {
		pacientesMap.put(miPaciente.getNumeroDeDNI(),miPaciente);
		System.out.println("se ha registrado el paciente " +miPaciente.getNombre()+"Satisfactoriamente");
		
	}
	public void registrarPersona(EmpleadoPlanilla miEmPlanilla) {
		empleadosPlanillaMap.put(miEmPlanilla.getNumeroDeDNI(), miEmPlanilla);
		System.out.println("Se ha registrado el empleadoeventual " +miEmPlanilla.getNombre()+" satisfactoriamente");
		
	}
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(),miEmpEventual);
		System.out.println("Se ha registrado el empleadoeventual " +miEmpEventual.getNombre()+" satisfactoriamente");
	}
	
	public void registrarPersona(Medico miMedico) {
		medicosMap.put(miMedico.getNumeroDeDNI(),miMedico);
		System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
	}
	
	public void imprimirPacientes() {
		String msj="PACIENTES REGISTRADOS\n";
		Iterator<String> iterador=pacientesMap.keySet().iterator();
		while (iterador.hasNext()) {
			String clave = iterador.next();
			pacientesMap.get(clave).imprimirDatosPersona(msj);
			
		}
	}
	
	public void imprimirEmpleadosEventuales() {
		String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
		
		for(String clave: empleadosEventualMap.keySet()) {
			empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
		}
	}
	public void imprimirEmpleadosPorPlanilla() {
		String msj="EMPLEADOR POR PLANILLA REGISTRADOS\n";
		
		for(EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
			empleadoPlanilla.imprimirDatosPersona(msj);
		}
	}
	
	public void imprimirMedicos() {
		String msj="MEDICOS REGISTRADOS\n";
		
		for(Map.Entry<String, Medico> elemento: medicosMap.entrySet()) {
			elemento.getValue().imprimirDatosPersona(msj);
		}
		
	}
	
	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente=null;
		
		if(pacientesMap.containsKey(documentoPaciente)) {
			miPaciente=pacientesMap.get(documentoPaciente);
			
		}
		return miPaciente;
		
	}
	
	public Medico consultarMedicoPorNombre(String nombreMedico) {
		for(Medico medico : medicosMap.values()) {
			if(medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}
		}
		return null;
	}
	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente");
		System.out.println(miCita.informacionCitaMedica());
		
	}
	public void imprimirCitasMedicasProgramadas() {
		String msj="CITAS MEDICAS PROGRAMADAS\n";
		CitaMedica miCita=null;
		
		System.out.println(msj+"\n");
		
		if(citasList.size()>0) {
			for(int i =0; i<citasList.size();i++) {
				miCita=citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
			}
			
		}else {
			System.out.println("No existen citas programadas");
		}
		
	}
	
}
