package com.mbsystems.domainservice.config;

import com.mbsystems.domaincrawler.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DomainKafkaConsumer {

    @Bean
    public Consumer<KStream<String, Domain>> domainService() {
        return kstream -> kstream.foreach((key, domain) -> {
            System.out.println(String.format("Basil, Domain consumed[%s] Status[%s]", domain.getDomain(), domain.isDead()));
        });
    }
}
