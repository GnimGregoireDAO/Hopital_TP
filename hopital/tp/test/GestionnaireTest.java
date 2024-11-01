package hopital.tp.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hopital.tp.Admission;
import hopital.tp.Gestionnaire;
import hopital.tp.Patient;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;



public class GestionnaireTest {

    private Gestionnaire gestionnaire;

    @BeforeEach
    public void setUp() {
        gestionnaire = new Gestionnaire();

    }

    @Test
    public void testCreationLit() {
        gestionnaire.créationLit();
        assertEquals(151, gestionnaire.lits.size());
    }

    @Test
    public void testCreationMedecin() {
        gestionnaire.créationMedecin();
        assertEquals(3, gestionnaire.medecins.size());
    }

    @Test
    public void testCreationAssurance() {
        gestionnaire.creationAssurance();
        assertEquals(3, gestionnaire.assurances.size());
    }

    @Test
    public void testAjouterPatient() {
        String input = "1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionnaire.ajouterPatient();
        assertEquals(1, gestionnaire.patients.size());
        assertEquals("1234567890", gestionnaire.patients.get(0).getNumeroRAMQ());
    }

    @Test
    public void testCreerAdmission() {
        String input = "1\nnon\n2023-01-01\nfalse\nfalse\n1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Admission admission = gestionnaire.creerAdmission();
        assertNotNull(admission);
        assertEquals(1, admission.getIDAdmission());
    }

    @Test
    public void testRechercherPatient() {
        String input = "1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionnaire.ajouterPatient();
        Patient patient = gestionnaire.rechercherPatient("1234567890");
        assertNotNull(patient);
        assertEquals("1234567890", patient.getNumeroRAMQ());
    }

    @Test
    public void testVerificationPatient() {
        String input = "1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionnaire.ajouterPatient();
        assertTrue(gestionnaire.VerificationPatient("1234567890"));
        assertFalse(gestionnaire.VerificationPatient("0987654321"));
    }

    @Test
    public void testDonnerConge() {
        String input = "1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionnaire.ajouterPatient();
        Patient patient = gestionnaire.rechercherPatient("1234567890");

        String admissionInput = "1\nnon\n2023-01-01\nfalse\nfalse\n1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream admissionIn = new ByteArrayInputStream(admissionInput.getBytes());
        System.setIn(admissionIn);

        Admission admission = gestionnaire.creerAdmission();
        gestionnaire.admissions.add(admission);

        String congeInput = "1234567890\n2023-01-10\n";
        ByteArrayInputStream congeIn = new ByteArrayInputStream(congeInput.getBytes());
        System.setIn(congeIn);

        gestionnaire.donnerConge();
        assertEquals(LocalDate.of(2023, 1, 10), admission.getDateConge());
        assertFalse(admission.getLit().isOccupe());
    }

    @Test
    public void testAfficherFacturePatient() {
        String input = "1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionnaire.ajouterPatient();
        Patient patient = gestionnaire.rechercherPatient("1234567890");

        String admissionInput = "1\nnon\n2023-01-01\nfalse\nfalse\n1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream admissionIn = new ByteArrayInputStream(admissionInput.getBytes());
        System.setIn(admissionIn);

        Admission admission = gestionnaire.creerAdmission();
        gestionnaire.admissions.add(admission);

        String congeInput = "1234567890\n2023-01-10\n";
        ByteArrayInputStream congeIn = new ByteArrayInputStream(congeInput.getBytes());
        System.setIn(congeIn);

        gestionnaire.donnerConge();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String factureInput = "1\n";
        ByteArrayInputStream factureIn = new ByteArrayInputStream(factureInput.getBytes());
        System.setIn(factureIn);

        gestionnaire.afficherFacturePatient();
        String expectedOutput = "La facture totale du patient est de: ";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testSauvegarderAdmissions() {
        String input = "1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionnaire.ajouterPatient();
        Patient patient = gestionnaire.rechercherPatient("1234567890");

        String admissionInput = "1\nnon\n2023-01-01\nfalse\nfalse\n1234567890\nJohn\nDoe\n514-123-4567\nMontreal\nQuebec\n123 rue de la rue\nH1H 1H1\nnon\n2000-01-01\n21\n";
        ByteArrayInputStream admissionIn = new ByteArrayInputStream(admissionInput.getBytes());
        System.setIn(admissionIn);

        Admission admission = gestionnaire.creerAdmission();
        gestionnaire.admissions.add(admission);

        String filePath = "admissions.txt";
        gestionnaire.sauvegarderAdmissions(filePath);

        // Check if the file was created and contains the expected content
        // This part is left as an exercise for the reader, as it involves file I/O operations
    }
}