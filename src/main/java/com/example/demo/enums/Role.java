package com.example.demo.enums;

public enum Role {
	ROLE_USER("user"), ROLE_ADMIN("admin"), ROLE_SUPER_ADMIN("super_admin");

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private Role(String key) {
		this.key = key;
	}

}
