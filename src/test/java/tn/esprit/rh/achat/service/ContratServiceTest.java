package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.services.ContratServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ContratServiceTest {


    @InjectMocks
    public ContratServiceImpl ContratServiceImpl;
    @Mock
    public ContratRepository contratRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void TestaddContrat() {
        Contrat contrat = new Contrat();

        when(contratRepository.save(contrat)).thenReturn(contrat);

        Contrat result = ContratServiceImpl.addContrat(contrat);

        assertEquals(contrat, result);
    }
    @Test
    void testRetrieveAllcontrats() {
        // Créer une liste fictive de stocks pour simuler la réponse de la base de données
        List<Contrat> contrats = new ArrayList<>();
        Contrat contrat1 = new Contrat();
        Contrat contrat2 = new Contrat();
        contrats.add(contrat1);
        contrats.add(contrat2);

        // Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
        when(contratRepository.findAll()).thenReturn(contrats);


        List<Contrat> result = ContratServiceImpl.retrieveAllContrats();


        verify(contratRepository).findAll();


        assertEquals(contrats, result);
    }



}
