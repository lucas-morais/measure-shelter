package com.agrotechfields.measureshelter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.agrotechfields.measureshelter.service.IlhaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.agrotechfields.measureshelter.controller.IlhaController;
import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.dto.IlhaStatusDto;
import com.agrotechfields.measureshelter.form.IlhaForm;
import com.agrotechfields.measureshelter.form.IlhaStatusForm;
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

    when(ilhaService.cadastrar(any(IlhaForm.class))).thenReturn(ilha);

    mockMvc.perform(post("/ilhas")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(ilhaForm)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.nome").value(ilha.getNome()))
        .andExpect(jsonPath("$.latitude").value(ilha.getLatitude()))
        .andExpect(jsonPath("$.longitude").value(ilha.getLongitude()))
        .andExpect(jsonPath("$.operante").value(ilha.isOperante()))
        .andExpect(jsonPath("$.medicoes").isEmpty());

  }

  @Test
  @DisplayName("Deve buscar uma ilha pelo id")
  void deve_buscar_ilha_por_id() throws Exception {
    IlhaDto ilha = criaIlhaMock();
    when(ilhaService.buscarPorId("1")).thenReturn(ilha);

    mockMvc.perform(get("/ilhas/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nome").value(ilha.getNome()))
        .andExpect(jsonPath("$.latitude").value(ilha.getLatitude()))
        .andExpect(jsonPath("$.longitude").value(ilha.getLongitude()))
        .andExpect(jsonPath("$.operante").value(ilha.isOperante()))
        .andExpect(jsonPath("$.medicoes").isEmpty());

        
  }

  @Test
  @DisplayName("deve atualizar ilha ao receber dados de uma ilha e id")
  public void deve_atualizar_ilha() throws JsonProcessingException, Exception {
    IlhaDto ilhaDto = criaIlhaMock();
    Ilha ilha = new Ilha("1", "novo nome", "-7.115", "-34.86306", true, List.of());
    when(ilhaService.atualizar(any(Ilha.class), anyString())).thenReturn(ilhaDto);

    mockMvc.perform(put("/ilhas/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(ilha)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nome").value(ilhaDto.getNome()))
        .andExpect(jsonPath("$.latitude").value(ilhaDto.getLatitude()))
        .andExpect(jsonPath("$.longitude").value(ilhaDto.getLongitude()))
        .andExpect(jsonPath("$.operante").value(ilhaDto.isOperante()))
        .andExpect(jsonPath("$.medicoes").isEmpty());;
  }

  @Test
  @DisplayName("Deve apagar uma ilha recebendo o id")
  public void deve_apagar_ilha() throws Exception {
    doNothing().when(ilhaService).deletar("1");
    mockMvc.perform(delete("/ilhas/1")).andExpect(status().isNoContent());

  }

  @Test
  @DisplayName("Deve alterar o status de uma ilha")
  public void deve_alterar_status() throws Exception {
    IlhaStatusForm ilhaStatusForm = new IlhaStatusForm(false);
    IlhaStatusDto ilhaStatusDto = new IlhaStatusDto("1", false);
    when(ilhaService.status(anyBoolean(), anyString())).thenReturn(ilhaStatusDto);

    mockMvc.perform(patch("/ilhas/1/status")
    .contentType(MediaType.APPLICATION_JSON)
      .content(new ObjectMapper().writeValueAsString(ilhaStatusForm))
    )
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(ilhaStatusDto.getId()))
      .andExpect(jsonPath("$.status").value(ilhaStatusDto.isStatus()));

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
