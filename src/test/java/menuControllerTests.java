import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import controller.menuController;

import picocli.CommandLine;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class menuControllerTests {
    
    CommandLine cmd;

    final PrintStream originalOut = System.out;
    final PrintStream originalErr = System.err;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ByteArrayOutputStream err = new ByteArrayOutputStream();

    @BeforeAll
    public void init() {
        menuController app = new menuController();
        this.cmd = new CommandLine(app);
    }

    @BeforeEach
    public void setUpStreams() {
        out.reset();
        err.reset();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /** 
    @Test
    @Order(1)
    @DisplayName("get all menus")
    public void getMenus() {
        int exitCode = cmd.execute("listMenu");
        assertEquals(0, exitCode);
    }

    @Test
    @Order(2)
    @DisplayName("delete a menu")
    public void deleteMenu() {
        int exitCode = cmd.execute("deleteMenu", "-id=1");
        assertEquals(0, exitCode);
    }
    */

}
