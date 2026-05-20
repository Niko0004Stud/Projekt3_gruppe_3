package org.projekt3_gruppe_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.projekt3_gruppe_3.controller.LejeaftaleController;
import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.projekt3_gruppe_3.service.LejeaftaleService;
import org.springframework.ui.Model;

import java.time.LocalDate;

import static org.awaitility.Awaitility.given;

@ExtendWith(MockitoExtension.class)
public class LejeaftaleService_InputVali_UnitTest {

    @Mock
    private LejeaftaleController lejeaftaleController;


    @InjectMocks
    LejeaftaleService lejeaftaleService;

    // Nicklas
    @Test // Kaster ikke exception da kundeId er en integer over 0
    public void sCreateLejeaftaleMainFlow(){
        //Precondition
        int kundeId = 1;

        //Execution + postcondition
        Assertions.assertDoesNotThrow(
                () -> lejeaftaleService.valideringKundeId(kundeId));


    }

    @Test // Kaster exception da kundeId er en integer over 1
    public void sCreateLejeaftaleExceptionFlow(){
        //Precondition / Arrange
        int kundeId = 0;

        //Execution / act
        IllegalArgumentException exception =
                Assertions.assertThrows(
                        IllegalArgumentException.class,() -> lejeaftaleService.valideringKundeId(kundeId)
                );

        //Postcondition / Assert
        Assertions.assertEquals(
                "KundeId kan ikke være et tal under 1", exception.getMessage()
        );

    }

}
