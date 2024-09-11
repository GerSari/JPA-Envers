package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
/*
            // Crear nueva factura
            Factura factura1 = new Factura();
            factura1.setNumero(10);
            factura1.setFecha("08/09/2024");

            //crear nuevo domicilio
            Domicilio domicilio= new Domicilio("San Martin", 1367);


            //crear nuevo cliente
            Cliente cliente = new Cliente("German", "Sari", 45719280);
            cliente.setDomicilio(domicilio);
            domicilio.setCliente(cliente);

            //SETEAMOS A FACTURA EL CLIENTE
            factura1.setCliente(cliente);

            //CREAR CATEGORIAS
            Categoria liquidos = new Categoria("Liquidos");
            Categoria gaseosa = new Categoria("Gaseosa");
            Categoria comida = new Categoria("Comida");

            //CREAR ARTICULOS
            Articulo articulo1 = new Articulo(50, "agua", 1000);
            Articulo articulo2 = new Articulo(400, "caramelos", 100);

            //SE ASIGNAN LOS ARTICULOS A LAS CATEGORIAS Y LAS CATEGORIAS A LOS ARTICULOS
            articulo1.getCategorias().add(liquidos);
            articulo1.getCategorias().add(gaseosa);
            liquidos.getArticulos().add(articulo1);
            gaseosa.getArticulos().add(articulo1);

            articulo2.getCategorias().add(comida);
            comida.getArticulos().add(articulo2);

            //detalle de factura 1
            DetalleFactura detalle1 = new DetalleFactura();

            detalle1.setArticulo(articulo1);
            detalle1.setCantidad(4);
            detalle1.setSubtotal(4000);

            //BIRIDICCIONALIDADES detalle 1
            articulo1.getDetalle().add(detalle1);
            factura1.getDetalles().add(detalle1);
            detalle1.setFactura(factura1);

            //nuevo detalle2
            DetalleFactura detalle2 = new DetalleFactura();

            detalle2.setArticulo(articulo2);
            detalle2.setCantidad(10);
            detalle2.setSubtotal(1000);

            //BIRIDICCIONALIDADES detalle 2
            articulo2.getDetalle().add(detalle2);
            factura1.getDetalles().add(detalle2);
            detalle2.setFactura(factura1);

*/

/*

            // Crear nueva factura2
            Factura factura2 = new Factura();
            factura2.setNumero(10);
            factura2.setFecha("11/09/2024");

            //crear nuevo domicilio
            Domicilio domicilio2 = new Domicilio("Belgrano", 1367);


            //crear nuevo cliente
            Cliente cliente2 = new Cliente("Juan", "Gomez", 45719280);
            cliente2.setDomicilio(domicilio2);
            domicilio2.setCliente(cliente2);

            //SETEAMOS A FACTURA EL CLIENTE
            factura2.setCliente(cliente2);

            //CREAR CATEGORIA
            Categoria lacteos = new Categoria("Lacteos");
            Categoria limpieza = new Categoria("Limpieza");

            //CREAR ARTICULOS
            Articulo articulo3 = new Articulo(50, "Detergente", 1000);
            Articulo articulo4 = new Articulo(50, "Yogurt", 600);

            //SE ASIGNAN LOS ARTICULOS A LAS CATEGORIAS Y LAS CATEGORIAS A LOS ARTICULOS
            articulo3.getCategorias().add(limpieza);
            articulo4.getCategorias().add(lacteos);
            limpieza.getArticulos().add(articulo3);
            lacteos.getArticulos().add(articulo4);


            //detalle de factura 3
            DetalleFactura detalle3 = new DetalleFactura();

            detalle3.setArticulo(articulo3);
            detalle3.setCantidad(4);
            detalle3.setSubtotal(4000);

            //BIRIDICCIONALIDADES detalle 3
            articulo3.getDetalle().add(detalle3);
            factura2.getDetalles().add(detalle3);
            detalle3.setFactura(factura2);

            //nuevo detalle4
            DetalleFactura detalle4 = new DetalleFactura();

            detalle4.setArticulo(articulo4);
            detalle4.setCantidad(10);
            detalle4.setSubtotal(6000);

            //BIRIDICCIONALIDADES detalle 4
            articulo4.getDetalle().add(detalle4);
            factura2.getDetalles().add(detalle4);
            detalle4.setFactura(factura2);

            //total de la factura
            factura2.setTotal(10000);
*/

            Factura factura2 = entityManager.find(Factura.class, 1L);
                    factura2.setNumero(38);


            entityManager.merge(factura2);
            entityManager.flush();
            entityManager.getTransaction().commit();


        }catch (Exception e){

            entityManager.getTransaction().rollback();
            e.printStackTrace();

        }

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
