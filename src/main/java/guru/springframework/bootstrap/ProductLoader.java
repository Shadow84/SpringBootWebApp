package guru.springframework.bootstrap;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product product = new Product();
        product.setRenderingEngine("Misc");
        product.setPlatform("Kali Linux");
        product.setEngineVersion(new BigDecimal("18.95"));
        product.setCssGrade("TestCSSGrade");
        product.setBrowser("Mozilla FireFox");
        productRepository.save(product);

        log.info("Saved product - id: " + product.getId());

        Product product2 = new Product();
        product2.setRenderingEngine("Misc");
        product2.setPlatform("Windows");
        product2.setCssGrade("TestCSSGrade2");
        product2.setBrowser("Google Chrome");
        product2.setEngineVersion(new BigDecimal("11.95"));
        productRepository.save(product2);

        log.info("Saved product2 - id:" + product2.getId());
    }
}
