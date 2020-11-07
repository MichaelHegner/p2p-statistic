package net.hemisoft.p2p.converter.plattform.envestio

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule

import net.hemisoft.p2p.converter.plattform.PlattformConfiguration
import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.dto.LoanDto

@SpringBootApplication
@ComponentScan(basePackageClasses=PlattformConfiguration)
class PlattformApplication {
    static void main(String[] args) { SpringApplication.run PlattformApplication, args }
    
    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper()
        SimpleModule module = new SimpleModule()
        module.addDeserializer(AccountDto.class, new AccountDtoDeserializer())
        module.addDeserializer(LoanDto.class, new LoanDtoDeserializer())
        mapper.registerModule(module)
        return mapper
    }
}