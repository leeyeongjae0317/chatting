package com.happy.chat.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogExecute  {
	
	public void before(JoinPoint j)
			throws Throwable {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.info("����");
		
		Object args[]=j.getArgs();
		
		if(args!=null){
			log.info("method:\t"+j.getSignature().getName());
			for (int i = 0; i < args.length; i++) {
				log.info(i+"��°:\t"+args[i]);
			}
			log.info("method:\t"+j.getSignature().getName());
		}
	}

	
	public void afterReturning(JoinPoint j) throws Throwable {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("��");
	}
	
	
	
	
	public void daoError(JoinPoint j){
		Logger log = LoggerFactory.getLogger(j.getTarget()+""+j.getKind());
		log.debug("����"+j.getArgs( ));
		log.debug("����"+j.toString());
	}
}






