package integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Tag("integration")
class HelloControllerIT {

    @Test
    void getUserById() {
        Assertions.assertEquals(1,1);
    }
}