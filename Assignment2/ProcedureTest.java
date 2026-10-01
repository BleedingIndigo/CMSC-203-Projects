import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProcedureTest {

    @Test
    public void testTotalCharges() {
        Procedure procedure1 =
                new Procedure("MRI", "01/02/2026", "Tom", 800.00);

        Procedure procedure2 =
                new Procedure("X-Ray", "01/03/2026", "Mary", 500.00);

        Procedure procedure3 =
                new Procedure("Injections", "01/02/2026", "Catherine", 300.00);

        double total = PatientDriverApp.calculateTotalCharges(
                procedure1, procedure2, procedure3);

        assertEquals(1600.00, total);
    }
}