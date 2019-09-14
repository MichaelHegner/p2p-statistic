package net.hemisoft.p2p.converter.plattform.grupeer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

import net.hemisoft.p2p.converter.plattform.PlattformConfiguration

@SpringBootApplication
@ComponentScan(basePackageClasses=PlattformConfiguration)
class PlattformApplication {
	static void main(String[] args) { SpringApplication.run PlattformApplication, args }
}
