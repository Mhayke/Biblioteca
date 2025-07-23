package br.com.fuctura.bibliotecaNoite.profiles;

import br.com.fuctura.bibliotecaNoite.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfile {

    @Autowired
    private DBService dbService;

    @Bean
    public void instaciaDB() {
        this.dbService.instanciaDB();
    }


}
