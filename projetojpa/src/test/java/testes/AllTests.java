package testes;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    @Test
    @Order(1)
    public void firstTest() {
        TesteListarProduto lp = new TesteListarProduto();
        lp.test();
        }

 
}