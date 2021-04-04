package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void test_SetName() {
        User user = new User();

        user.setName("John");

        Assertions.assertEquals("John", user.getName());
    }
}