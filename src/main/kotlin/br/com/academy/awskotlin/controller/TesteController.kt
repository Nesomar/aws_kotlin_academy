package br.com.academy.awskotlin.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TesteController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun test() : ResponseEntity<*> = ResponseEntity.ok("AWS-KOTLIN-UP")
}