package br.com.fiap.cervejaria;

import br.com.fiap.cervejaria.Controller.CervejaController;
import br.com.fiap.cervejaria.dto.CervejaDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CervejariaControllerUnitTest {

    @Test
    public void getAllTest(){
        CervejaController cervejaController = new CervejaController();
        List<CervejaDTO> cervejaDTOList = cervejaController.getAll(null);
        assertEquals(cervejaDTOList.size(), 3);

    }

}
