package IntegrationTest.products;


import co.com.edu.udea.oldwavespringapi.OldwaveSpringApiApplication;
import com.intuit.karate.junit5.Karate;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = OldwaveSpringApiApplication.class)
class KarateDetailRunner {

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}