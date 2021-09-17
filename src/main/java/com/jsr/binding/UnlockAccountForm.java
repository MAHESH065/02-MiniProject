package com.jsr.binding;

import lombok.Data;

@Data
public class UnlockAccountForm {
	
	private String email;
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
}
