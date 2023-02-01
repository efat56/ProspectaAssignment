package com.efat;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		csvOutput(input);
	}
	
	
	public static void csvOutput(String input) {
	
		String[] sArray = input.split(", ");
		
		if(sArray.length==0) {
			System.out.println("Invalid Input....");
			return;
		}
		
		Map<String,String> mapCells = new LinkedHashMap<>();
		
		try {
			for(String s:sArray) {
			
				String[] cellVal = s.split(": ");

				if(cellVal.length!=2) {
					System.out.println("Invalid Input....");
					return;
				}
				
				String cell = cellVal[0];
				String value = cellVal[1];
				
				
				if(isValidCell(cell)) {
					if(isNum(value)) {
						mapCells.put(cell, value);
					}else {
						if(isValidExpression(value)) {
							
							String exp = value.substring(1);
							
							String[] expArray = exp.split("[+*/-]");
							
							boolean add = false;
							
							if(exp.contains("+")) add = true;

							Integer val1 = null;
							Integer val2 = null;
							
							if(isValidCell(expArray[0])) {
								if(mapCells.containsKey(expArray[0])) {
									val1 = Integer.parseInt(mapCells.get(expArray[0]));
								}else {
									System.out.println("Invalid Input...");
									return;
								}
							}
							if(isValidCell(expArray[1])) {
								if(mapCells.containsKey(expArray[1])) {
									val2 = Integer.parseInt(mapCells.get(expArray[1]));
								}else {
									System.out.println("Invalid Input....");
									return;
								}
							}
							
				
							if(isNum(expArray[0]) && isNum(expArray[1])) {
								Integer result = null; 
								Integer n1 =  Integer.parseInt(expArray[0]);
								Integer n2 =  Integer.parseInt(expArray[1]);
								if(add) {
									result = add(n1, n2);
								}
								mapCells.put(cell, "" +result);
							}else if(val1!=null && val2 !=null){
					            Integer result = null;
					            if(add) {
									result = add(val1, val2);
								}
					            mapCells.put(cell, "" +result);
							}else if(val1!=null && val2 == null) {
								Integer result = null; 
								Integer n1 =  val1;
								Integer n2 =  Integer.parseInt(expArray[1]);
								if(add) {
									result = add(n1, n2);
								}
								mapCells.put(cell, "" +result);
							}else if(val1==null && val2 != null) {
								Integer result = null; 
								Integer n1 =  Integer.parseInt(expArray[0]);
								Integer n2 = val2;
								if(add) {
									result = add(n1, n2);
								}
								mapCells.put(cell, "" +result);
							
							}else {
								System.out.println("invalid input");
								return;
							}
						}else {
							System.out.println("Invalid Input");
							return;
						}
					}
				}else {
					System.out.println("Invalid cell=" + cell);
					return;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
			return;
		}
		System.out.println(mapCells);
	}
	
	
	

	public static boolean isValidCell(String str) {
		return Pattern.matches("^[A-Z]{1,2}[1-9]{1}[0-9]{0,4}$", str);
	}
	
	
	public static boolean isNum(String str) {
		return Pattern.matches("^[0-9]+$", str);
	}
	
	
	public static boolean isValidExpression(String str) {
		return Pattern.matches("^=[A-Z0-9]+[+*/-][A-Z0-9]+$", str);
	}
	
	public static int add(int n1,int n2) {
		return n1 + n2;
	}


}
