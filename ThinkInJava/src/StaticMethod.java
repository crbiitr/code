class Student {
int a; //initialized to zero
static int b; //initialized to zero only when class is loaded not for each object created.
 
  Student(){
   //Constructor incrementing static variable b
   b++;
  }
 
   public void showData(){
      System.out.println("Value of a = "+a);
      System.out.println("Value of b = "+b);
   }
	/*public static void increment()
	{
		a++;//Cannot make a static reference to the non-static field a
	}*/
}
 
class StaticMethod{
   public static void main(String args[]){
	//     Student s1 = new Student();
	//     s1.showData();
	//     Student s2 = new Student();
	//     s2.showData();
	//     Student.b++;
	//     s1.showData();
	//     
	//     String str = "[{\"url\" : \"http://ads.huntmad.com/1/redir/ad7df941-80e0-11e2-947d-001b21ccdb21/0/139494\",\"img\" : \"http://img.ads.huntmad.com/img/4f6/345/c8115c2/image_216x36.gif\",\"type\": \"image/gif\",\"track\" : \"\"}];";
	//     String st = "chetan\"";
	//     System.out.println(str + "       "+str.length());
	//     str = str.substring(1, str.length()-2);
	//     System.out.println(str + "       "+str.length());
	   String strin[] = {"chetan","raj","bharti"};
	   for(int i=0;i<strin.length;i++){
		   //System.out.println("   " + strin[i]);
	   }
	   
	   Test t = new Test("good");
	   //this.check(strin);
	   System.out.println("after calling change function");
	   for(int i=0;i<strin.length;i++){
		   //System.out.println("   " + strin[i]);
	   }
  }
   public void check(String s[]){
	   s[0] = "Ratan";
   }
   
}

