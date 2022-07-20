package com.agrotechfields.measureshelter;

import static org.mockito.Mockito.doReturn;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.agrotechfields.measureshelter.service.IlhaService;
import com.agrotechfields.measureshelter.controller.IlhaController;

@WebMvcTest(IlhaController.class)
public class IlhaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IlhaService ilhaService;

  @Test
  @DisplayName("deve retornar llista vazia quanndo nao houver ilhas cadastradas")
  void deve_retornar_lista_vazia() throws Exception {
    doReturn(List.of()).when(ilhaService).listar();

    final var resposta = mockMvc.perform(get("/ilhas"));

    resposta
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(CoreMatchers.containsString("[]")));

  }
}
