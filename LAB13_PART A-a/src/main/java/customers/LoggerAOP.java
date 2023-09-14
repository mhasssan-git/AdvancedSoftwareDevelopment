package customers;

import customers.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggerAOP {
    public LoggerAOP(ILogger logger) {
        this.logger = logger;
    }

    @Autowired
    ILogger logger;

    @After("execution(* *.EmailSender.sendEmail(..))")
    public void AfterSavingCustomer(JoinPoint jp) {
        Object[] args = jp.getArgs();
        logger.log(String.format("method=%s", jp.getSignature().getName()));
    }
}
