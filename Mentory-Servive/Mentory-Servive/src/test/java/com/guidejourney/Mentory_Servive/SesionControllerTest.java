package com.example.mentoring;

import com.example.mentoring.controller.SessionController;
import com.example.mentoring.model.dto.SessionDTO;
import com.example.mentoring.service.SessionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SessionControllerTest {

    @InjectMocks
    SessionController sessionController;

    @Mock
    SessionService sessionService;

    @Test
    public void testGetAllSessions() {
        MockitoAnnotations.openMocks(this);
        when(sessionService.getAllSessions()).thenReturn(Collections.singletonList(new SessionDTO()));
        List<SessionDTO> result = sessionController.getAllSessions();
        assertEquals(1, result.size());
    }

    @Test
    public void testGetSessionById() {
        MockitoAnnotations.openMocks(this);
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(1L);
        when(sessionService.getSessionById(1L)).thenReturn(sessionDTO);
        ResponseEntity<SessionDTO> result = sessionController.getSessionById(1L);
        assertEquals(1L, result.getBody().getId());
    }
}
