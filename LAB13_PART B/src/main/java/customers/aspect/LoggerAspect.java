package customers.aspect;
import customers.EmailSender;
import customers.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggerAspect {
    public LoggerAspect(ILogger logger) {
        this.logger = logger;
    }

    @Autowired
    ILogger logger;

    @After("execution(* *.EmailSender.sendEmail(..))")
    public void AfterSavingCustomer(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String address = args[0].toString();
        String message = args[1].toString();
        EmailSender emailSender = (EmailSender) jp.getTarget();
        logger.log(String.format("method=%s address=%s message=%s outgoing mail server = %s"
                , jp.getSignature().getName()
                , address, message
                , emailSender.getOutgoingMailServer()));
    }
}
