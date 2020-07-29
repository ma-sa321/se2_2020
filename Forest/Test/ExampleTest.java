import forest.Example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
    @Test
    public void toNumber() {
        String aString = "1000";
        Assertions.assertEquals(1000,Example.toNumber(aString));
    }
}