package com.restapi.todolist.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoListController {

    @GetMapping(path = "/todos")
    static String getTodos() {
        return "The list of todos"
    }
}
