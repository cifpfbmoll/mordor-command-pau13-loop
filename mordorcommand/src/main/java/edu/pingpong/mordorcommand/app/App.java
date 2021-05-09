package edu.pingpong.mordorcommand.app;

import edu.pingpong.mordorcommand.domain.interfaces.DangerousOrder;
import edu.pingpong.mordorcommand.domain.interfaces.Order;
import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.domain.interfaces.Processor;
import edu.pingpong.mordorcommand.domain.orders.DangeorusOrderOrder;
import edu.pingpong.mordorcommand.domain.orders.InternationalOrder;
import edu.pingpong.mordorcommand.domain.orders.NationalOrder;
import edu.pingpong.mordorcommand.domain.processors.Office;
import edu.pingpong.mordorcommand.domain.treatments.DangerousOrderTreatment;
import edu.pingpong.mordorcommand.domain.treatments.InternationalOrderTreatment;
import edu.pingpong.mordorcommand.domain.treatments.MultipleOrderTreatment;

/**
 * Crea una office que procesa pedidos.
 * 
 * En funcion de si el tratamiento del order es posible o no
 * la office procesa el order (true /false) 
 * e informa de su estado (aceptado /rechazado).
 * 
 * Como los pedidos pueden ser de multiples tipos, 
 * muchos de ellos aun desconocidos y cada uno 
 * con sus particularidades propias,
 * vamos a usar el patron COMMAND.
 * 
 * Consulta el manual de referencia para ver un ejemplo del patron.
 * 
 * Aplicando el patron COMMAND no procesaremos pedidos,
 * sino que le pasaremos a la office /procesador
 * el tipo de tratamiento que ha de aplicar a cada order,
 * y sera el propio order el que decida como debe ser tratado.
 * 
 * PASA LOS CASOS TEST PROPUESTOS y utilizalos como guia para el desarrollo.
 * NO PUEDES MODIFICAR EL CODIGO DE LOS CASOS TEST 
 * 
 * La clase App.java contiene el MAIN y ha de funcionar.
 * NO PUEDES MODIFICAR EL CODIGO DEL MAIN
 * 
 * Crea un proyecto MAVEN siguiendo el esquema: org.mvpigs.commandpattern
 * Respeta la estructura del proyecto indicada 
 * en el nombre de los paquetes que se indican en los casos test. 
 * 
 * - Realiza commits periódicamente mientras avanzas en el desarrollo de la aplicación.
 * - Publica tu solucion en GitHub.
 * - Enviame tu proyecto comprimido en un ZIP a gelpiorama@gmail.com
 * 
 * No olvides dibujar a mano alzada el DIAGRAMA DE CLASES UML de tu solucion
 * para completar la evaluacion de la parte practica de ED. 
 */

public class App {

    public static void main(String[] args) {

        Office office = new Office();

        Order order = new InternationalOrder("Comarca", 10);
        OrderTreatment treatmentOrd = new InternationalOrderTreatment(
                                                    (InternationalOrder) order);
        
        System.out.println(office.printStatus(office.process(treatmentOrd), order));

        order = new InternationalOrder("Mordor", 10);
        treatmentOrd = new InternationalOrderTreatment((InternationalOrder) order);
        
        System.out.println(office.printStatus(office.process(treatmentOrd), order));

        order = new DangeorusOrderOrder("Cima de los vientos", 
                                          "No urgarse en las uñas con este puñal");
        OrderTreatment peligroso = new DangerousOrderTreatment((DangeorusOrderOrder) order);
        
        System.out.println(office.printStatus(office.process(peligroso), order));

        order = new DangeorusOrderOrder("Monte del destino", 
                                          "No ponerselo en el dedo");
        peligroso = new DangerousOrderTreatment((DangeorusOrderOrder) order);
        
        System.out.println(office.printStatus(office.process(peligroso), order));
        
        /**
         * Los pedidos multiples se completan en el ultimo de los casos test 
         */
    }
}
