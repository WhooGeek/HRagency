package com.ohgiraffers.aggregate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class OfferInfo implements Serializable {

    private String companyName;
    private String position;
    private String location;
    private int salary;
    private String jobDescription;
    private String[] welfare;
    private int jobCode;

    public OfferInfo() {}   // 기본생성자

    public OfferInfo(String companyName, String position, String location, int salary, String jobDescription, String[] welfare, int jobCode) {
        this.companyName = companyName;
        this.position = position;
        this.location = location;
        this.salary = salary;
        this.jobDescription = jobDescription;
        this.welfare = welfare;
        this.jobCode = jobCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String[] getWelfare() {
        return welfare;
    }

    public void setWelfare(String[] welfare) {
        this.welfare = welfare;
    }


    public int getJobCode() {
        return jobCode;
    }

    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    @Override
    public String toString() {
        return "OfferInfo{" +
                "companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", jobDescription='" + jobDescription + '\'' +
                ", welfare=" + Arrays.toString(welfare) +
                ", jobCode=" + jobCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferInfo offerInfo = (OfferInfo) o;
        return salary == offerInfo.salary && jobCode == offerInfo.jobCode && Objects.equals(companyName, offerInfo.companyName) && Objects.equals(position, offerInfo.position) && Objects.equals(location, offerInfo.location) && Objects.equals(jobDescription, offerInfo.jobDescription) && Objects.deepEquals(welfare, offerInfo.welfare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, position, location, salary, jobDescription, Arrays.hashCode(welfare), jobCode);
    }
}
