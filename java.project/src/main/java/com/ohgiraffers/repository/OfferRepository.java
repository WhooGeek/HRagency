package com.ohgiraffers.repository;

import com.ohgiraffers.Strema.MyObjectOutputStream;
import com.ohgiraffers.aggregate.OfferInfo;

import java.io.*;
import java.util.ArrayList;

public class OfferRepository {

    private static final ArrayList<OfferInfo> offerList = new ArrayList<>();
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
            saveOffers(file, offerInfos);
        }

        if(offerList.isEmpty()){
            loadUsers(file);
        }
    }

    public static OfferInfo selectOfferByName(String name) {
        for(OfferInfo offer : offerList){
            if(offer.getCompanyName().equals(name)){
                return offer;
            }
        }
        return null;
    }

    public static int updateOffer(OfferInfo offer) {
        for(int i = 0; i < offerList.size(); i++){
            if(offerList.get(i).getCompanyName().equals(offer.getCompanyName())){
                offerList.set(i, offer);

                File file = new File(FILE_PATH);
                saveOffers(file, offerList);

                return 1;
            }
        }
        return 0;
    }

    private static void saveOffers(File file, ArrayList<OfferInfo> offerInfos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(offerInfos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static OfferInfo selectOfferByJobCode(int code) {
        for(OfferInfo offerInfo : offerList){
            if(offerInfo.getJobCode() == code){
                return offerInfo;
            }
        }
        return null;
    }

    public static int deleteUser(int no) {
        for(int i = 0; i < offerList.size(); i++){
            if(offerList.get(i).getJobCode() == no){
                offerList.remove(i);

                File file = new File(FILE_PATH);
                saveOffers(file, offerList);

                return 1;
            }
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    private void loadUsers(File file) {
        offerList.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<OfferInfo> loadedList = (ArrayList<OfferInfo>) ois.readObject();
            offerList.addAll(loadedList);
        } catch (EOFException e) {
            System.out.println("기업 정보를 모두 로딩하였습니다.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

/* 기존 코드 */
//    public static int insertOffer(OfferInfo offerInfo){
//        int result = 0;
//
//        try(MyObjectOutputStream moos = new MyObjectOutputStream(new FileOutputStream(FILE_PATH, true))){
//            moos.writeObject(offerInfo);
//            offerList.add(offerInfo);
//            result = 1;
//        } catch(IOException e){
//            throw new RuntimeException(e);
//        }
//
//        return result;
//    }

    /* 수정된 코드 */
    public static int insertOffer(OfferInfo offerInfo){
        offerList.add(offerInfo); // 메모리에 추가
        File file = new File(FILE_PATH);
        saveOffers(file, offerList); // 전체 데이터를 다시 파일에 저장

        return 1;
    }

    public static ArrayList<OfferInfo> selectAllOffers() {
        return offerList;
    }
}
