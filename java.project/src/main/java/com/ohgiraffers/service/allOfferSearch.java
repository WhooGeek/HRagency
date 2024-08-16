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
            for (OfferInfo offer : offerList) {
                System.out.println(offer);
            }
        }
    }
}

