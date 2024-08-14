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
            offerInfos.add(new OfferInfo("청바지기업", "영업", "판교", 30000000, "열심히 일합시다.", new String[] {"중식제공"}, 1));
            offerInfos.add(new OfferInfo("화이팅기업", "영업관리", "강남", 40000000, "화이팅있게 일합시다.", new String[] {"야근 시 석식제공"}, 2));
            offerInfos.add(new OfferInfo("장그래기업", "마케팅", "수원", 50000000, "그래그래 합시다", new String[] {"교통비 제공"}, 3));

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
