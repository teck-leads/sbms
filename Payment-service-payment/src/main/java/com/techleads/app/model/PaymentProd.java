package com.techleads.app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProd {

	private Integer pid;
	private String paymentName;
	private Date paymentDate;
	
}
