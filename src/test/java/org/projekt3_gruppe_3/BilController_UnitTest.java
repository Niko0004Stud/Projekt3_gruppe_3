package org.projekt3_gruppe_3;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.projekt3_gruppe_3.controller.BilController;
import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.model.Bilmodel;
import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.service.BilService;
import org.springframework.ui.Model;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BilController_UnitTest {

    @Mock
    private BilService bilService;

    @Mock
    private Model model;

    @InjectMocks
    private BilController bilController;

    @Test
    public void cReadAllBilMainFlow(){
        // Precondition
        String oversigtPageType = "oversigtBil";
        Bil bil;
        User user = new User();
        HttpSession session = mock(HttpSession.class);
        session.setAttribute("user", user);
        ArrayList<Bil> bilList = new ArrayList<>();
        for(int i=0; i<10; i++){
            bil = new Bil();
            bilList.add(bil);
        }
        given(bilService.sReadAllBil()).willReturn(bilList);

        // Execution
        String result = bilController.cReadAllBil(oversigtPageType, session, model);

        //Postcondition
        assertEquals("oversigtPage", result);
        verify(model).addAttribute("bilList", bilList);

        /*int id = 1; String vognnummer = "testVn"; String stelnummer = "testStelnummer"; int udstyrsNiveau = 2; int modelId = 2; String maerke = "testMaerke"; double staalpris = 123.0; double regAfgift = 32.2; double co2Udledning = 21.3; String beskrivelse = "testBeskrivelse"; String statusBil = "reseveret";
        Bilmodel bilmodel = new Bilmodel(maerke, model)
        Bil bil = new Bil(id, vognnummer, stelnummer, modelId, udstyrsNiveau, staalpris, regAfgift, co2Udledning, beskrivelse, statusBil);
        */
    }

    @Test
    public void cReadAllBilExceptionFlow(){
        // Precondition
        String oversigtPageType = "oversigtBil";
        Bil bil;
        User user = new User();
        HttpSession session = mock(HttpSession.class);
        session.setAttribute("user", user);
        ArrayList<Bil> bilList = new ArrayList<>();
        for(int i=0; i<10; i++){
            bil = new Bil();
            bilList.add(bil);
        }
        given(bilService.sReadAllBil()).willReturn(null);

        // Execution
        String result = bilController.cReadAllBil(oversigtPageType, session, model);

        //PostCondition
        assertEquals("oversigtPage", result);
        assertTrue(model.asMap().isEmpty());

    }
}
