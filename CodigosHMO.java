import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CodigosHMO {

    public static void main(String[] args) {

        HashMap<String, Integer> codigos = new HashMap<>();
        String archivo = "codigos_postales_hmo.csv";
        String linea;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            // Leer la primera linea y descartarla (encabezado)
            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String codigoPostal = datos[0];

                if (codigos.containsKey(codigoPostal)) {
                    codigos.put(codigoPostal, codigos.get(codigoPostal) + 1);
                } else {
                    codigos.put(codigoPostal, 1);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al lee+r el archivo");
        }

        System.out.println("Asentamientos por codigo postal:\n");

        for (String codigo : codigos.keySet()) {
            System.out.println(
                "Codigo Postal: " + codigo +
                " -> Total de asentamientos: " + codigos.get(codigo)
            );
        }
    }
}
