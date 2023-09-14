package UI;

import Model.Maestro;
import Model.Secretaria;

import java.util.ArrayList;
import java.util.Scanner;

public class UISecretaria {
    public static ArrayList<Secretaria> secretariasConCitasDisponibles = new ArrayList<>();

    public static void mostrarMenuSecretaria() {
        System.out.println("..::Secretaria::..");
        System.out.println("Bienvenido " + UIMenu.secretariaLogeado.getNombre());
        System.out.println("1.- Registrar un cita diponible");
        System.out.println("2.- Mostrar sus citas agendados");
        System.out.println("0.- Cerrar sesion");

        int respuesta = 0;
        Scanner sc = new Scanner(System.in);
        do {
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    mostrarRegistrarCita();
                    break;
                case 2:
                    mostrarMisCitas();
                    break;
                case 0:
                    System.out.println("Adios");
                    UIMenu.mostrarMenu();
                    break;
                default:
                    System.out.println("Seleccione una opcion correcta");
            }
        }while (respuesta != 0);
    }

    private static void mostrarMisCitas() {

        if (UIMenu.secretariaLogeado.getCitasDisponibles().isEmpty()) {
            System.out.println("La secretaria no tiene citas disponibles.");
        } else {
            for(Secretaria.CitaSecretariaDisponible citaSecretariaDisponible : UIMenu.secretariaLogeado.getCitasDisponibles()){
                System.out.println("");
            }
        }
    }

    private static void mostrarRegistrarCita() {
        int respuesta = 0;
        do{
            System.out.println("..::Agendar un curso::..");
            System.out.println("Ingresa la fecha a registrar: [dd/mm/yyyy]");

            Scanner sc = new Scanner(System.in);
            String fecha = sc.nextLine();

            System.out.println("La fecha seleccionada es: " + fecha + "\n1.-Continuar\n2.-Cambiar fecha");
            int respuestaFecha = Integer.valueOf(sc.nextLine());
            if (respuestaFecha != 1) continue;

            int respuestaHora = 0;
            String hora = "";
            do{
                System.out.println("Ingrese la hora disponible: [16:00]");
                hora = sc.nextLine();
                System.out.println("La hora seleccionada es: " + hora + "\n1.-Continuar\n2.-Cambiar hora");
                respuestaHora = Integer.valueOf(sc.nextLine());
            }while (respuestaHora != 1);

            UIMenu.secretariaLogeado.addCitaDisponible(fecha, hora);
            consultarExistenciaEnSecretariasConcitas(UIMenu.secretariaLogeado);
        }while (respuesta != 0);
    }

    public static void consultarExistenciaEnSecretariasConcitas(Secretaria secretaria){
        if(!secretariasConCitasDisponibles.contains(secretaria)){
            secretariasConCitasDisponibles.add(secretaria);
        }
    }
}
