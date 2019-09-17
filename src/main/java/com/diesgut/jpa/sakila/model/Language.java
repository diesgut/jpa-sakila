package com.diesgut.jpa.sakila.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language", fetch = FetchType.LAZY)
    private List<Film> languageFilms;

    @OneToMany(mappedBy = "originalLanguage", fetch = FetchType.LAZY)
    private List<Film> originalLanguageFilms;

    public Language() {
    }

    public Language(Long languageId) {
        this.languageId = languageId;
    }

    public Language(Long languageId, String name, Date lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getLanguageFilms() {
        return languageFilms;
    }

    public void setLanguageFilms(List<Film> languageFilms) {
        this.languageFilms = languageFilms;
    }

    public List<Film> getOriginalLanguageFilms() {
        return originalLanguageFilms;
    }

    public void setOriginalLanguageFilms(List<Film> originalLanguageFilms) {
        this.originalLanguageFilms = originalLanguageFilms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diesgut.jpa.sakila.model.Language[ languageId=" + languageId + " ]";
    }

}
