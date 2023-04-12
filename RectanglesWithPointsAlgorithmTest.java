import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

class xasasxRectanglesWithPointsAlgorithmTest {
    @Test
    void firstTest(){
        String data = """
                4
                2 2 6 8
                5 4 9 10
                4 0 11 6
                8 2 12 12
                5
                2 2
                12 12
                10 4
                5 5
                2 10
                """;
        StringWriter out = new StringWriter();
        RectanglesWithPointsAlgorithmSolver solver = new RectanglesWithPointsAlgorithmSolver();
        solver.brutForceSolve(new Scanner(data), new PrintWriter(out));
        Assertions.assertEquals(out.toString(),
                """
                        1
                        1
                        2
                        3
                        0
                        """);
    }
}