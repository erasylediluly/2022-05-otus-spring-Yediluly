package kz.yyediluly;


import kz.yyediluly.domain.Question;
import kz.yyediluly.service.QuestionService;
import kz.yyediluly.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Main.class);
        QuestionService service = annotationConfigApplicationContext.getBean(QuestionService.class);
        service.runService();

    }
}
