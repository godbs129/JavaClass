package kr.hs.dgsw.java.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {
    private List<Name> list = new ArrayList<Name>();

    public void add(Name name) {
        list.add(name);
    }
    public Name read(String name) {
        for(Name name1: list) {
            if(name1.getName().equals(name)) {
                return name1;
            }
        }
        return null;
    }

    public Name readByPhoneNumber(String phoneNumber) {
        for (Name name: list) {
            if (name.getPhoneNum().equals(phoneNumber)) {
                return name;
            }
        }

        return null;
    }

    public void remove(String name) {
        for(Name name1: list) {
            if(name1.getName().equals(name)) {
                list.remove(name);
            }
        }
    }

    public List<Name> getAll() {
        return list;
    }

    public static void main(String[] args) {
        Contacts contacts = new Contacts();

        Name name = new Name();
        name.setName("전해윤");
        name.setPhoneNum("010-2779-7060");
        contacts.add(name);

        name = contacts.read("전해윤");

        List<Name> names = contacts.getAll();
    }
}