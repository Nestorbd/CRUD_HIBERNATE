package Controlador;


import Modelo.PiezasEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    private PiezasEntity piezas;
    private int opcion;
    private Scanner scanner;
    private Session session;


    public Controlador(Session session){
        this.session = session;
        this.scanner = new Scanner(System.in);
        this.opcion = 0;

        menu(opcion);
    }

    public void crearPieza() {
        this.piezas = new PiezasEntity();
        System.out.println("Tipo:");
        scanner.nextLine();
        this.piezas.setTipo(scanner.nextLine());

        System.out.println("Modelo:");
        this.piezas.setModelo(scanner.nextInt());

        System.out.println("Precio:");
        this.piezas.setPrecio(scanner.nextDouble());

        System.out.println("Cantidad:");
        scanner.nextLine();
        this.piezas.setCantidad(scanner.nextLine());

        System.out.println("Descripción:");
        this.piezas.setDescripcion(scanner.nextLine());


        System.out.println(this.piezas);

        session.getTransaction().begin();
        session.persist(this.piezas);
        session.getTransaction().commit();

        System.out.println("Pieza registrada \n");


    }

    public void buscarPieza() {
        this.piezas = new PiezasEntity();
        System.out.println("Tipo:");
        scanner.nextLine();
        String tipoPieza = scanner.nextLine();
        System.out.println("Modelo:");
        String modeloPieza = scanner.nextLine();

        Query query =session.createQuery("Select p FROM PiezasEntity p where p.tipo = '"+tipoPieza+
                "' and p.modelo='"+modeloPieza+"'");
        List<PiezasEntity> listPiezas = query.list();
        int contador = -1;
        for(PiezasEntity piezas: listPiezas){
            System.out.println("Tipo: "+piezas.getTipo());
            System.out.println("Modelo: "+piezas.getModelo());
            System.out.println("Cantidad: "+piezas.getCantidad());
            System.out.println("Precio: "+piezas.getPrecio());
            System.out.println("Descripcion: "+piezas.getDescripcion());
            contador++;
        }
        if (contador==-1)
            System.out.println("Pieza no encontrada \n");
    }

    public void actualizarPieza() {
        this.piezas = new PiezasEntity();
        System.out.println("Tipo:");
        scanner.nextLine();
        String tipoPieza = scanner.nextLine();
        System.out.println("Modelo:");
        int modeloPieza = scanner.nextInt();

        Query query =session.createQuery("Select p FROM PiezasEntity p where p.tipo = '"+tipoPieza+
                "' and p.modelo='"+modeloPieza+"'");
        List<PiezasEntity> listPiezas = query.list();
        int contador = -1;
        for(PiezasEntity piezas: listPiezas){
            this.piezas.setTipo(piezas.getTipo());
            this.piezas.setModelo(piezas.getModelo());
            contador++;
        }
        if(contador!=-1){

            System.out.println("Precio:");
            double precioPieza = scanner.nextDouble();
            this.piezas.setPrecio(precioPieza);

            System.out.println("Cantidad:");
            scanner.nextLine();
            String cantidadPieza = scanner.nextLine();
            this.piezas.setCantidad(cantidadPieza);

            System.out.println("Descripción:");
            String descripPieza = scanner.nextLine();
            this.piezas.setDescripcion(descripPieza);

            session.getTransaction().begin();
            session.merge(this.piezas);
            session.getTransaction().commit();
            System.out.println("Pieza actualizada \n");
        }else
            System.out.println("Pieza no encontrada \n");
    }

    public void borrarPieza() {
        this.piezas = new PiezasEntity();
        System.out.println("Tipo:");
        scanner.nextLine();
        String tipoPieza = scanner.nextLine();
        System.out.println("Modelo:");
        int modeloPieza = scanner.nextInt();

        int contador = -1;
        Query query = session.createQuery("Select p FROM PiezasEntity p where p.tipo = '" + tipoPieza +
                "' and p.modelo='" + modeloPieza + "'");
        List<PiezasEntity> listPiezas = query.list();
        for (PiezasEntity piezas : listPiezas) {
            session.getTransaction().begin();
            session.delete(piezas);
            session.getTransaction().commit();
            System.out.println("Pieza eliminada \n");
            contador++;
        }

        if (contador == -1)
            System.out.println("Pieza no encontrada \n");

    }
    public void menu(int opcion) {
        while (opcion!=5) {
            System.out.println("1. Crear Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.println("Elija una opción:");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearPieza();
                    break;

                case 2:
                    buscarPieza();
                    break;
                case 3:
                    actualizarPieza();
                    break;
                case 4:
                    borrarPieza();
                    break;
                case 5:
                    session.close();

                    break;

                default:
                    System.out.println("Opción no válida\n");
                    break;
            }
        }
    }

}