package br.com.fuctura.bibliotecaNoite.profiles;

import br.com.fuctura.bibliotecaNoite.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestProfile {

    @Autowired
    private DBService dbService;

    @Bean
    public DBService instaciaDB() {
        this.dbService.instanciaDB();
        return null;
    }
}
