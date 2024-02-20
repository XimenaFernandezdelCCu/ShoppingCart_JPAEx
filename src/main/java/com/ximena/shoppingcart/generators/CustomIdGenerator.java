package com.ximena.shoppingcart.generators;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {
		
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		Random random = null;
		int id = 0; 
		random = new Random();
		id = random.nextInt(10000);
		BigDecimal idBigDecimal = new BigDecimal(id);
		
        return idBigDecimal;
	}

}
