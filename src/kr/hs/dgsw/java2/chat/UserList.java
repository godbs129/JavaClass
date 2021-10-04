package kr.hs.dgsw.java2.chat;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    public List<String> userList = new ArrayList<>();

    public void setUserList(String name) {
        userList.add(name);
    }

    public List<String> getUserList() {
        return userList;
    }
}
