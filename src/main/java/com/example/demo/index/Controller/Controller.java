package com.example.demo.index.Controller;

import com.example.demo.index.entity.Entity;
import com.example.demo.index.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {

    private final Service Service;

    //localhost:8080으로 접속하면 Hello world 가 보임.
    @GetMapping
           //HttpStatusCode 상태 코드를 추가해서 MVC의 @Controller 메서드의 반환 해주는 클래스
    public ResponseEntity<?> home() {
                    //제네릭타입 와일드카드<?>
        String hello = "Hello World";
        //스트링 타입의 hello는 hello pig이다.
        return ResponseEntity.ok(hello);
    }           //정상적인 요청이 처리되면 hello를 컨트롤러에 반환해주는 메서드.

    @GetMapping("/{id}")//id 값으로
    public ResponseEntity<?> findHome(
            @PathVariable Long id
    ) {//홈클래스타입의 참조변수home은 서비스의 findHome메서드로 id값을 받는다.
        Entity home = Service.findHome(id);
        return ResponseEntity.ok(home); //받은 id가 정상적인 요청일 경우 컨트롤러에 반환.
    }

}
