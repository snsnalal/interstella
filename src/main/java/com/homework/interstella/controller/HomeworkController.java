package com.homework.interstella.controller;

import com.homework.interstella.dto.ResponseDto;
import com.homework.interstella.service.HomeworkService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;

    @GetMapping("/")
    public String printHello(Model model){
        model.addAttribute("hello", "hello world!");
        return "hello";
    }
    @GetMapping("/main")
    public String printMain(){

        return "index";
    }

    @PostMapping("/main")
    public ResponseEntity<String> calcChange(@RequestBody @Valid ResponseDto responseDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
        }

        int num = homeworkService.calcProblem2(responseDto);

        return ResponseEntity.ok("총 " + num + "가지 입니다.");
    }
}
