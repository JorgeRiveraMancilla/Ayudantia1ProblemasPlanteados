import ucn.StdIn;
import ucn.StdOut;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        primerProblemaPlanteado();
        StdOut.println("--------------------");
        segundoProblemaPlanteado();
        StdOut.println("--------------------");
        tercerProblemaPlanteado();
    }

    /**
     * Método asociado al primer problema planteado de la ayudantía 1.
     */
    public static void primerProblemaPlanteado() {
        // Obtención del mes
        int mes;

        do {
            StdOut.print("Ingrese el mes: ");
            mes = StdIn.readInt();

        } while (1 > mes || mes > 12);

        // Obtención del año
        int anio;

        do {
            StdOut.print("Ingrese el año: ");
            anio = StdIn.readInt();

        } while (1900 > anio || anio > 3000);

        // Obtención del primer día del mes y año seleccionado
        LocalDate fecha = obtenerFecha(mes, anio);
        int mesSiguiente = fecha.plusMonths(1).getMonth().getValue();

        // Despliegue del nombre del mes y año
        String nombreMes = obtenerNombreMes(mes);
        StdOut.println(nombreMes + " " + anio);
        StdOut.println("Lu Ma Mi Ju Vi Sa Do");

        // Ciclo para cada semana del mes
        while (true) {
            int diaSemana = fecha.getDayOfWeek().getValue() - 1;

            for (int i = 0; i < diaSemana ; i++) {
                StdOut.print("   ");
            }

            for (int i = diaSemana; i < 7; i++) {
                int diaMes = fecha.getDayOfMonth();

                StdOut.print(diaMes + " ");

                if (diaMes < 10) {
                    StdOut.print(" ");
                }

                fecha = fecha.plusDays(1);

                if (fecha.getMonth().getValue() == mesSiguiente) {
                    StdOut.println("");
                    return;
                }
            }

            StdOut.println();
        }
    }

    /**
     * Obtiene la fecha del primer dia del mes y año seleccionado.
     * @param mes Mes seleccionado.
     * @param anio Año seleccionado.
     * @return Fecha del mes y año seleccionado.
     */
    public static LocalDate obtenerFecha(int mes, int anio) {
        String mesStr;
        if (mes < 10) {
            mesStr = "0" + mes;
        } else {
            mesStr = Integer.toString(mes);
        }

        return LocalDate.parse(anio + "-" + mesStr + "-01", DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Obtiene el nombre del mes ingresado.
     * @param mes Mes a evaluar.
     * @return Enero si el mes es 1, Febrero si es mes es 2, ... y Diciembre si es mes es 12.
     */
    public static String obtenerNombreMes(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
                "Octubre", "Noviembre",  "Diciembre"};

        return meses[mes - 1];
    }

    /**
     * Método asociado al segundo problema planteado de la ayudantía 2.
     */
    public static void segundoProblemaPlanteado() {
        StdOut.print("Ingrese un número entero positivo mayor que 2: ");
        int numero = StdIn.readInt();

        for (int i = 2; i < numero / 2; i++) {
            if (esPrimo(i)) {
                if (esPrimo(numero - i)) {
                    StdOut.println(numero + " = " + i + " + " + (numero - i));
                    break;
                }
            }
        }
    }

    /**
     * Comprueba si un número es primo.
     * @param numero Número a evaluar.
     * @return True si es primo, False en caso contrario.
     */
    public static boolean esPrimo(int numero) {
        boolean esPrimo = true;
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                esPrimo = false;
                break;
            }
        }

        return esPrimo;
    }

    /**
     * Método asociado al tercer problema planteado de la ayudantía 3.
     */
    public static void tercerProblemaPlanteado() {
        long suma = 0;

        for (int i = 0; i < 1000000; i++) {
            if (esPalindromo(Integer.toString(i)) && esPalindromo(Integer.toBinaryString(i))) {
                StdOut.println(i + " y " + Integer.toBinaryString(i) + " son palíndromos");
                suma += i;
            }
        }

        StdOut.print("La suma es: " + suma);
    }

    /**
     * Comprueba si una cadena es palíndromo.
     * @param str Cadena a evaluar.
     * @return True si es palíndromo, False en caso contrario.
     */
    public static boolean esPalindromo(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}