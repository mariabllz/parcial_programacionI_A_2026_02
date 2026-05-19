import java.util.Scanner;
public class parcial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidadEspacios ;
        int cantidadVehiculos ;

        int carrosAsignados = 0 ;
        int motosAsignadas = 0 ;
        int rechazos = 0 ;
        int disponibles = 0 ;

        boolean asignado ;

        System.out.println("Ingrese la cantidad de espacios del parqueadero");
         cantidadEspacios = sc.nextInt() ;

         int[] númeroEspacio = new int[cantidadEspacios] ;
        String[] tipoEspacio = new String[cantidadEspacios] ;
        String[] estadoEspacio = new String[cantidadEspacios] ;

        for (int i = 0; i < cantidadEspacios; i++) {
            System.out.println("Espacio " + (i+1));

            System.out.println("Número del espacio: ");
            númeroEspacio[i] = sc.nextInt() ;

            System.out.println("Tipo permitido (carro/moto): ");
            tipoEspacio[i] =  sc.next() ;

            estadoEspacio[i] = "disponible" ;
        }

        System.out.println("Cantidad de vehículos que se desean ingresar");
        cantidadVehiculos = sc.nextInt() ;

        for (int i = 0; i < cantidadVehiculos; i++) {
            System.out.println("Vehículo " + (i+1));

            System.out.println("Placa");
            String placa = sc.next();

            System.out.println("Tipo de vehículo (carro/moto)");
            String tipoVehículo = sc.next() ;
            
            sc.nextLine() ;

            System.out.println("Nombre del propietario");
            String propietario = sc.nextLine() ;

            asignado = false ;

            for (int j = 0; j < cantidadEspacios; j++) {
                if (tipoEspacio[j].equalsIgnoreCase(tipoVehículo) 
                    && estadoEspacio[j].equalsIgnoreCase("disponible")){

                    estadoEspacio[j] = "ocupado" ;

                    System.out.println("Vehículo asignado al espacio: " + númeroEspacio[j]);

                    asignado = true ;

                    if (tipoVehículo.equalsIgnoreCase("carro")){
                        carrosAsignados++ ;
                    } else {
                        motosAsignadas++ ;
                    }
                    
                    break ;

                }
            }

            if (!asignado) {
                System.out.println("No se puede asignar espacio.");
                rechazos++ ;
            }

        }

        System.out.println("Estado final del parqueadero");

        for (int i = 0; i < cantidadEspacios; i++) {
            System.out.println("Espacio: " + númeroEspacio[i] 
            + " Tipo: " + tipoEspacio[i] 
            + " Estado: " + estadoEspacio[i]);

            if (estadoEspacio[i].equalsIgnoreCase("disponible")){
                disponibles++ ;
            }
        }

        System.out.println("RESULTADOS");
        System.out.println("Espacios disponibles: " + disponibles);
        System.out.println("Carros asignados correctamente: " + carrosAsignados);
        System.out.println("Motos asignadas correctamente: " + motosAsignadas);
        System.out.println("Vehículos que no se pudieron asignar: " + rechazos);

        sc.close();


    }
}
