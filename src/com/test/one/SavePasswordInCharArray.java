package com.test.one;

public class SavePasswordInCharArray {
    Character[]  password;
    public SavePasswordInCharArray(Character[]  password) {
        this.password = password;
    }

    public static void main(String[] args) {
        Character[] password = {'p','a','a','s'};
        SavePasswordInCharArray obj = new SavePasswordInCharArray(password);
        // store password into database
        // once stored in database make this password as null
        obj.password = null;
        while(true) {}
    }
}
