package com.diesgut.jpa.sakila.config;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

public class SimplePersistenceInfo implements PersistenceUnitInfo {

    private final String name;

    public SimplePersistenceInfo(String name) {
        this.name = name;
    }

    @Override
    public String getPersistenceUnitName() {
        return name;
    }

    @Override
    public List<URL> getJarFileUrls() {
        try {
            return Collections.list(
                    this.getClass()
                            .getClassLoader()
                            .getResources("")); //con una cadena vacia nos devuelve la url del resource
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public String getPersistenceProviderClassName() {
        return null;
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return null;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return null;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer ct) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }

}
