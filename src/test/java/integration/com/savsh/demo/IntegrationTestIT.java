package integration.com.savsh.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
public class IntegrationTestIT {

    @Test
    public void test() {
        Assertions.assertEquals(1,1);
    }
}
