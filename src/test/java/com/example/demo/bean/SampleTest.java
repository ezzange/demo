package com.example.demo.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class SampleTest {
    public AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    public void testAllBeanList() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean =ac.getBean(beanDefinitionName);
            System.out.println("name = "+ beanDefinitionName + " | Object = " + bean);
        }

    }
    @Test
    public void testAppBeanList(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("내가 등록한 bean = " + beanName);
            }
        }
    }


}

