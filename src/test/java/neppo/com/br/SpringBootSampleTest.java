package neppo.com.br;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SpringBootSampleTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testHello() throws Exception {
        long init = System.currentTimeMillis();
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port + "/hello", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("Hello World", entity.getBody());

        System.out.println("Time: " + (System.currentTimeMillis() - init));
    }


}