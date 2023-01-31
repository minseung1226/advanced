package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class TemplateCallBbackTest {

    @Test
    void callbackV1(){
        TimeLogTemplate template=new TimeLogTemplate();

        template.execute(()->log.info("비즈니스 로직 1 실행"));
        template.execute(()->log.info("비즈니스 로직 2 실행"));
    }
}
