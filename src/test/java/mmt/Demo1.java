package mmt;

import org.testng.annotations.Test;

public class Demo1 {
public static void main(String args[]){
  System.out.println("Hiii");
  int i=10; 
  int j=15;
  int k=150;
  Demo1 d1 = new Demo1();
  d1.add(i, j);
  
  d1.mul(i,k);
  d1.sub(k, j);
}
public void add(int i, int j) {
	int k;
	k=i+j;
	System.out.println(k/0);
}

public void sub(int i, int j) {
	int k;
	k=i-j;
	System.out.println(k/0);
}

public void mul(int i, int j) {
	int k;
	k=i*j;
	System.out.println(k/0);
}
}
