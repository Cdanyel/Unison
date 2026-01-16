import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CodigosHMO {

    public static void main(String[] args) {
 
        //Implementacion de HashMap, lectura de archivo y Linea de separación
        HashMap<String, Integer> codigos = new HashMap<>();
        String archivo = "codigos_postales_hmo.csv";
        String linea;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            // Leer la primera linea y descartarla (encabezado)
            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(","); // --Serapacion de datos por ´,´

                String codigoPostal = datos[0]; // Lectura de primer dato del documento

                if (codigos.containsKey(codigoPostal)) {
                    codigos.put(codigoPostal, codigos.get(codigoPostal) + 1); // Codigo postal iguales sumar en los asentamientos
                } else {
                    codigos.put(codigoPostal, 1);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al lee+r el archivo"); // Error al leer el archivo
        }

        System.out.println("Asentamientos por codigo postal:\n");

        for (String codigo : codigos.keySet()) {
            System.out.println(
                "Codigo Postal: " + codigo +                             //imprimimos resultado establecido en el documento de la tarea.
                " -> Total de asentamientos: " + codigos.get(codigo)
            );
        }
    }
}
