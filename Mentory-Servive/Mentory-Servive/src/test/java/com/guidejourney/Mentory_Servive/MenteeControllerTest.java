package com.guidejourney.Mentory_Servive.test;

import com.guidejourney.Mentory_Servive.controller.MenteeController;
import com.guidejourney.Mentory_Servive.model.dto.MenteeDTO;
import com.guidejourney.Mentory_Servive.service.MenteeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MenteeController.class)
public class MenteeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenteeService menteeService;

    @Test
    public void getAllMentees_ReturnsListOfMentees() throws Exception {
        // Mocking data
        List<MenteeDTO> menteeDTOList = new ArrayList<>();
        menteeDTOList.add(new MenteeDTO(1L, "Alice", "Learn programming"));
        menteeDTOList.add(new MenteeDTO(2L, "Bob", "Improve public speaking"));

        // Mocking service method
        when(menteeService.getAllMentees()).thenReturn(menteeDTOList);

        // Perform GET request
        mockMvc.perform(get("/mentees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"))
                .andExpect(jsonPath("$[1].name").value("Bob"));
    }

    // Add other test cases for MenteeController as needed
}
