package com.ohgiraffers.Strema;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{

    public MyObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }

    // 유저 정보를 추가 입력하여 파일을 쓸 때는 streawm header 정보가 출력되지 않도록 메소드 재작성
    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader();
    }
}
