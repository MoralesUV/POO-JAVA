package UI;

import Model.Maestro;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIEstudiante {
    public static void mostrarMenuEstudiante(){
        int respuesta = 0;
        do {
            System.out.println("\n\n");
            System.out.println("..::Estudiante::..");
            System.out.println("Bienvenido: " + UIMenu.estudianteLogeado.getNombre());
            System.out.println("1.- Reservar curso");
            System.out.println("2.- Mis cursos reservadoss");
            System.out.println("0.- Cerrar sesion");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    reservarCurso();
                    break;
                case 2:
                    mostrarMisReservas();
                    break;
                case 0:
                    UIMenu.mostrarMenu();
                    break;
                default:
                    break;
            }
        }while (respuesta !=0);
    }

    private static void reservarCurso(){
        int respuesta = 0;
        do {
            System.out.println("Reservar curso");
            System.out.println("..::Seleccione una fecha::..");

            // 1. Doctor#1
            // - - - Fecha#1
            // - - - Fecha#2
            // 2. Doctor#2
            // - - - Fecha#1
            // - - - Fecha#2
            // 3. Doctor#3
            // - - - Fecha#1
            // - - - Fecha#2

            int k = 0;
            Map<Integer, Map<Integer, Maestro>> maestros = new TreeMap<>();
            for (int i = 0; i < UIMaestro.maestrosConCursosDisponibles.size(); i++) {
                ArrayList<Maestro.CursoDisponible> cursosDisponibles = UIMaestro.maestrosConCursosDisponibles.get(i).getCursosDisponibles();

                Map<Integer, Maestro> maestroCursosDisponibles = new TreeMap<>();
                for (int j = 0; j < cursosDisponibles.size(); j++) {
                    k++;
                    System.out.println(k + ".- " + cursosDisponibles.get(j).getFecha());
                    maestroCursosDisponibles.put(Integer.valueOf(j), UIMaestro.maestrosConCursosDisponibles.get(i));
                    maestros.put(Integer.valueOf(k), maestroCursosDisponibles);
                }
            }
            Scanner sc = new Scanner(System.in);
            int respuestaFechaSeleccionada = Integer.valueOf(sc.nextLine());

            Map<Integer, Maestro> MaestroCursoSeleccionado = maestros.get(respuestaFechaSeleccionada);
            Integer indexFecha = 0;
            Maestro maestroSeleccecionado = new Maestro("","");

            for (Map.Entry<Integer, Maestro> maes:MaestroCursoSeleccionado.entrySet()) {
                indexFecha = maes.getKey();
                maestroSeleccecionado = maes.getValue();
            }

            System.out.println(maestroSeleccecionado.getNombre() +
                    "\nFecha: " + maestroSeleccecionado.getCursosDisponibles().get(indexFecha).getFecha() +
                    "\nHora: " + maestroSeleccecionado.getCursosDisponibles().get(indexFecha).getHora());

            System.out.println("Confirmar curso: \n1.- Si\n2.-No");
            respuesta = Integer.valueOf(sc.nextLine());

            if (respuesta == 1){
                UIMenu.estudianteLogeado.addCitaMaestros(maestroSeleccecionado,
                        maestroSeleccecionado.getCursosDisponibles().get(indexFecha).getFecha(),
                        maestroSeleccecionado.getCursosDisponibles().get(indexFecha).getHora());
                mostrarMenuEstudiante();
            }
        }while (respuesta != 0);
    }

    private static void mostrarMisReservas(){
        int respuesta = 0;
        do {
            System.out.println("..::Mis cursos reservados::..");
            if (UIMenu.estudianteLogeado.getCitaMaestros().isEmpty()){
                System.out.println("No tienes citas agendadas");
                break;
            }

            int j = 0;
            for (int i = 0; i < UIMenu.estudianteLogeado.getCitaMaestros().size(); i++) {
                j++;
                System.out.println(j + ".-" +
                        "Fecha: " + UIMenu.estudianteLogeado.getCitaMaestros().get(i).getFecha() +
                        "Hora: " + UIMenu.estudianteLogeado.getCitaMaestros().get(i).getHora() +
                        "\nMaestro: " + UIMenu.estudianteLogeado.getCitaMaestros().get(i).getMaestro().getNombre());
            }
        }while (respuesta != 0);
    }
}
