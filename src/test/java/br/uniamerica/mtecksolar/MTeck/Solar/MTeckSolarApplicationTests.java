package br.uniamerica.mtecksolar.MTeck.Solar;

import br.uniamerica.mtecksolar.MTeck.Solar.user.domain.TechnicalUserDto;
import br.uniamerica.mtecksolar.MTeck.Solar.user.service.TechnicalUserService;
import br.uniamerica.mtecksolar.MTeck.Solar.user.web.TechnicalUserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TechnicalUserController.class)
class MTeckSolarApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TechnicalUserService service;

  @Test
  void shouldTestUserControllerResponseFromSave() throws Exception {
    var technicalUser = TechnicalUserDto.builder().email("technical-user@hotmail.com").password("hackme").build();
    mockMvc.perform(
            post("/user", technicalUser)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(technicalUser)))
            .andDo(print()).andExpect(status().isOk());
  }


  public static String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      final String jsonContent = mapper.writeValueAsString(obj);
      System.out.println(jsonContent);
      return jsonContent;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
