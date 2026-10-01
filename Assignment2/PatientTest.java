import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PatientTest {

    @Test
    public void testPatientName() {

        Patient patient = new Patient("John", "F", "Doe");

        assertEquals("John", patient.getFirstName());
        assertEquals("F", patient.getMiddleName());
        assertEquals("Doe", patient.getLastName());
    }

    @Test
    public void testFullName() {

        Patient patient = new Patient("John", "F", "Doe");

        assertEquals("John F Doe", patient.buildFullName());
    }

    @Test
    public void testAddress() {

        Patient patient = new Patient();

        patient.setStreetAddress("51 Mannakee St");
        patient.setCity("Rockville");
        patient.setState("MD");
        patient.setZipCode("20850");

        assertEquals(
                "51 Mannakee St Rockville MD 20850",
                patient.buildAddress());
    }

    @Test
    public void testEmergencyContact() {

        Patient patient = new Patient();

        patient.setEmergencyName("Mary");
        patient.setEmergencyPhone("240-567-5001");

        assertEquals(
                "Mary 240-567-5001",
                patient.buildEmergencyContact());
    }
}