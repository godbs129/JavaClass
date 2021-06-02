package kr.hs.dgsw.java.exam;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePhoneBook implements PhoneBook {

    public static final String FILE_NAME = "phoneBook.dat";

    private File file;

    public FilePhoneBook() {
        file = new File("/Users/haeyoon/Desktop/DGSW/Java/src/kr/hs/dgsw/java/exam/" + FILE_NAME);
    }

    @Override
    public List<NameCard> getList() {
        try {
            List<NameCard> list = new ArrayList<NameCard>();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String str = null;
            int id = 1;

            while ((str = br.readLine()) != null) {
                String[] phoneBook = str.split("_");

                NameCard card = new NameCard();
                card.setId(id);
                card.setName(phoneBook[0]);
                card.setPhoneNumber(phoneBook[1]);
                card.setAddress(phoneBook[2]);

                list.add(card);
                id++;
            }

            br.close();

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public NameCard getCard(int id) {
        List<NameCard> list = this.getList();

        for (NameCard card : list) {
            if (card.id == id) {
                return card;
            }
        }
        System.out.println("존재하지 않는 ID");

        return null;
    }

    @Override
    public NameCard getCard(String name) {
        List<NameCard> list = this.getList();

        for (NameCard card : list) {
            if (card.name.equals(name)) {
                return card;
            }
        }
        System.out.println("존재하지 않는 이름");

        return null;
    }

    @Override
    public int addCard(String name, String phoneNumber, String address) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(name + "_" + phoneNumber + "_" + address + "\n");
            bw.close();

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public boolean removeCard(int id) {
        List<NameCard> list = this.getList();

        file.delete();

        for(NameCard card : list) {
            if(card.id == id) {
                list.remove(card);
                break;
            }
        }

        for (NameCard card: list) {
            this.addCard(card.getName(), card.getPhoneNumber(), card.getAddress());
        }
        return false;
    }

    @Override
    public void updateCard(int id, String name, String phoneNumber, String address) {
        List<NameCard> list = this.getList();

        file.delete();

        for (NameCard card: list) {

            if (card.id == id) {
                card.setName(name);
                card.setPhoneNumber(phoneNumber);
                card.setAddress(address);
                break;
            }
        }

        for (NameCard card: list) {
            this.addCard(card.getName(), card.getPhoneNumber(), card.getAddress());
        }
    }

    @Override
    public int size() {
        List<NameCard> list = getList();
        return list.size();
    }
}
