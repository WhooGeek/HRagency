package com.ohgiraffers.service;

import com.ohgiraffers.aggregate.OfferInfo;
import com.ohgiraffers.repository.OfferRepository;

import java.util.ArrayList;

public class allOfferSearch {

    private final OfferRepository offerRepository;

    public allOfferSearch() {
        this.offerRepository = new OfferRepository();
    }

    public static void displayAllOffers() {
        ArrayList<OfferInfo> offerList = OfferRepository.selectAllOffers();

        if (offerList.isEmpty()) {
            System.out.println("등록된 오퍼가 없습니다.");
        } else {
            System.out.println(" ==== 모든 오퍼 리스트 조회 ==== ");
            offerList.forEach(System.out::println);
        }
    }

    public static void findOfferByJobCode(int code) {
        OfferInfo selectedOffer = OfferRepository.selectOfferByJobCode(code);

        if(selectedOffer != null){
            System.out.println(selectedOffer);
        }else{
            System.out.println("해당 코드를 가진 오퍼는 없습니다.");
        }
    }

    public static void removeOffer(int no) {
        int result = OfferRepository.deleteUser(no);

        if (result == 1) {
            System.out.println("오퍼 삭제가 완료 되었습니다.");
        } else {
            System.out.println("입력하신 오퍼 번호에 해당하는 오퍼가 없습니다.");
        }
    }
}

