package com.guidejourney.Mentory_Servive.test;

import com.guidejourney.Mentory_Servive.controller.MentorController;
import com.guidejourney.Mentory_Servive.model.dto.MentorDTO;
import com.guidejourney.Mentory_Servive.service.MentorService;
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

@WebMvcTest(MentorController.class)
public class MentorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MentorService mentorService;

    @Test
    public void getAllMentors_ReturnsListOfMentors() throws Exception {
        // Mocking data
        List<MentorDTO> mentorDTOList = new ArrayList<>();
        mentorDTOList.add(new MentorDTO(1L, "John Doe", "Java"));
        mentorDTOList.add(new MentorDTO(2L, "Jane Smith", "Python"));

        // Mocking service method
        when(mentorService.getAllMentors()).thenReturn(mentorDTOList);

        // Perform GET request
        mockMvc.perform(get("/mentors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));
    }

    // Add other test cases for MentorController as needed
}
