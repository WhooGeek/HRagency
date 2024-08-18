package com.ohgiraffers.run;

import com.ohgiraffers.Login.Login;
import com.ohgiraffers.service.allOfferSearch;
import com.ohgiraffers.service.OfferRegistService;
import com.ohgiraffers.aggregate.OfferInfo;


import java.util.Scanner;

public class Application {
    public static final allOfferSearch offerFindService = new allOfferSearch();
    public static final OfferRegistService offerRegistService = new OfferRegistService();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        boolean certify = false;

        while (!certify) {
            System.out.print("아이디를 입력하세요: ");
            String username = scanner.nextLine();

            System.out.print("비밀번호를 입력하세요: ");
            String password = scanner.nextLine();  // 로그인 화면


            if (login.validLogin(username, password)) {
                certify = true;
                System.out.println("로그인에 성공했습니다.");
            } else {
                System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도하세요.");
            }
        } // login 클래스에서 로그인 하는 화면
          // 상현 구현 완료


        while(true) {
            /* 로그인 기능 : 상현이 형 */
            System.out.println("==== HR 대행 프로그램 ====");
            System.out.println(" 1. 모든 오퍼리스트 조회 "); // 2 상현이 형 구현 완료
            System.out.println(" 2. 오퍼 정보 조회 ");// 3 진석
            System.out.println(" 3. 오퍼 등록 ");// 4 윤후 형
            System.out.println(" 4. 오퍼 수정 "); // 5 윤후 형
            System.out.println(" 5. 오퍼 삭제"); // 6 진석
            System.out.println(" 9. 프로그램 종료");
            System.out.println(" 서비스 선택 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    allOfferSearch.displayAllOffers();
                    break;
                case 2:
                    allOfferSearch.findOfferByJobCode(chooseNo());
                    break;
                case 3:
                    OfferRegistService.registOffer(signUp());
                    break; // 내가 할 것
                case 4:
                    OfferInfo selected = OfferRegistService.findOfferForModify(chooseName());
                    if(selected == null) continue;
                    OfferRegistService.modifyOffer(reform(selected));
                    break; // 내가 할 것
                case 5: allOfferSearch.removeOffer(chooseNo()); break;
                case 9:
                    System.out.println("프로그램이 종료됩니다. ");
                    return;
            }
        }
    }

    private static OfferInfo reform(OfferInfo selected) {
        OfferInfo modifiedOffer = selected;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("====== 수정 서브 메뉴 ========");
            System.out.println("1. 직무");
            System.out.println("2. 근무지");
            System.out.println("3. 연봉");
            System.out.println("4. 업무내용");
            System.out.println("5. 복리후생");
            System.out.println("6. JobCode");
            int chooseNo = sc.nextInt();
            sc.nextLine();
            switch (chooseNo){
                case 1:
                    System.out.println("수정할 직무를 적어주세요");
                    modifiedOffer.setPosition(sc.nextLine());
                    break;
                case 2:
                    System.out.println("수정할 근무지를 적어주세요");
                    modifiedOffer.setLocation(sc.nextLine());
                    break;
                case 3:
                    System.out.println("수정할 연봉을 적어주세요");
                    modifiedOffer.setSalary(sc.nextInt());
                    break;
                case 4:
                    System.out.println("수정할 업무 내용을 적어주세요");
                    modifiedOffer.setJobDescription(sc.nextLine());
                    break;
                case 5:
                    System.out.println("수정할 복리후생을 적어주세요");
                    modifiedOffer.setWelfare(resetWelfare());
                    break;
                case 6:
                    System.out.println("수정할 JobCode를 적어주세요");
                    modifiedOffer.setJobCode(sc.nextInt());
                    break;
                default:
                    System.out.println("다시 입력해주세요");

            }
            return modifiedOffer;
        }

    }

    private static String[] resetWelfare() {
        Scanner welFare = new Scanner(System.in);

        System.out.print("재 작성할 복리후생의 개수를 적어주세요 : ");
        int length = welFare.nextInt();
        welFare.nextLine();

        String[] WelFare = new String[length];
        for(int i = 0; i < WelFare.length; i++){
            System.out.print((i+1) + "번째 복리후생을 입력해주세요 : ");
            String input = welFare.nextLine();
            WelFare[i] = input;
        }

        return WelFare;
    }

    private static String chooseName() {
        Scanner name = new Scanner(System.in);
        System.out.print("chooseName 회사명을 입력해주세요 : ");
        return name.nextLine();
    }


    private static int chooseNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("job code input : ");
        return scanner.nextInt();
    }

    private static OfferInfo signUp() {
        OfferInfo newOffer = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("회사명을 입려하세요 : ");
        String companyName = sc.nextLine();

        System.out.print("직무를 입력하세요 : ");
        String position = sc.nextLine();

        System.out.print("근무지를 입력하세요 : ");
        String location = sc.nextLine();

        System.out.print("급여를 입력하세요 :");
        int salary = sc.nextInt();

        sc.nextLine();
        System.out.print("업무 내용을 입력하세요 : ");
        String jobDescription = sc.nextLine();

        System.out.print("입력할 복리후생의 개수를 입력하세요(숫자로 1 이상) : ");
        int length = sc.nextInt();
//        sc.nextInt(); // 버퍼 개행문자 처리용

        String[] welfare = new String[length];
        for(int i = 0; i < welfare.length ; i++){
            System.out.print((i+1) + "번째 복리후생을 입력하세요 : ");
            String input = sc.next();
            welfare[i] = input;
        }

        int jobCode = 0;
        System.out.println("마지막으로, 직업 분류를 입력해주세요!");
        System.out.println("1. 마케팅");
        System.out.println("2. 공정기술");
        System.out.println("3. 공정설계");
        System.out.println("4. 프론트엔드 개발자");
        System.out.println("5. 백엔드 개발자");
        System.out.println("6. 클라우드 엔지니어");
        System.out.println("7. DBA");
        System.out.println("8. 영업");
        System.out.println("9. 인사");
        System.out.println("10. 총무");
        System.out.print("번호를 입력해주세요 : ");

        int jbCode = sc.nextInt();
        while(true){
            if(jbCode >= 11 || jbCode <= 0){
                System.out.println("잘못 입력하셨습니다 다시 입력해주세요");
            }else{
                jobCode = jbCode;
                break;
            }
        }

        newOffer = new OfferInfo(companyName, position, location, salary, jobDescription, welfare, jobCode);

        return newOffer;

    }
}
