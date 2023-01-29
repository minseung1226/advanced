package hello.advanced.trace.threadlocal;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private final FieldService fieldService=new FieldService();


    @Test
    void field(){
        log.info("main start");
        Runnable userA=()->{
            fieldService.login("userA");
        };
        Runnable userB=()->{
            fieldService.login("userB");
        };

        Thread threadA=new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(200);
        threadB.start();

        sleep(3000);
        log.info("main exit");

    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
