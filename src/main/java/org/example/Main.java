package org.example;

import org.example.dao.EstudianteDAO;
import org.example.dao.EstudianteDAOImpl;
import org.example.model.Estudiante;

import org.example.dao.CursoDAO;
import org.example.dao.CursoDAOImpl;
import org.example.model.Curso;

import org.example.dao.InscripcionDAO;
import org.example.dao.InscripcionDAOImpl;
import org.example.model.Inscripcion;


import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        menu();

    }


    public static void menu(){Scanner scanner = new Scanner(System.in);
        int opcion=9;

        while (opcion !=0){
            System.out.println("\nMenu:");
            System.out.println("1. Ingresar a Tabla Estudiante");
            System.out.println("2. Ingresar a Tabla Curso");
            System.out.println("3. Ingresar a Tabla Inscripcion");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    menu_estudiante();
                    break;
                case 2:
                    menu_curso();
                    break;
                case 3:
                    menu_inscripcion();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }



    public static void menu_estudiante(){
        try (Connection connection = ConexionBD.obtenerConexion()) {
            EstudianteDAO EstudianteDAO = new EstudianteDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Registrar Estudiante");
                System.out.println("2. Leer Estudiante");
                System.out.println("3. Eliminar Estudiante");
                System.out.println("4. Listar Estudiantes");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpia el buffer


                switch (opcion) {
                    case 1: // Registrar
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();

                        Estudiante estudiante = new Estudiante(0,nombre, correo);
                        EstudianteDAO.crear(estudiante);
                        System.out.println("Estudiante registrado.");
                        break;

                    case 2: // Leer
                        System.out.print("Ingrese el Id del Estudiante: ");
                        int idLeer = scanner.nextInt();
                        scanner.nextLine(); // limpia el buffer

                        Estudiante est = EstudianteDAO.leer(idLeer);
                        if (est != null) {
                            System.out.println(est);
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                        break;

                    case 3: // Eliminar
                        System.out.print("Id del Estudiante a eliminar, si esta inscrito a algun curso elimine primero las inscripciones: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine(); // limpia el buffer

                        EstudianteDAO.eliminar(idEliminar);
                        System.out.println("Estudiante eliminado.");
                        break;

                    case 4: // Listar
                        List<Estudiante> listaEstudiante = EstudianteDAO.listar();
                        for (Estudiante e : listaEstudiante) {
                            System.out.println(e);
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static void menu_curso(){
        try (Connection connection = ConexionBD.obtenerConexion()) {
            CursoDAO CursoDAO = new CursoDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Registrar Curso");
                System.out.println("2. Leer Curso");
                System.out.println("3. Eliminar Curso");
                System.out.println("4. Listar Cursos");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpia el buffer


                switch (opcion) {
                    case 1: // Registrar
                        System.out.print("Id de la clase: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Nombre de la clase: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Nombre del profesor: ");
                        String profesor = scanner.nextLine();


                        Curso curso = new Curso(id, nombre, profesor);
                        CursoDAO.crear(curso);
                        System.out.println("Curso registrado.");
                        break;

                    case 2: // Leer
                        System.out.print("Ingrese el Id del Curso: ");
                        int idLeer = scanner.nextInt();
                        Curso cur = CursoDAO.leer(idLeer);
                        if (cur != null) {
                            System.out.println(cur);
                        } else {
                            System.out.println("Curso no encontrado.");
                        }
                        break;

                    case 3: // Eliminar
                        System.out.print("Id del curso a eliminar, si algun estudiante ya se inscribio, elimine primero la inscripcion: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine(); // limpia el buffer

                        CursoDAO.eliminar(idEliminar);
                        System.out.println("Curso eliminado.");
                        break;

                    case 4: // Listar
                        List<Curso> listaCurso = CursoDAO.listar();
                        for (Curso c : listaCurso) {
                            System.out.println(c);
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void menu_inscripcion(){
        try (Connection connection = ConexionBD.obtenerConexion()) {
            InscripcionDAO InscripcionDAO = new InscripcionDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Inscribir Estudiante");
                System.out.println("2. Leer Inscripcion");
                System.out.println("3. Eliminar Inscripcion");
                System.out.println("4. Listar Inscripciones");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpia el buffer


                switch (opcion) {
                    case 1: // Registrar
                        System.out.print("Id del estudiante a inscribir: ");
                        int idestudiante = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Id del curso al que se deseea inscribir: ");
                        int idcurso = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Fecha de registro formato DD/MM/YYYY: ");
                        String fecha = scanner.nextLine();


                        Inscripcion inscripcion = new Inscripcion(0,idestudiante, idcurso , fecha);
                        InscripcionDAO.crear(inscripcion);
                        System.out.println("Inscripcion realizada.");
                        break;

                    case 2: // Leer
                        System.out.print("Ingrese el Id de la Inscripcion: ");
                        int idLeer = scanner.nextInt();
                        scanner.nextLine(); // limpia el buffer

                        Inscripcion ins = InscripcionDAO.leer(idLeer);
                        if (ins != null) {
                            System.out.println(ins);
                        } else {
                            System.out.println("Inscripcion no encontrada.");
                        }
                        break;

                    case 3: // Eliminar
                        System.out.print("Id de la inscripcion a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine(); // limpia el buffer

                        InscripcionDAO.eliminar(idEliminar);
                        System.out.println("Inscripcion eliminada.");
                        break;

                    case 4: // Listar
                        List<Inscripcion> inscripciones = InscripcionDAO.listar();
                        for (Inscripcion i : inscripciones) {
                            System.out.println(i);
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}