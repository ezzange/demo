package com.example.demo.bean;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    //스프링 컨테이너 생성
    public AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    //애너페이션기반매플리케이션설정정보


    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean(){
        //beanDefinition : 빈에 대한 하나 하나의 메타데이션 정보들
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //빈으로 정의된 이름을 다 등록
        //iter + teb = 리스트나 배열이 있을때 자동으로 포문 작성
        for (String beanDefinitionName : beanDefinitionNames) {
            //ApplicationContext에서 bean을 꺼내기( beanDefinitionNames에 정의된 bean을 가져오기 )
            Object bean = ac.getBean(beanDefinitionName);
            //soutv : 변수명 출력
            //soutm : 메서드 출력
            System.out.println("name = "+ beanDefinitionName + "| Object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //등록된 빈의 네임을 문자열 배열로 반환
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //.ROLE_APPLICATION : 애플리케이션을 개발하기 위해 등록한 빈 혹은 외부 라이브러리
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Appname = " + beanDefinitionName + "Object = "+bean);
            }
        }
    }
}