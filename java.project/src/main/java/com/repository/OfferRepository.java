package com.repository;

import com.ohgiraffers.OfferInfo;

import java.io.*;
import java.util.ArrayList;

public class OfferRepository {

    private final ArrayList<OfferInfo> offerList = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/com/ohgiraffers/db/offerDB.dat";

    public OfferRepository() {
        File file = new File(FILE_PATH);

        if(!file.exists()){
            ArrayList<OfferInfo> offerInfos = new ArrayList<>();
            offerInfos.add(new OfferInfo("삼성전자", "기술마케팅", "기흥화성", 50000000, "기술 마케팅 활동", new String[] {"사내 병원", "사내 뷔폐식당", "어디든 셔틀버스(150노선)", "계열사 리조트", "병원비", "통신비", "거주비 지원", "교육비 지원", "사택 지원", "자기개발비 지원", "사내 동아리", "자녀 학자금 지원", "복지포인트 200만원"}, 1));
            offerInfos.add(new OfferInfo("SK하이닉스", "공정기술", "이천", 56000000, "공정 수율 개선", new String[] {"연 2회 성과급", "병원비 지원", "통신비 지원", "거주비 지원", "교육비 지원", "사택 지원", "자기개발비 지원", "사내 동아리", "자녀 학자금 지원", "복지포인트 200만원"}, 2));
            offerInfos.add(new OfferInfo("DB하이텍", "공정설계", "부천", 45000000, "공정 설계 활동", new String[] {"중/석식 지원", "교통비 지원","자기개발비 지원", "사내 동아리", "통신비 지원", "자녀 학자금 지원", "복지포인트 200만원"}, 3));
            offerInfos.add(new OfferInfo("네이버", "프론트엔드 개발자", "판교", 45000000, "프론트엔드 관리", new String[] {"중/석식 지원", "교통비 지원", "자기개발비 지원", "사내 동아리", "통신비 지원", "자녀 학자금 지원", "복지포인트 300만원", "개인 장비 지원"}, 4));
            offerInfos.add(new OfferInfo("카카오", "백엔드 개발자", "판교", 45000000, "백엔드 관리", new String[] {"중/석식 지원", "교통비 지원", "자기개발비 지원", "사내 동아리", "통신비 지원", "자녀 학자금 지원", "복지포인트 200만원"}, 5));
            saveUsers(file, offerInfos);
        }
    }

    private void loadUsers(File file) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            while(true){
                offerList.add((OfferInfo)ois.readObject());
            }
        } catch(EOFException e){
            System.out.println("기업 정보를 모두 로딩하였습니다.");
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void saveUsers(File file, ArrayList<OfferInfo> offerInfos) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            for(OfferInfo offerinfo : offerInfos){
                oos.writeObject(offerinfo);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
