package com.props.ocean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.props.ocean.model.Prop;
import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PropControllerTest.class)
public class PropControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testPropInit() throws Exception {
        Prop pq = new Prop();
        pq.setX(1);
        pq.setY(0);
        pq.setDirection("SOUTH");


        mockMvc.perform(post("prop/init")
                .contentType("applicatin/json")
                .content(objectMapper.writeValueAsString(pq)))
                .andExpect(status().isOk())
                .andExpect(content().string("current position : (1 ,2) direction is SOUTH"));


    }
}
