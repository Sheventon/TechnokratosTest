package com.example.technokratostest;

import com.example.technokratostest.dto.UserSummaryDto;
import com.example.technokratostest.models.Film;
import com.example.technokratostest.services.UserSummariesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SummariesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserSummariesService userSummariesService;

    @BeforeEach
    public void setUp() {
        List<Film> films = List.of(
                Film.builder()
                        .id("618d896f86985003c445710a")
                        .originalLanguage("en")
                        .originalTitle("Harry Potter and the Philosopher's Stone")
                        .overview("The story of a boy wizard from Hogwarts School")
                        .popularity(240.854)
                        .posterPath("/vkgM120mI0RH07njaFFlzG8wU4y.jpg")
                        .releaseDate("2001-11-16")
                        .title("Гарри Поттер и Филосовский камень")
                        .video(false)
                        .voteAverage(7.9)
                        .voteCount(21314)
                        .adult(false)
                        .backdropPath("/lvOLivVeX3DVVcwfVkxKf0R22D8.jpg")
                        .genreIds(List.of(12, 14))
                        .build(),
                Film.builder()
                        .id("618d899586985003c445710b")
                        .originalLanguage("en")
                        .originalTitle("Harry Potter and Goblet of Fire")
                        .overview("")
                        .popularity(20.65)
                        .posterPath("/vkgMG8wU4y.jpg")
                        .releaseDate("2005-11-16")
                        .title("Гарри Поттер и Кубок Огня")
                        .video(false)
                        .voteAverage(7.5)
                        .voteCount(23115)
                        .adult(false)
                        .backdropPath("/lXf0R22D8.jpg")
                        .genreIds(List.of(12, 14))
                        .build());

        when(userSummariesService.getAll()).thenReturn(List.of(
                UserSummaryDto.builder()
                        .id("618e5072a00aa66b6bbad43f")
                        .firstName("Anton")
                        .lastName("Sheverda")
                        .email("anton@gmail.com")
                        .films(films)
                        .build(),
                UserSummaryDto.builder()
                        .id("618e5072a00aa66b6bbsd54d")
                        .firstName("Igor")
                        .lastName("Sheverda")
                        .email("igor@gmail.com")
                        .films(films)
                        .build()
        ));

        when(userSummariesService.getById("618e5072a00aa66b6bbad43f")).thenReturn(
                UserSummaryDto.builder()
                        .id("618e5072a00aa66b6bbad43f")
                        .firstName("Anton")
                        .lastName("Sheverda")
                        .email("anton@gmail.com")
                        .films(films)
                        .build());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/summary/get/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetById() throws Exception {
        mockMvc.perform(get("/summary/get/618d896f86985003c445710a"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
