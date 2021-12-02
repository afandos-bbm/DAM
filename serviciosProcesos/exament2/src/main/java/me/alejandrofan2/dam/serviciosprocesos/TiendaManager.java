package me.alejandrofan2.dam.serviciosprocesos;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TiendaManager {

    private Logger log = LoggerFactory.getLogger("Tienda");
    private Random random = new Random();

    private Semaphore semPPendientes = new Semaphore(1);
    private Semaphore semPPreparados = new Semaphore(1);
    private Semaphore waiterPPendientes = new Semaphore(0);
    private Semaphore waiterPPreparados = new Semaphore(0);

    private ArrayList<String> pedidosPendientes = new ArrayList<String>();
    private ArrayList<String> pedidosPreparados = new ArrayList<String>();

    private int nPedidos = 0;

    void pedir(String nombreCliente) {
        try {
            log.info(format("[%s] Ha entrado a la tienda.", nombreCliente));
            Thread.sleep((random.nextInt(120) + 1) * 1000L);
            semPPendientes.acquire();

            pedidosPendientes.add(nombreCliente);
            log.info(format("[%s] Nuevo pedido - Pedidios pendientes %d", nombreCliente, pedidosPendientes.size()));

            waiterPPendientes.release();
            semPPendientes.release();
        } catch (InterruptedException e) {
            log.error(format(
                    "[%s] Ha habido un error durante la ejecucion de el codigo del ClienteT en el manager. Error: %s",
                    nombreCliente, e.getLocalizedMessage()));
        }
    }

    void trabajar(String nombreTrabajador) {
        try {
            log.info(format("[%s] Esperando nuevo pedido...", nombreTrabajador));
            waiterPPendientes.acquire();
            semPPendientes.acquire();

            nPedidos++;
            String nombreCliente = pedidosPendientes.get(0);
            pedidosPendientes.remove(0);
            log.info(format("[%s] Ha iniciado un nuevo pedido de %s", nombreTrabajador, nombreCliente));

            Thread.sleep((random.nextInt(5) + 1) * 1000L);

            semPPendientes.release();
            semPPreparados.acquire();

            log.info(format("[%s] Ha finalizado el pedido nº%d de %s. Listando para envio", nombreTrabajador, nPedidos,
                    nombreCliente));
            pedidosPreparados.add(nombreCliente);

            waiterPPreparados.release();
            semPPreparados.release();

        } catch (InterruptedException e) {
            log.error(format(
                    "[%s] Ha habido un error durante la ejecucion de el codigo del trabajadorT en el manager. Error: %s",
                    nombreTrabajador, e.getLocalizedMessage()));
        }
    }

    void repartir(String nombreRepartidor) {
        log.info(format("[%s] Esperando pedidos pendientes de envio...", nombreRepartidor));
        try {

            waiterPPreparados.acquire();
            semPPreparados.acquire();

            String nombreCliente = pedidosPreparados.get(0);
            pedidosPreparados.remove(0);
            log.info(format("[%s] El pedido nº%d de %s esta en ruta.", nombreRepartidor, nPedidos, nombreCliente));

            semPPreparados.release();

            Thread.sleep((((random.nextInt(5) + 1) + 10) * 1000L));
            log.info(format("[%s] Pedido nº%d de %s entregado correctamente.", nombreRepartidor, nPedidos,
                    nombreCliente));

        } catch (Exception e) {
            log.error(format(
                    "[%s] Ha habido un error durante la ejecucion de el codigo del RepartidorT en el manager. Error: %s",
                    nombreRepartidor, e.getLocalizedMessage()));
        }

    }
}