package com.lefthand.comm.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class LogForDaoAndServiceAOP {

	private static Log logger = LogFactory.getLog(LogForDaoAndServiceAOP.class);
	
	//@Around("execution(public * gzrd.dzgw..*.dao.*.*(..)) or execution(public * gzrd.dzgw..*.service.*.*(..))")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		long startTime = System.currentTimeMillis();
		String classSign = pjp.getTarget().getClass() + "." + pjp.getSignature().getName();
		classSign = classSign.substring(6);
		//System.out.println("执行方法开始 : " + classSign + "(...) start time: " + startTime);
        logger.warn("执行方法开始 : " + pjp.getTarget().getClass() + "." + pjp.getSignature().getName() + "(...) start time: " + startTime);

        Object object=pjp.proceed();
        
        logger.warn("执行方法结束 : " + pjp.getTarget().getClass() + "." + pjp.getSignature().getName() + "(...) end time: " + startTime + " 用时:" + (System.currentTimeMillis() - startTime) + "毫秒");
        //System.out.println("执行方法结束 : " + classSign + "(...) end time: " + startTime + " 用时:" + (System.currentTimeMillis() - startTime) + "毫秒");
        return object;//这是被代理方法的返回值,一定要有,要不会报空指针
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
