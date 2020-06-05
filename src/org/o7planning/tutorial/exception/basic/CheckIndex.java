package org.o7planning.tutorial.exception.basic;

public class CheckIndex {
	public static void check (int i) throws IndexException {
		if(i<0) {
			throw new MinusIndexException(i + " la chi so khong hop le") ;
		}
	}

}
