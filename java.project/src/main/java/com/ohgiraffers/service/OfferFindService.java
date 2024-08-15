package com.ohgiraffers.service;

import com.ohgiraffers.aggregate.OfferInfo;
import com.ohgiraffers.repository.OfferRepository;

import java.util.ArrayList;

public class OfferFindService {

    private final OfferRepository offerRepository = new OfferRepository();

    public void findAllOffer() {
        ArrayList<OfferInfo> findOffers = offerRepository.selectAllOffers();

        for(OfferInfo offerInfo : findOffers){
            System.out.println("Offer = " + offerInfo);
        }

    }

    public void findOfferByJobCode(int code) {
        OfferInfo selectedOffer = OfferRepository.selectOfferByJobCode(code);

        if(selectedOffer != null){
            System.out.println(selectedOffer);
        }else{
            System.out.println("해당 코드를 가진 오퍼는 없습니다.");
        }

    }
}
