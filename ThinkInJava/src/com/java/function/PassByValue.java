package com.java.function;

class shap {
	private int l,b,h;
	shap() {
		l=0;
		b=0;
		h=0;
		}
	
	shap(int s) {
		l=b=h=s;
		}
	
	shap(int i, int j, int k) {
		l=i;
		b=j;
		h=k;
		}
	
	shap(shap s) {
		l=s.l;
		b=s.b;
		h=s.h;
		}
	
	void show () {
		System.out.println(" Lenth : "+ l +" Breath : "+ b +" Height : "+ h);
	}
}

public class PassByValue {

	public static void main(String [] args) {
		
		shap s1;
		shap s2 = new shap();
		shap s3 = new shap(10);
		shap s4 = new shap(2, 5, 7);
		shap s5 = new shap(s3);
		shap s6 = s3;
		
		s2.show();
		s3.show();
		s4.show();
		s5.show();
		s6.show();
		
		System.out.println(" Address of " + s5);
	}
}
