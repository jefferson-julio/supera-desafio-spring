package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.banco.service.TransactionService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void testSearchSuccess() throws Exception {
        mockMvc.perform(get("/transaction/search"))
            .andExpect(status().isOk());
    }

    @Test
    public void testSearchInvalidDate() throws Exception {
        mockMvc.perform(get("/transaction/search?dataTransferenciaStart=83-df-yudf"))
            .andExpect(status().isBadRequest());
    }
}
