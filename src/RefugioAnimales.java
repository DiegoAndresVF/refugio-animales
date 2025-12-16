import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class RefugioAnimales {
    static List<String> animales = new ArrayList<>();
    ;   //nombre de la mascota
    static Map<String, String> estadoAnimal = new HashMap<>();
    static Set<String> especies = new HashSet<>(List.of("perro", "gato", "conejo"));
    static Map<String, String> animalEspecie = new HashMap<>();
    ;
    static String[] estados = {"Disponible", "Adoptado"};
    static Scanner sc = new Scanner(System.in);
    static Set<String> animalesUnicos = new HashSet<>();

    static void menu() {
        System.out.println("=== REFUGIO DE ANIMALES ===");
        System.out.println("1. Registrar animal");
        System.out.println("2. Registrar especie");
        System.out.println("3. Marcar animal como adoptado");
        System.out.println("4. Mostrar animales dispoibles");
        System.out.println("5. Mostrar animales adoptados");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir");
    }


    public static void registrarAnimal() {
        System.out.print("Ingrese el nombre del animal:");
        String nombre = sc.next();
        if (animalesUnicos.add(nombre)) {
            animales.add(nombre); // solo si es nuevo
        } else {
            System.out.println("⚠️ Animal duplicado");
        }
        System.out.print("Ingrese la especie:");
        String especie = sc.next().toLowerCase();
        //especie.toLowerCase();
        boolean existeEspecie = especies.contains(especie);
        if (existeEspecie) {
            animalEspecie.put(nombre, especie);
            estadoAnimal.put(nombre, estados[0]);
        } else {
            System.out.println("> Especie de animal no permitida!");
        }

    }

    public static void registrarEspecie() {
        System.out.print("Ingrese la especie a registrar: ");
        String nombreEspecie = sc.next().toLowerCase();
        especies.add(nombreEspecie);
    }

    static void adoptarAnimal() {
        for (Map.Entry<String, String> animal : animalEspecie.entrySet()) {
            System.out.println(animal.getKey() + " → " + animal.getValue());
        }
        System.out.print("Ingrese animal a adoptar: ");
        String nombreA = sc.next();
        for (Map.Entry<String, String> estado : estadoAnimal.entrySet()) {
            if (estado.getKey().equals(nombreA)) {
                estado.setValue(estados[1]);
            }
        }
        for (Map.Entry<String, String> estado : estadoAnimal.entrySet()) {
            System.out.println(estado.getKey() + " → " + estado.getValue());
        }
    }

    static void mostrarDispoibles() {
        estadoAnimal.entrySet().stream()
                .filter(estadoA -> estadoA.getValue().equals("Disponible"))
                .forEach((System.out::println));
    }

    static void mostrarAdoptados() {
        estadoAnimal.entrySet().stream()
                .filter(estadoA -> estadoA.getValue().equals("Adoptado"))
                .forEach((System.out::println));
    }

    static void reporteGeneral() {
        int total_animales = animales.size();
        long total_disponibles = estadoAnimal.entrySet().stream()
                .filter(estadoA -> estadoA.getValue().equals("Disponible"))
                .count();
        long total_adoptados = estadoAnimal.entrySet().stream()
                .filter(estadoA -> estadoA.getValue().equals("Adoptado"))
                .count();
        System.out.println("Total de animales: " + total_animales);
        System.out.println("Total disponibles: " + total_disponibles);
        System.out.println("Total adoptados: " + total_adoptados);

        //tabla
        System.out.printf("--------------------------------------%n");
        System.out.printf("           Reporte general       %n");
        System.out.printf("--------------------------------------%n");
        System.out.printf("| %-10s | %-8s | %-10s |%n", "Nombre", "Especie", "Estado");
        System.out.printf("--------------------------------------%n");
        /*for (Map.Entry<String, String> entrada : animalEspecie.entrySet()) {
            System.out.printf("| %-10s | %-8s | %-8s |%n", entrada.getKey(), entrada.getValue(), "estado");
            System.out.printf("-----------------------------------%n");
        }*/
        for (String nombre : animalEspecie.keySet()) {
            String especie = animalEspecie.get(nombre);
            String estado = estadoAnimal.get(nombre);

            System.out.printf("| %-10s | %-8s | %-10s |%n", nombre, especie, estado);
            System.out.printf("--------------------------------------%n");
        }

    }

    public static void main(String[] args) {
        int op = 0;

        do {
            menu();
            System.out.print("Ingrese opción: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> registrarAnimal();
                case 2 -> registrarEspecie();
                case 3 -> adoptarAnimal();
                case 4 -> mostrarDispoibles();
                case 5 -> mostrarAdoptados();
                case 6 -> reporteGeneral();
                case 7 -> System.out.println("*** Programa Finalizado ***");
                default -> System.out.println("No es una opción válida");
            }
        } while (op != 7);
    }
}