package com.tiwari.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	
	private String message;
	private String module;
	private String date;
	private String code;

}
