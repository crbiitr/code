package com.java.testing;

/**
 * Created by user on 9/1/16.
 */
public class SuperPower {
    public static void main(String[] args) {


//        for(int i=2;i<10000;i++)
//            test_if_power(i);

    }

    static int gcd(int a,int b){
        if(a<b){
            int t=a;a=b;b=t;
        }
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

/*
    static int test_if_power(int n){
        boolean flag=true;
        int t=n;
        int curr_gcd=Integer.MAX_VALUE;
        // if n==1 then it can't be expresses as x^y for y>1
        if(n==1)
            flag=false;
        if(n%2==0){
            int p=0;
            while(n%2==0)
            {
                n=n/2;
                p++;
            }
            // find the power of 2 in the prime factorization of n
            if(p==1)
                flag=false;
            if(curr_gcd== Integer.MAX_VALUE)
                curr_gcd=p;
        }

        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0){
                int p=0;
                while(n%i==0){
                    n/=i;
                    p++;
                }
                // if for any prime factor p the power is 1 then n can not be expressed as x^y
                if(p==1)
                    flag=false;
                // if i is the first prime factor of p then set the gcd to power of i;
                if(curr_gcd== Integer.MAX_VALUE)
                    curr_gcd=p;
                else
                    curr_gcd=gcd(p,curr_gcd);
                //find the gcd of curr_gcd and the power of prime factor i;

            }
        }
        if(n>2){
            flag=false;
        }
        if(!flag){
            // return in case flag is false or curr_gc is 1;
            return 0;
        }
//        if(curr_gcd!=1)
//            cout<<t<<" ";
    }*/
}




