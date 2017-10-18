/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/*
 * Find PI to the Nth Digit - Enter a number and have the program 
 * generate PI up to that many decimal places. Keep a limit to how far 
 * the program will go.
 * 
 * @author lynese
 */

import java.util.*;
import java.math.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileExample1 {

	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter L = null;


/** calculate pi using Spigout algorithm*/
class PiSpigout2 {
	private int reminders[]; //special array required for calculation
	private int piDigits[]; //result array
	private int remSize; //size of reminders array
	private int digits;
	private int tempInvalid = 0; //counter for temporary invalid digits
	

    
	/**Realization of spigout algorighm: explanation =
	 * http://cut-the-knot.org/Curriculum/Algorithms/SpigotForPi.shtml
	 */
	private void calc(){
		int carryOver = 0;

		//main iteration
		for(int i=0; i<digits; i++)
		{//next number calculation
			int sum = 0;
			for(int k=remSize-1; k>0; k--)
			{
				sum = reminders[k]*10 + carryOver;
				carryOver = (sum /(2*k +1)) * k;
				reminders[k] = sum % (2*k+1);
			}		
			//last step: k=0
			sum = reminders[0]*10 + carryOver;
			int nextNumber = sum / 10; //calculated i-th number of pi
			reminders[0] = sum % 10;
			nextNumber = invalidDigitsControl(nextNumber, i);
			piDigits[i] = nextNumber; //write new digit to result
		}
	}
	
	/**
	 * aux function for algorithm
	 */
	private int invalidDigitsControl(int nextNumber, int position) {
		if (nextNumber == 9) {
			tempInvalid++;
			return 9;
		}
		
		if(nextNumber == 10)
		{
			for(int h = position-tempInvalid; h<position; h++)
			{
				if (piDigits[h] == 9)
					piDigits[h] = 0;
				else
					piDigits[h]+=1;
			}			
			tempInvalid = 1;
			return 0;
		} 
		
		tempInvalid=1;
		return nextNumber;
	}
	
	public PiSpigout2(int digits){
		this.digits=digits;
		
		remSize = 10*digits/3;
		reminders = new int[remSize];
		piDigits = new int[digits];
		
		Arrays.fill(reminders,2); //data initialization	
		calc();
	}
	
	public void print() {
		System.out.print("3.");
		for(int i = 1; i<piDigits.length; i++)
			System.out.print( Integer.toString(piDigits[i]));
		System.out.println();
	}
}




class PiCalculator2 {
	
	public static void main(String args[]) throws IOException
             
	{
		System.out.println("How many digits of pi do you want see?:");
		
		int userAns = 20;
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			userAns = Integer.parseInt(in.readLine());
		}
                
		new PiSpigout2(userAns).print();
	}
	
}
L = new FileWriter(FILENAME);
			bw = new BufferedWriter(L);
			bw.write(Integer.toString(piDigits[i]));

			

		} catch (IOException e) {
		} finally {

			try {

				if (bw != null)
					bw.close();

				if (L != null)
					L.close();

			} catch (IOException ex) {
			}
}}} }




