package console;

import org.junit.*;

import static org.junit.Assert.*;

public class CommandFactoryTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class!");
    }

    @Before
    public void before() {
        System.out.println("Before!");
    }
    @Test
    public void createCommand() throws Exception {
        assertTrue(true);
    }

    @Test
    public void createCommand2() throws Exception {
        assertFalse(false);
    }

    @After
    public void after() {
        System.out.println("After!");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class!");
    }

}