package com.agrotechfields.measureshelter;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.agrotechfields.measureshelter.controller.ImagemController;
import com.agrotechfields.measureshelter.dto.ImagemDto;
import com.agrotechfields.measureshelter.model.Imagem;
import com.agrotechfields.measureshelter.service.ImagemService;
import java.util.List;
import org.bson.types.Binary;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ImagemController.class)
public class ImagemControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ImagemService imagemService;

  @Test

  @DisplayName("deve retornar lista vazia quanndo nao houver imagens cadastradas")
  void deve_retornar_lista_vazia() throws Exception {
    doReturn(List.of()).when(imagemService).listarImagens();

    final var resposta = mockMvc.perform(get("/imagens"));

    resposta
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().string(CoreMatchers.containsString("[]")));

  }

  @Test
  @DisplayName("deve retornar lista de imagens quando houver imagens cadastradas")
  void deve_retornar_lista_de_imagens() throws Exception {
    ImagemDto imagem = criaImagemMock();
    doReturn(List.of(imagem)).when(imagemService).listarImagens();

    final var resposta = mockMvc.perform(get("/imagens"));
    resposta
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id").value(imagem.getId()))
        .andExpect(jsonPath("$[0].nome").value(imagem.getNome()));
  }

  ImagemDto criaImagemMock() {
    return new ImagemDto(
        new Imagem("1", "imagem-1", new Binary(new byte[8])));
  }
}
