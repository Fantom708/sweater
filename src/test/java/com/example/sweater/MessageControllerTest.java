package com.example.sweater;

import com.example.sweater.controller.MessageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@WithUserDetails("testuser")
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql", "/messages-list-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/messages-list-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageController controller;


    @Test
    public void loadControllerTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void mainPageTest() throws Exception {
        this.mockMvc.perform(get("/main"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='navbarSupportedContent']/div").string("testuser"));
    }

    @Test
    public void messageListTest() throws Exception {
        this.mockMvc.perform(get("/main"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='message-list']/div").nodeCount(4));
    }

    @Test
    public void filterMessageTest() throws Exception {
        this.mockMvc.perform(get("/main").param("filterTag", "my-tag"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='message-list']/div").nodeCount(2))
                .andExpect(xpath("//div[@id='message-list']/div[@data-id=1]").exists())
                .andExpect(xpath("//div[@id='message-list']/div[@data-id=3]").exists());
    }

    @Test
    public void addMessageToListTest() throws Exception {
        MockHttpServletRequestBuilder multipart = multipart("/main")
                .file("file", "123".getBytes())
                .param("text", "fifth")
                .param("tag", "new one")
                .with(csrf());

        this.mockMvc.perform(multipart)
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='message-list']/div").nodeCount(5))
                .andExpect(xpath("//div[@id='message-list']/div[@data-id='10']").exists())
                .andExpect(xpath("//div[@id='message-list']/div[@data-id='10']/div/span").string("fifth"))
                .andExpect(xpath("//div[@id='message-list']/div[@data-id='10']/div/b").string("#new one"));
    }

}
