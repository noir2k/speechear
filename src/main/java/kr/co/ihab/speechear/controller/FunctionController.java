package kr.co.ihab.speechear.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(RequestMappings.FUNCTION)
public class FunctionController {
    @RequestMapping(value = "/ok")
    public ResponseEntity<String> function() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
