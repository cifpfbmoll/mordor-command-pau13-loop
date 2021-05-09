package edu.pingpong.mordorcommand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

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
 * NO PUEDES MODIFICAR EL CODIGO DE LOS CASOS TEST
 */
public class TestPedidos {

    /**
     * Crea una clase TratamientoPedidoInternacional que permita tratar pedidos
     * internacionales.
     * 
     * La clase permite tratar todos los pedidos excepto los que van a Mordor.
     * 
     * Crea las clases necesarias que se requieren en los casos test respetando los
     * constructores que se exigen.
     */
    @Test
    public void test_Mordor() {

        Order orderInt = new InternationalOrder("Mordor", 100);
        assertEquals("Mordor", orderInt.destination());

        OrderTreatment treatmentKO = new InternationalOrderTreatment((InternationalOrder) orderInt);
        assertNotNull(treatmentKO);
        assertFalse(treatmentKO.treat());
    }

    @Test
    public void test_Comarca() {

        Order orderInt = new InternationalOrder("Comarca", 100);
        assertEquals("Comarca", orderInt.destination());

        OrderTreatment tratamientoOK = new InternationalOrderTreatment((InternationalOrder) orderInt);
        assertNotNull(tratamientoOK);
        assertTrue(tratamientoOK.treat());
    }

    // /**
    // * Crea una clase TratamientoPedidoPeligroso que permita tratar
    // * pedidos peligrosos.
    // *
    // * La clase permite tratar todos los pedidos segun sus
    // * instrucciones excepto aquellos cuya instruccion sea
    // * "No ponerselo en el dedo".
    // *
    // * Crea las clases necesarias que se requieren en los casos test
    // * respetando los constructores que se exigen.
    // */

    @Test
    public void test_pedido_peligroso_KO() {

        Order dangerousOrder = new DangeorusOrderOrder("Monte del destino", "No ponerselo en el dedo");
        assertEquals("Monte del destino", dangerousOrder.destination());

        OrderTreatment treatmentOK = new DangerousOrderTreatment((DangeorusOrderOrder) dangerousOrder);
        assertNotNull(treatmentOK);
        assertFalse(treatmentOK.treat());
    }

    @Test
    public void test_pedido_peligroso_OK() {

        Order dangerousOrder = new DangeorusOrderOrder("Cima de los vientos", "No urgarse en las uñas con este puñal");
        assertEquals("Cima de los vientos", dangerousOrder.destination());

        OrderTreatment treatmentOK = new DangerousOrderTreatment((DangeorusOrderOrder) dangerousOrder);
        assertTrue(treatmentOK.treat());
    }

    // /**
    // * Añade a las clases PedidoInternacional y PedidoPeligrosoOrden
    // * una identificador Id de tipo String
    // * autogenerado haciendo uso de la clase UUID de Java
    // * https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
    // */

    @Test
    public void test_UUID_generator() {

        InternationalOrder international = new InternationalOrder("Mordor", 10);
        DangeorusOrderOrder dangeorous = new DangeorusOrderOrder("Cima de los vientos",
                "No urgarse en las uñas con este puñal");
        assertNotNull(international.getId());
        assertNotNull(dangeorous.getId());

        assertNotEquals(international.getId(), dangeorous.getId());
    }

    // /**
    // * Añade una clase para los pedidos nacionales.
    // */

    @Test
    public void test_pedido_nacional_UUDI() {

    InternationalOrder international = new InternationalOrder("Mordor", 10);
    assertNotNull(international);
    NationalOrder national = new NationalOrder("Gondor", 50);
    assertNotNull(national);
    assertNotEquals(international.getId(), national.getId());
    }

    // /**
    // * Construye una oficina que procese todo tipo de pedidos.
    // *
    // * La oficina procesa los pedidos en funcion de si
    // * es posible tratarlos o no segun las reglas de cada
    // * tipo de pedido
    // */

    @Test
    public void test_interface_procesador() {

    Processor post = new Office();
    OrderTreatment orderInt = new InternationalOrderTreatment(
    new InternationalOrder("Comarca", 100));
    assertTrue(post.process(orderInt));

    OrderTreatment dangeorusOrder = new DangerousOrderTreatment(
    new DangeorusOrderOrder("Cima de los vientos",
    "No urgarse en las uñas con este puñal"));
    assertTrue(post.process(dangeorusOrder));
    }

    // /**
    // * La oficina puede enviar un mensaje que informe del
    // * status del pedido, en funcion de si ha sido posible procesarlo.
    // *
    // * Hace uso de un tipo enumerado STATUS con las constantes
    // * ACEPTADO y RECHAZADO.
    // */

    @Test
    public void test_printar_status() {

    Office post = new Office();
    InternationalOrder toComarcaWithLove = new InternationalOrder("Comarca",
    100);
    OrderTreatment onrderInt = new
    InternationalOrderTreatment(toComarcaWithLove);

    assertTrue(post.process(onrderInt));
    assertEquals("Comarca ACCEPTED", post.printStatus(
    post.process(onrderInt), toComarcaWithLove));

    DangerousOrder dangerousOrder = new DangeorusOrderOrder("Monte del destino",
    "No ponerselo en el dedo");
    OrderTreatment treatmentOK = new
    DangerousOrderTreatment(dangerousOrder);

    assertFalse(post.process(treatmentOK));
    assertEquals("Monte del destino REJECTED", post.printStatus(
    post.process(treatmentOK),
    dangerousOrder));
    }

    // /**
    // * Crea una clase TratamientoPedidoMultiple que permita tratar
    // * pedidos multiples.
    // *
    // * La clase permite tratar el pedido multiple si
    // * el peso total de los pedidos es mayor que 0
    // * y
    // * el numero de bultos coincide con el numero de
    // * pedidos individuales que forman el pedido multiple.
    // *
    // * Crea las clases necesarias que se requieren en los casos test
    // * respetando los constructores que se exigen.
    // */

    @Test
    public void test_tratamiento_pedido_multiple_tratar() {

    /**
    * Crea una colección de tres pedidos nacionales, a "Gondor", "Minas Tirith",
    "Rohan"
    * con un peso de 10 cada uno.
    *
    * Pasasela a TratamientoPedidosMultiple en su constructor.
    */

    Set<Order> orders = new HashSet<>();
    List<String> destinations = Arrays.asList("Gondor", "Minas Tirith", "Rohan");
    List<Integer> weights = Arrays.asList(10, 10, 10);

    for (int i=0; i<destinations.size(); i++) {
    orders.add(new NationalOrder(destinations.get(i), weights.get(i)));
    }
    assertEquals(3, orders.size());

    MultipleOrderTreatment multOrders = new MultipleOrderTreatment(orders);
    assertNotNull(multOrders);

    /**
    * Completa los metodos del pedido multiple.
    * Se valorara el uso de streams.
    *
    * calcularTotalBultos
    * @param void
    * @return void
    *
    * calcularPesoTotal
    * @param void
    * @return void
    *
    */

    multOrders.setTotalParcels();
    assertEquals(3, multOrders.getNumParcels(), 0);

    multOrders.setTotalWeight();
    assertEquals(30, multOrders.getTotalWeight(), 0);

    // /**
    // * Trata el pedido multiple.
    // */
    assertTrue(multOrders.treat());
    }
}