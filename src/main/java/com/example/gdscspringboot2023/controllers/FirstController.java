package com.example.gdscspringboot2023.controllers;

import com.example.gdscspringboot2023.dtos.Test;
import com.example.gdscspringboot2023.services.FirstService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class FirstController {

    @Autowired
    private FirstService firstService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Integer id) {
        return ResponseEntity.ok(id);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody final Test test) {
        return ResponseEntity.ok(test.getTest1());
    }

    @PutMapping
    public ResponseEntity<?> put(@PathParam(value = "q2") final Integer q1,
                                 @PathParam(value = "q2") final String q2) {
        final int a = 2;
        return ResponseEntity.ok(q1);
    }

    @DeleteMapping
    public void delete() {
        firstService.t1();
    }
}
