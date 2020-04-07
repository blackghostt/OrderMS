package com.priceshoes.rest.applications.entity;

public enum MemberType {
	INACTIVE('I');

	private char memberType;

	private MemberType(char memberType) {
		this.memberType = memberType;
	}

	public static MemberType getMemberType(char name) {
		MemberType[] arg0 = values();
		int arg1 = arg0.length;

		for (int arg2 = 0; arg2 < arg1; ++arg2) {
			MemberType type = arg0[arg2];
			if (type.memberType == name) {
				return type;
			}
		}

		return null;
	}
}