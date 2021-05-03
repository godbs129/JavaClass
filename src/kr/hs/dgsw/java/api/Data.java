package kr.hs.dgsw.java.api;

public class Data {

  public String phoneNum;

  public String address;

  public Data (String phoneNum, String address) {
    this.phoneNum = phoneNum;
    this.address = address;
  }

  public void display () {
    System.out.println(phoneNum + ", " + address);
  }
}
