package net.hemisoft.p2p.converter.plattform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "not.valid.package")
public class PlattformApplication {
	static void main(String[] args) { SpringApplication.run PlattformApplication, args }
}