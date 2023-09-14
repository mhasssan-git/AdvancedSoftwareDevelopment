package customers.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@Configuration
@Aspect
public class StopwatchAspect {
    @Around("execution(* *.*DAO.*(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println(String.format("Execution time for method %s is : %s"
                ,call.getTarget().getClass().getName()+"."+call.getSignature().getName()
                        ,formatMillis(totaltime)));

        return retVal;
    }

    private String formatMillis(long millis) {
        return String.format("%02d:%02d:%02d.%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                millis%1000);
    }
}