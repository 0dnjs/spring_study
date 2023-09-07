package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController // restcontroller이면 무조건 데이터 응답
public class RespStudyseController {

    @GetMapping("/resp/str")
    public String strTest() {
        return "문자열";
    }
    
    @GetMapping("/resp/obj")
    public Object objectTest() {
        Map<String, Object> responseMap = new HashMap<>();
        return responseMap; // JSON으로 응답
    }

    @GetMapping("/resp/obj2")
    public Object objectTest2() {
       JsonTestDto jsonTestDto = new JsonTestDto();
       jsonTestDto.setName("김준일");
       jsonTestDto.setAge(30);
        return jsonTestDto; // JSON으로 응답
    }

    @GetMapping("/resp/status")
    public Object statusTest(HttpServletResponse response) {
        response.setStatus(400);
        return null;
    }

    @GetMapping("/resp/resp-entity")
    public ResponseEntity<?> responseEntityTest() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        return new ResponseEntity<JsonTestDto>(jsonTestDto, HttpStatus.UNAUTHORIZED);
        // <> 안에 응답할 데이터타입을 적어줌
    }

    public ResponseEntity<Map<String, Object>> mapResponseEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "데이터입니다.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<JsonTestDto> jsonResponse() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("김준일");
        jsonTestDto.setAge(30);
        // 방법이 여러가지임
//        return ResponseEntity.ok().body(jsonTestDto);
//        return ResponseEntity.badRequest().body(jsonTestDto);
//        return ResponseEntity.status(405).body(jsonTestDto);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonTestDto);

    }
}