package com.kotline.Intranet.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
@Controller
class MainController {

    @GetMapping("/")
    fun index(model: Model): String {
        model["title"] = "Hello world !"
        return "template/index"
    }

    @GetMapping("/home")
    fun home(model : Model): String{
        return "lol"
    }




}