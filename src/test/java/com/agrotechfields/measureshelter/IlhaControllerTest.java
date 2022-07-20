package com.agrotechfields.measureshelter;

import static org.mockito.Mockito.doReturn;

import java.util.List;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.agrotechfields.measureshelter.service.IlhaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.agrotechfields.measureshelter.controller.IlhaController;
import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.form.IlhaForm;
import com.agrotechfields.measureshelter.model.Ilha;

@WebMvcTest(IlhaController.class)
public class IlhaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IlhaService ilhaService;

  @Test
  @DisplayName("deve retornar lista vazia quanndo nao houver ilhas cadastradas")
  void deve_retornar_lista_vazia() throws Exception {
    doReturn(List.of()).when(ilhaService).listar();

    final var resposta = mockMvc.perform(get("/ilhas"));

    resposta
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().string(CoreMatchers.containsString("[]")));

  }

  @Test
  @DisplayName("deve retornanr lista de ilhas quando houver ilhas cadastradas")
  void deve_retornar_lista_de_ilhas() throws Exception {
    IlhaDto ilha = criaIlhaMock();
    doReturn(List.of(ilha)).when(ilhaService).listar();

    final var resposta = mockMvc.perform(get("/ilhas"));
    resposta
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].nome").value("ilha 1"))
        .andExpect(jsonPath("$[0].latitude").value("-7.115"))
        .andExpect(jsonPath("$[0].longitude").value("-34.86306"))
        .andExpect(jsonPath("$[0].operante").value(true))
        .andExpect(jsonPath("$[0].medicoes").isEmpty());
  }

  @Test
  @DisplayName("deve cadastrar uma nova ilha")
  void deve_cadastrar_ilha() throws Exception {
    IlhaDto ilha = criaIlhaMock();
    IlhaForm ilhaForm = new IlhaForm("ilha 1", "-7.115", "-34.86306");

    doReturn(ilha).when(ilhaService).cadastrar(ilhaForm);

    final var resposta = mockMvc.perform(post("/ilhas")
        .contentType(MediaType.APPLICATION_JSON))
        .content(new ObjectMapper().writeValueAsString(ilhaForm));

        resposta
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value("1"))
        .andExpect(jsonPath("$.nome").value("ilha 1"))
        .andExpect(jsonPath("$.latitude").value("-7.115"))
        .andExpect(jsonPath("$.longitude").value("-34.86306"))
        .andExpect(jsonPath("$.operante").value(true))
        .andExpect(jsonPath("$.medicoes").isEmpty());
  }

  IlhaDto criaIlhaMock() {
    return new IlhaDto(new Ilha(
        "1",
        "ilha 1",
        "-7.115",
        "-34.86306",
        true,
        List.of()));
  }
}
