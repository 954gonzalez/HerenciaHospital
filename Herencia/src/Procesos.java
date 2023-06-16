import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class Procesos {
	ModeloDatos miModeloDatos;
	public Procesos() {
		miModeloDatos=new ModeloDatos();
		presentarMenuOpciones();
	}
	
	private void presentarMenuOpciones() {
		String menu ="MENU HOSPITAL \n\n";
		menu+="1.Registrar Paciente\n";
		menu+="2.Registrar Empleados\n";
		menu+="3.Registrar Cita Medica\n";
		menu+="4.Imprimir Informacion\n";
		menu+="5.Salir\n";
		menu+="Ingrese una Opcion\n";
		int opcion =0;
		
		do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1:registrarPaciente(); break;
			case 2:registrarEmpleado(); break;
			case 3:registrarCitaMedica(); break;
			case 4:imprimirInformacion(); break;
			case 5:System.out.println("El sistema ha terminado"); break;
			default: System.out.println("No existe el código, verifique nuevamente");
				break;
				
		

			
				
			}
		}while(opcion!=5);
	}

	private void imprimirInformacion() {
		
		String menuImprimir="MENU IMPRESIONES\n";
		menuImprimir+="1. Listar Pcientes\n";
		menuImprimir+="2. Listar Empleados Eventuales\n";
		menuImprimir+="3. Listar Empleados Por Planilla\n";		
		menuImprimir+="4. Listar Medicos\n";
		menuImprimir+="5. Listar Citas Programadas";
		menuImprimir+="Ingrese una opcion\n";
		System.out.println("***************************************");
		
		int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		switch (opcion) {
		case 1: miModeloDatos.imprimirPacientes(); break;
		case 2: miModeloDatos.imprimirEmpleadosEventuales();  break;
		case 3: miModeloDatos.imprimirEmpleadosPorPlanilla(); break;
		case 4: miModeloDatos.imprimirMedicos();    break;
		case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); break;
		
		default: System.out.println("No existe esa opcion");
			break;
		}
	}

	private void registrarCitaMedica() {
		String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
		
		Paciente pacienteEncontrado=miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
		
		if(pacienteEncontrado!=null) {
			String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del medico");
			Medico medicoEncontrado=miModeloDatos.consultarMedicoPorNombre(nombreMedico);
			
			if(medicoEncontrado!=null) {
				String servicio=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
				String fechaConslta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
				
				String lugar="la cita será en el consultorio " +medicoEncontrado.getNumeroDeConsultorio();
				CitaMedica miCita=new CitaMedica(pacienteEncontrado,medicoEncontrado,servicio,fechaConslta,horaConsulta,lugar);
				miModeloDatos.registrarCitaMedica(miCita);
				
			}else {
				System.out.println("El medico no se encuentre registrado en el sistema");
			}
			
		}else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}
		
	}

	private void registrarEmpleado() {
		String menuTipoEmpleado="Registro de Empleado\n";
		menuTipoEmpleado+="1. Empleado Eventual\n";
		menuTipoEmpleado+="2. Empleado por Plantilla";
		menuTipoEmpleado+="Seleccione el tipo empleado a registrar\n";
		
		int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		switch(tipoEmpleado) {
		case 1: //Registro Empleado Eventual
			EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
			miEmpleadoEventual.registrarDatos();
			miModeloDatos.registrarPersona(miEmpleadoEventual);
		 break;
		case 2: 
			String resp=JOptionPane.showInputDialog("Ingrese si, si es un medico, de lo contrario es otro tipo de empleado");
			if(resp.equalsIgnoreCase("si")) {
				//Registrar Medico
				Medico miMedico=new Medico();
				miMedico.registrarDatos();
				miModeloDatos.registrarPersona(miMedico);
			}else {
				//Registro Empleado Planilla
				EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
				miEmpleadoPlanilla.registrarDatos();
				miModeloDatos.registrarPersona(miEmpleadoPlanilla);
			}
			
			   break;
			
			default:System.out.println("El tipo de empleadono esvalido, intentelo nuevamente");
			   break;
		}
	}

	private void registrarPaciente() {
		Paciente miPaciente=new Paciente();
		miPaciente.registrarDatos();
		
		miModeloDatos.registrarPersona(miPaciente);
		
	}

}
