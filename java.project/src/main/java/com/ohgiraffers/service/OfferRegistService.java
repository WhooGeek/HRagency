package com.ohgiraffers.service;

import com.ohgiraffers.aggregate.OfferInfo;
import com.ohgiraffers.repository.OfferRepository;



public class OfferRegistService {

    public final OfferRepository offerRepository = new  OfferRepository();





    public static void registOffer(OfferInfo offerInfo){

        int result = OfferRepository.insertOffer(offerInfo);

        if(result == 1)
            System.out.println(offerInfo.getCompanyName() + " 사의 오퍼 등록이 완료되었습니다.");

    }

    public static OfferInfo findOfferForModify(String name) {
        OfferInfo selectedOffer = OfferRepository.selectOfferByName(name);
        if(selectedOffer != null){
            OfferInfo newInstance = new OfferInfo();
            newInstance.setCompanyName(selectedOffer.getCompanyName());
            newInstance.setPosition(selectedOffer.getPosition());
            newInstance.setLocation(selectedOffer.getLocation());
            newInstance.setSalary(selectedOffer.getSalary());
            newInstance.setJobDescription(selectedOffer.getJobDescription());
            newInstance.setWelfare(selectedOffer.getWelfare());
            newInstance.setJobCode(selectedOffer.getJobCode());
            return newInstance;
        }

        System.out.println("find 입력하신 회사에 해당하는 오퍼가 없습니다.");
        return null;
    }


    public static void modifyOffer(OfferInfo offer) {
        int result = OfferRepository.updateOffer(offer);

        if(result == 1){
            System.out.println("오퍼 수정이 완료되었습니다.");
        }else{
            System.out.println("moffer 입력하신 회사 이름에 해당하는 오퍼는 없습니다.");
        }


    }
}
