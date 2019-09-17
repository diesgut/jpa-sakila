package com.diesgut.jpa.sakila.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    @Temporal(TemporalType.DATE)
    private Date releaseYear;

    @Column(name = "rental_duration")
    private short rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Short length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    //Cuando la relación es oneToMany el fetchType por defecto es lazy (no trae información)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film", fetch = FetchType.LAZY)
    private List<FilmActor> filmsActors;

    //Cuando la relación es manyToOne el fetchType por defecto es eager (si trae información)
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language language;

    //Cuando la relación es manyToOne el fetchType por defecto es eager (si trae información)
    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Language originalLanguage;

    /**
     * *
     * cascade = CascadeType.PERSIST, esta propiedad permitiria grabar, nuevos
     * lenguajes (de ser necesario), al guardar el film, los valores de
     * CascadeType son: PERSIST (guardar), MERGE(actualizar), REMOVE (eliminar),
     * REFRESH(actualizar), ALL(todas las operaciones)
     *
     */
    /**
     *
     * ESTADO DE LAS ENTIDADES, **NEW** : Es el estado en el que se encuentra un
     * objeto una vez construido . No esta asociado a ningún PersistenceContext.
     * Se trata de un objeto normal **MANAGED**: Es el estado en el que se
     * encuentra una entidad que esta asociada a un PersistenceContext y
     * almacenada en base de datos via EntityManager. Es el caso de invocar por
     * ejemplo el método persist() de un EntityManager sobre un objeto nuevo.
     * **DETACHED**: Es el estado en el cual se encuentra una entidad que ha
     * estado asociada al PersistenceContext y deja de estarlo. **REMOVED**: Es
     * el estado en el cual se encuentra una entidad que esta todavia controlada
     * por el PersistenceContext pero va a ser eliminada de la base de datos.
     */
    public Film() {
    }

    public Film(Long filmId) {
        this.filmId = filmId;
    }

    public Film(Long filmId, String title, short rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, LocalDateTime lastUpdate) {
        this.filmId = filmId;
        this.title = title;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.lastUpdate = lastUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public List<FilmActor> getFilmsActors() {
        return filmsActors;
    }

    public void setFilmsActors(List<FilmActor> filmsActors) {
        this.filmsActors = filmsActors;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmId != null ? filmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diesgut.jpa.sakila.model.Film[ filmId=" + filmId + " ]";
    }

}
