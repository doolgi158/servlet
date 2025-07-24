package com.example;

public class Calc {
	// 계산 결과 보관을 위한 변수로 초기값을 0으로 설정 함.
	private int result;
	
	public Calc() {
		result = 0;
	}
	
	public Calc(int num1, int num2, String op) {
		calculate(num1, num2, op);
	}
	
	public void calculate(int num1, int num2, String op) {
		switch (op) {
			case "+" -> result = num1 + num2;
			case "-" -> result = num1 - num2;
			case "*" -> result = num1 * num2;
			case "/" -> result = num1 / num2;
		}
	}
	
	public int getResult() {
		return result;
	}
}
