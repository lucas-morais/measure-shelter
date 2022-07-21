package com.agrotechfields.measureshelter;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.agrotechfields.measureshelter.controller.MedicaoController;
import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.form.MedicaoForm;
import com.agrotechfields.measureshelter.model.Medicao;
import com.agrotechfields.measureshelter.service.MedicaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MedicaoController.class)
public class MedicaoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MedicaoService medicaoService;

  @Test

  @DisplayName("deve retornar lista vazia quanndo nao houver medicoes cadastradas")
  void deve_retornar_lista_vazia() throws Exception {
    doReturn(List.of()).when(medicaoService).listar();

    final var resposta = mockMvc.perform(get("/medicoes"));

    resposta
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().string(CoreMatchers.containsString("[]")));

  }

  @Test
  @DisplayName("deve retornar lista de medicoes quando houver medicoes cadastradas")
  void deve_retornar_lista_de_medicoes() throws Exception {
    MedicaoDto medicao = criaMedicaoMock();
    doReturn(List.of(medicao)).when(medicaoService).listar();

    final var resposta = mockMvc.perform(get("/medicoes"));
    resposta
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id").value(medicao.getId()))
        .andExpect(jsonPath("$[0].temperatura").value(medicao.getTemperatura()))
        .andExpect(jsonPath("$[0].umidadeAr").value(medicao.getUmidadeAr()))
        .andExpect(jsonPath("$[0].umidadeSolo").value(medicao.getUmidadeSolo()));
  }

  @Test
  @DisplayName("deve cadastrar uma nova medicao")
  void deve_cadastrar_medicao() throws Exception {
    MedicaoDto medicao = criaMedicaoMock();
    MedicaoForm medicaoForm = new MedicaoForm("1", 30, 50, 50);
    when(medicaoService.cadastrar(any(MedicaoForm.class))).thenReturn(medicao);

    mockMvc.perform(post("/medicoes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(medicaoForm)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(medicao.getId()))
        .andExpect(jsonPath("$.temperatura").value(medicao.getTemperatura()))
        .andExpect(jsonPath("$.umidadeAr").value(medicao.getUmidadeAr()))
        .andExpect(jsonPath("$.umidadeSolo").value(medicao.getUmidadeSolo()));
  }

  @Test
  @DisplayName("Deve buscar uma medicao pelo id")
  void deve_buscar_ilha_por_id() throws Exception {
    MedicaoDto medicao = criaMedicaoMock();
    when(medicaoService.buscarPorId("1")).thenReturn(medicao);

    mockMvc.perform(get("/medicoes/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.temperatura").value(medicao.getTemperatura()))
        .andExpect(jsonPath("$.umidadeSolo").value(medicao.getUmidadeSolo()))
        .andExpect(jsonPath("$.umidadeAr").value(medicao.getUmidadeAr()));
  }

  @Test
  @DisplayName("deve atualizar medicao ao receber dados de uma medicao e id")
  public void deve_atualizar_medicao() throws JsonProcessingException, Exception {
    MedicaoDto medicao = criaMedicaoMock();
    Medicao medicaoForm = new Medicao("1", 30, 55, 50);
    when(medicaoService.atualizar(any(Medicao.class), anyString())).thenReturn(medicao);

    mockMvc.perform(put("/medicoes/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(medicaoForm)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(medicao.getId()))
        .andExpect(jsonPath("$.temperatura").value(medicao.getTemperatura()))
        .andExpect(jsonPath("$.umidadeAr").value(medicao.getUmidadeAr()))
        .andExpect(jsonPath("$.umidadeSolo").value(medicao.getUmidadeSolo()));
  }

  @Test
  @DisplayName("Deve apagar uma medicao recebendo o id")
  public void deve_apagar_medicao() throws Exception {
    doNothing().when(medicaoService).deletar("1");
    mockMvc.perform(delete("/medicoes/1")).andExpect(status().isNoContent());

  }

  MedicaoDto criaMedicaoMock() {
    return new MedicaoDto(
      new Medicao("1", 30, 50, 50)
    );
  }
}
