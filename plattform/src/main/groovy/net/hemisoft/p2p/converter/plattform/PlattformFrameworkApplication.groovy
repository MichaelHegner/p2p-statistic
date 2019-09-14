package net.hemisoft.p2p.converter.plattform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "not.valid.package")
public class PlattformFrameworkApplication {
	static void main(String[] args) { SpringApplication.run PlattformFrameworkApplication, args }
}