package com.diesgut.jpa.sakila.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    //Cuando la relación es oneToMany el fetchType por defecto es lazy (no trae información)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor", fetch = FetchType.LAZY)
    private List<FilmActor> filmsActors;

    public Actor() {
    }

    public Actor(Long actorId) {
        this.actorId = actorId;
    }

    public Actor(Long actorId, String firstName, String lastName, LocalDateTime lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<FilmActor> getFilmsActors() {
        return filmsActors;
    }

    public void setFilmsActors(List<FilmActor> filmsActors) {
        this.filmsActors = filmsActors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actorId != null ? actorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        /**
         * Segun la especificacion e JPA, las variables de la entidad no deben
         * ser accedidas directamente por los clientes. las variables deben ser
         * accedidas via metodos de acceso (getter).
         */
        if ((this.actorId == null && other.getActorId() != null) || (this.actorId != null && !this.getActorId().equals(other.getActorId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate + ", filmsActors=" + filmsActors + '}';
    }

}
