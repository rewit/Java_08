package com.biz.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.exec.model.PayMentVO;

public class PayExec_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
		
		System.out.println("급여금액>>");
		String strPay =scan.nextLine();
		int intPay = Integer.valueOf(strPay);
		
		//총 급여를 임시로 다른 변수에 대입해두고
		//출력할때 사용할 예정
		int intMyPay = intPay;
		
		List<PayMentVO> paperList = new ArrayList<PayMentVO>();
		
		int intMoney = 50000;
		int sw = 1;
		while(intMoney > 5) {
			PayMentVO payVO = new PayMentVO();//
			int intPaper = (int)(intPay / intMoney); //액면가에 대한 화폐매수
			
			payVO.intMoney = intMoney; //setter를 사용하지만 변수를 public으로 선언했기 때문에 직접 대입이 가능하다
			payVO.paper = intPaper;
			paperList.add(payVO);
			
			intPay -= (intMoney * intPaper);// 액면가를 제외한 급여금액 생성
			
//			if(sw>0) intMoney = intMoney / 5 ;
//			else intMoney = intMoney / 2 ;

			if(sw > 0 ) intMoney /= 5;
			else intMoney /= 2;
			
//			sw = sw * (-1);
			sw *= (-1);
			//List 생성
		}
		//총 급여액을 다시 계산하는 방법
		int intTotalPay = 0;
		for(PayMentVO vo : paperList) {
			intTotalPay += (vo.intMoney * vo.paper);
		}
		
			System.out.println("============================================");
			System.out.println("총 급여 : "+ intTotalPay);
			System.out.println("--------------------------------------------");
			System.out.println("액면가\t\t매수");
			System.out.println("--------------------------------------------");
			
			for(PayMentVO vo : paperList) {
				System.out.printf("%7d\t\t%3d\n",vo.intMoney,vo.paper); //변수를 public으로 사용해서 직접사용 가능
			}
			System.out.println("============================================");
		
	}

}
