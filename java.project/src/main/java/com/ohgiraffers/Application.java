package com.ohgiraffers;

import com.repository.OfferRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        OfferRepository offerRepository = new OfferRepository();

        while(true) {
            /* 로그인 기능 : 상현이 형 */
            System.out.println("==== HR 대행 프로그램 ====");
            System.out.println(" 1. 모든 오퍼리스트 조회 "); // 2 상현이 형
            System.out.println(" 2. 오퍼 정보 조회 ");// 3 진석
            System.out.println(" 3. 오퍼 등록 ");// 4 윤후 형
            System.out.println(" 4. 오퍼 수정 "); // 5 윤후 형
            System.out.println(" 5. 오퍼 삭제"); // 6 진석
            System.out.println(" 9. 프로그램 종료");
            System.out.println(" 서비스 선택 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 9: break;

            }


        }

    }
}
