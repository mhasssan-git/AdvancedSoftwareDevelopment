package bank.proxy;

import bank.utility.StopWatch;

import java.lang.reflect.*;

public class StopWatchProxy implements InvocationHandler {
    private Object target;

    public StopWatchProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Object returnValue=method.invoke(target,args);
        stopWatch.stop();
        System.out.println("The method " + method.getName() + " took " + stopWatch.getMillis() + " ms");
        return returnValue;
    }
}
