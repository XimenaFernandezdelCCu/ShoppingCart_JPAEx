package com.ximena.shoppingcart.generators;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {
	
	//private final AtomicInteger lastGeneratedId = new AtomicInteger(0);
	private BigDecimal lastGeneratedId = BigDecimal.ZERO;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		lastGeneratedId = lastGeneratedId.add(BigDecimal.ONE);
        return lastGeneratedId;
	}

}
