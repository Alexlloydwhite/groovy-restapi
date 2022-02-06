package com.restapi.todolist.controller

import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.web.bind.annotation.RestController
import spock.lang.Specification
import spock.lang.Subject

class TodoListControllerSpec extends Specification {

    @Subject
    TodoListController sut = new TodoListController()

    MockMvc mvc = standaloneSetup(sut).setControllerAdvice().build()

    def "Autowired Correctly"() {
        expect:
        TodoListController.getAnnotation(RestController)
    }

    def "getTodos returns list of todos"() {
        given:
        String expected = "The list of todos"

        when:
        def response = mvc.perform(get("/todos")).andReturn().response

        then:
        response.status == 200
        response.contentAsString == expected
    }
}
