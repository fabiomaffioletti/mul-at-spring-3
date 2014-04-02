package com.fm.atomikos.jms;

import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:spring-context.xml" })
public class MyJMSProducerTest {

	@Autowired
	private TransactionalJmsProducer jmsProducer;
	
	@Test
	public void testProduce() throws JMSException {
//		jmsProducer.sendMessage("testMessage");
	}
	
}
