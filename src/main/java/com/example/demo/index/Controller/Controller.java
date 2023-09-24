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

    //localhost:8080으로 접속하면 정상적인 요청일 경우 hello를 응답데이터로 반환해서 Hello world가 출력되는 컨트롤러.
    @GetMapping
           //HttpStatusCode 상태 코드를 추가해서 MVC의 @Controller 메서드의 반환 해주는 클래스
    public ResponseEntity<?> home() {
                    //제네릭타입 와일드카드<?>
        String hello = "Hello World";
        //"Hello World"를 스트링 타입의 hello 에 대입한다.
        return ResponseEntity.ok(hello);
    }

    //받은 id가 정상적인 요청일 경우 엔티티타입으로 반환 해주는 컨트롤러
    @GetMapping("/{id}")//id 값으로
    public ResponseEntity<?> findHome(
            @PathVariable Long id
    ) {//엔티티타입의 참조변수home은 서비스의 findHome메서드로 id값을 받는다.
        Entity home = Service.findHome(id);
        return ResponseEntity.ok(home); //찾아온 id가 정상적인 요청일 경우 home을 응답데이터로 반환.
    }

    //keyword?str=Hello 경로로 조회시 쿼리 파라미터 Hello 출력
    @GetMapping("/keyword")
    public ResponseEntity<String> handleKeywordRequest(@RequestParam String str) {
        return ResponseEntity.ok("쿼리 파라미터 : " + str);
    }
    //content?str=wo 경로로 조회시 쿼리 파라미터 Hello출력
    @GetMapping("/content")
    public ResponseEntity<String> handleStringRequest(@RequestParam String str) {
        return ResponseEntity.ok("Query parameter : " + str);
    }
    //id?id=1 경로로 조회시 쿼리 파라미터 1 출력
    @GetMapping("/id")
    public ResponseEntity<String> handleStringRequest(@RequestParam Long id) {
        return ResponseEntity.ok("Query parameter : " + id);
    }

    //create?content=hi로 검색 하면 해당 파라미터를 받아 엔티티에 저장하는 컨트롤러
    @GetMapping("create")
    public ResponseEntity<?> createData(@RequestParam String content){
        Entity home = Service.createHome(content);
        Long id = home.getId();
        String str = home.getContent();
        return ResponseEntity.ok("id : "+id + " content : "+str+"로 저장되었습니다.");
    }

}
