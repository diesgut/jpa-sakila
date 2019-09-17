package com.diesgut.jpa.sakila.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmActorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "actor_id")
    private Long actorId;

    @Basic(optional = false)
    @Column(name = "film_id")
    private Long filmId;

    public FilmActorPK() {
    }

    public FilmActorPK(Long actorId, Long filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Long) actorId;
        hash += (Long) filmId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmActorPK)) {
            return false;
        }
        FilmActorPK other = (FilmActorPK) object;
        if (this.actorId != other.actorId) {
            return false;
        }
        if (this.filmId != other.filmId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diesgut.jpa.sakila.model.FilmActorPK[ actorId=" + actorId + ", filmId=" + filmId + " ]";
    }

}
