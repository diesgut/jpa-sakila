package com.diesgut.jpa.sakila;

import com.diesgut.jpa.sakila.model.Actor;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainConPersistenceXML {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sakila_main");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Actor actor = new Actor();
        actor.setFirstName("miluska");
        actor.setLastName("sanchez");
        actor.setLastUpdate(LocalDateTime.now());
        em.persist(actor);

        //Actor2 se actualizará en la base de datos, porque el actor de id 2 ya se encuentra en el entity manager
        Actor actor2 = em.find(Actor.class, 2L);
        actor2.setLastName(actor2.getLastName() + "2");

        //Actor3 no se actualizara en la base de datos, porque luego de hacerle un find lo quitamos del entity manager con el método detach
        Actor actor3 = em.find(Actor.class, 3L);
        em.detach(actor3);
        actor3.setLastName(actor2.getLastName() + "2");
        //En una transacción jpa primero ejecuta los insert, luego los update y finalmente los deletes (sin importar el orden como estén las operaciones en el codigo).
        //a menos que vallamos haciendo flush luego de cada operación
        //las operacions find y getResultList hacen flush automaticamente
        //flush : recorre todos los objetos del persistence context y validar si se requiere enviar cambios a la base de datos
        //al trabajar con listas grandes, lo dieal es ir limpiando esos objetos de persistence context con el metodo clear() del entitymanager (bastante recomendable)
        //colocando readOnley=true en nuestra transaccion deshabilita el flush automatico y el resultado sera similar a ir limpiando el contexto
        //no es recomendable hacer un proceso de larga duracion (webservice o procesar datos) en una transaccion, puesto que tomara una conexion por mucho tiempo, evitando el acceso a la applicacion
        em.getTransaction().commit();
        em.close();
        emf.close(); //cierra el pool de conexiones (proceso separado de nuestor proceso principal (main))
    }

}
