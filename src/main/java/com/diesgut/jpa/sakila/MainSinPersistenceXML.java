package com.diesgut.jpa.sakila;

import com.diesgut.jpa.sakila.config.SimplePersistenceInfo;
import com.diesgut.jpa.sakila.model.Actor;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class MainSinPersistenceXML {

    public static void main(String[] args) {
        MainSinPersistenceXML main = new MainSinPersistenceXML();
        PersistenceProvider hpp = new HibernatePersistenceProvider();
        PersistenceUnitInfo persistenceInfo = new SimplePersistenceInfo("sakila_main");
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/sakila");
        properties.put("hibernate.show_sql", "true");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "mysql");

        EntityManagerFactory emf = hpp.createContainerEntityManagerFactory(persistenceInfo, properties);
        EntityManager em = emf.createEntityManager();

        Actor actor = main.findActor(em, 2L);

        em.close();
        emf.close(); //cierra el pool de conexiones (proceso separado de nuestor proceso principal (main))

    }

    public Actor findActor(EntityManager em, Long id) {
        /**
         * hacemos select usando la primary key y crea el objeto en memoria. si
         * ya esta en memoria lo reutiliza.
         */
        Actor actor = em.find(Actor.class, id);
        System.out.println(actor);
        /**
         * getReference busca el registro en la base de datos sin cargar sus
         * datos los carga cuando sea necesario (lazy loading). si el registro
         * ya esta en memoria lo reutiliza. El get reference se ejecuta asi el
         * registro no exista, saltara una exepcion al querer acceder a uno de
         * sus atributos.
         */
        Actor actor2 = em.getReference(Actor.class, 2L);
        System.out.println(actor2);
        Actor actor3 = em.getReference(Actor.class, 3L);
        System.out.println(actor3);
        
        em.refresh(actor); //refresca el objeto de memoria con la base de datos
        return actor;
    }

}
