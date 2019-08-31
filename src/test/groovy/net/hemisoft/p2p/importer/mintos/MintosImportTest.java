package net.hemisoft.p2p.importer.mintos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(properties = "path.mintos.input=data/mintos/current-investments.xlsx")
public class MintosImportTest {

	@Test
	public void testConfiguration() {
		System.out.println("Configuration worked.");
	}
	
//	@Configuration
//	@Import(MintosConfiguration.class)
//	static class SpringConfig {
//		
//		@Bean
//		@Primary
//		Resource mintosResource(@Value("${path.mintos.input}") String path) {
//			return new ClassPathResource(path);
//		}
//	}
	
	
}
