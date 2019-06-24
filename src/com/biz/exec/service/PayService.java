package com.biz.exec.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exec.model.PayMentVO;

public class PayService {

	//service에서 입력을 받을 때 
	
	List<PayMentVO> paperList;
	Scanner scan;
	int intPayTotal; //총급여액 계산위한

	public PayService() {
		paperList = new ArrayList<PayMentVO>();
		intPayTotal = 0;
		scan = new Scanner(System.in);
	}	
	
	public void payCalce() {
		
		System.out.println("급여액>>");
		String strPay = scan.nextLine();
		int intPay = Integer.valueOf(strPay);
		intPayTotal = intPay;//Integer.valueOf(strPay);
		
		int sw = 1;
		int intMoney = 50000;
		
		while(intPay > 1) {
			
			PayMentVO vo = new PayMentVO();
			
			int intPaper = (int)(intPay / intMoney); //앞의 (int)는 생략해도 됨  intPaper가 int이기 때문에 (명시적 코딩 : 확실하게 하기 위해)
			
			vo.intMoney = intMoney;
			vo.paper = intPaper;
			
			paperList.add(vo);
			
			intPay -= (intPaper * intMoney);
			
			if(sw > 0) intMoney /= 5;
			else intMoney /= 2;
			sw *= (-1);
		}
		
	}
	
	
	public void printReport(String payReport) throws IOException {
	

	
			FileWriter fileWriter = new FileWriter(payReport);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println("============================================");
			printWriter.println("총 급여 : "+ intPayTotal);
			printWriter.println("--------------------------------------------");
			printWriter.println("액면가\t\t매수");
			printWriter.println("--------------------------------------------");
			
			for(PayMentVO vo : paperList) {
				printWriter.printf("%7d\t\t%3d\n",vo.intMoney,vo.paper); //변수를 public으로 사용해서 직접사용 가능
			}
			printWriter.println("============================================");
			printWriter.flush();
			printWriter.close();
			
			
			System.out.println("급여명세서 파일 저장 완료");
			
			

	}
	
	
}
