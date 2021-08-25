package kr.hs.dgsw.java.exam;

import java.util.List;
import java.util.Scanner;

public class PhoneBookCli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new DBPhoneBook();
        NameCard nameCard = null;


        while (true) {
            System.out.println("\n0: 종료, 1: 정보 삽입, 2: 전체 조회, 3: id 검색, 4: 이름 검색, 5: 삭제, 6: 수정, 7: 사이즈");
            System.out.print("> ");
            int num = sc.nextInt();
            List<NameCard> cards = phoneBook.getList();
            switch (num) {
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                case 1:
                    System.out.print("이름 : ");
                    String name = sc.next();
                    System.out.print("전화번호 : ");
                    String phoneNumber = sc.next();
                    System.out.print("주소 : ");
                    String address = sc.next();

                    phoneBook.addCard(name, phoneNumber, address);

                    break;
                case 2:
                    System.out.println("PhoneBook");
                    for (NameCard card : cards) {
                        System.out.println(card.toString());
                    }

                    break;
                case 3:
                    try {
                        System.out.print("검색할 id : ");
                        int searchId = sc.nextInt();
                        nameCard = phoneBook.getCard(searchId);
                        System.out.println(nameCard.toString());

                        break;
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 id입니다");
                        break;
                    }
                case 4:
                    try {
                        System.out.print("검색할 이름 : ");
                        String searchName = sc.next();
                        nameCard = phoneBook.getCard(searchName);
                        System.out.println(nameCard.toString());

                        break;
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 이름");
                        break;
                    }
                case 5:
                    try {
                        System.out.print("삭제할 id : ");
                        int delId = sc.nextInt();
                        nameCard = phoneBook.getCard(delId);
                        System.out.println(nameCard.toString());

                        phoneBook.removeCard(delId);

                        break;
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 id");
                        break;
                    }
                case 6:
                    try {
                        System.out.print("수정할 id : ");
                        int updateId = sc.nextInt();
                        System.out.print("이름 : ");
                        String updateName = sc.next();
                        System.out.print("전화번호 : ");
                        String updatePhoneNumber = sc.next();
                        System.out.print("주소 : ");
                        String updateAddress = sc.next();

                        phoneBook.updateCard(updateId, updateName, updatePhoneNumber, updateAddress);
                        nameCard = phoneBook.getCard(updateId);
                        System.out.println(nameCard.toString());

                        break;
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 id");
                        break;
                    }
                case 7:
                    System.out.println("SIZE : " + phoneBook.size());
                    break;

                default:
                    System.out.println("다시 입력하세요");
                    break;
            }
        }
    }
}
