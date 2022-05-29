import java.util.Scanner;

public class Main {

    static Persona participantes[];
    static Comida  postres[];
    public static void main(String[] args) {
       participantes = new Persona[5];
       postres = new Comida[5];
       AñadirParticipante();
       int opcion;
        Scanner teclado = new Scanner(System.in);
       do{
           System.out.println("**************************");
           System.out.println("        Consultar       ");
           System.out.println("**************************");
           System.out.println("1)Buscar por folio y nombre");
           System.out.println("2)Nombres de los postres participantes");
           System.out.println("3)visualizar ingredientes de un postre");
           System.out.println("4)Salir");
           opcion = teclado.nextInt();
           switch (opcion){
               case 1:
                   BuscarParticipante();
                   break;

               case 2:
                   MostrarPostres();
                   break;

               case 3:
                   MostrarIngrediente();
                   break;
           }
       }while(opcion != 4);
    }

    public static void AñadirParticipante(){
        Scanner teclado = new Scanner(System.in);
        String nombre;
        String lugar;
        String ingrediente;
        int folio;
        for(int i = 0; i < 5; i++){
            System.out.println("Añadir participante " + (i+1));
            System.out.println("ingrese el nombre");
            nombre = teclado.nextLine();
            System.out.println("ingresa el lugar");
            lugar = teclado.nextLine();
            folio = (int)(Math.random()*8998)+1000+1;
            Persona persona = new Persona(nombre,folio,lugar);
            participantes[i] = persona;
            System.out.println("Añadir comida");
            System.out.println("nombre de comida");
            nombre = teclado.nextLine();
            System.out.println("numero de ingredientes");
            folio = teclado.nextInt();
            String[] listaingrediente = new String[folio];

            for(int j = 0; j < listaingrediente.length; j++){
                System.out.println("ingresa los ingredientes");
                ingrediente = teclado.nextLine();
                listaingrediente[j] = ingrediente;
            }
            Comida postre = new Comida(nombre,listaingrediente);
            postres[i] = postre;
            ImprimirComprobante(i);
        }
    }
    public static void ImprimirComprobante(int posicion){
        System.out.println("************************");
        System.out.println("        folio");
        System.out.println("************************");
        System.out.println("nombre: " + participantes[posicion].getNombre());
        System.out.println("folio: " + participantes[posicion].getFolio());
        System.out.println("lugar: " + participantes[posicion].getLugar());
        System.out.println("Postre: " + postres[posicion].getNombre());
    }

    public static void BuscarParticipante(){
        String nombre;
        int folio;
        boolean bandera = true;
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el nombre del participante");
        nombre = entrada.nextLine();
        System.out.println("ingrese el numero de folio");
         folio = entrada.nextInt();
        for(int i =0; i < 5; i++){
            if(nombre.equals(participantes[i].getNombre()) && folio == participantes[i].getFolio()){
                System.out.println("Participante encontrado");
                System.out.println("************************************");
                System.out.println("          Informacion");
                System.out.println("************************************");
                System.out.println("nombre: " + participantes[i].getNombre());
                System.out.println("Folio: " + participantes[i].getFolio());
                System.out.println("lugar: " + participantes[i].getLugar());
                System.out.println("Postre: " + postres[i].getNombre());
                bandera = false;
            }

        }

        if(bandera){
            System.out.println("participante no encontrado");
        }
    }

    public static void MostrarPostres(){
        for(int i = 0; i < 5; i++){
            System.out.println("******************************************************");
            System.out.println("Participante: " + participantes[i].getNombre());
            System.out.println("Postre participante: " + postres[i].getNombre());
            System.out.println("******************************************************");
        }
    }

    public static void MostrarIngrediente(){
        Scanner teclado = new Scanner(System.in);
        String nombre;
        nombre = teclado.nextLine();
        for(int i = 0; i < 5; i++){
            if(postres[i].getNombre().equals(nombre)){
                System.out.println("ingredientes de :" + postres[i].getNombre());
                for (String nombre2: postres[i].getIngredientes()) {
                    System.out.println("-" + nombre2);
                }
            }
        }
    }
}