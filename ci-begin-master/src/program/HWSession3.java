package program;

import java.util.ArrayList;

public class HWSession3 {
    /**
     * Tìm kiếm chuỗi dài nhất trong list và trả về
     * @param list: list đầu vào
     * @return
     */
    public static String findMaxLength(ArrayList<String> list) {
        //TODO: bỏ return và hoàn thiện hàm
        int index = 0;
        int StringLon = list.get(0).length();
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).length() > StringLon)
            {
                StringLon = list.get(i).length();
                index = i;
            }
        }
        return list.get(index);
    }

    /**
     * Tính tổng độ dài của tất cả các chuỗi trong list và trả về
     * @param list: list đầu vào
     * @return
     */
    public static int findTotalLength(ArrayList<String> list) {
        //TODO: bỏ return và hoàn thiện hàm
        int totallength = 0;
        for(int i = 0; i < list.size();i++){
            totallength += list.get(i).length();
        }
        return totallength;
    }

    public static void main(String[] args) {
        // listString.add() // dua phan tu vao mang
        // listString.size() // lay kich thuoc cua mang
        // listString.get() // lay ra phan tu
        // listString.remove() // bo di phan tu
        ArrayList<String> listString = new ArrayList<>();
        listString.add("Lorem");
        listString.add("Ipsum");
        listString.add("is");
        listString.add("simply");
        listString.add("dummy");
        listString.add("of");
        listString.add("the");
        listString.add("printing");
        listString.add("and");
        listString.add("typesetting");
        listString.add("industry");

        // ví dụ thao tác với mảng
        System.out.println("List string:");
        System.out.println("<<<");
        for (int i = 0; i < listString.size(); i++) {
            String s = listString.get(i);
            System.out.println(s + " - length: " + s.length());
        }
        System.out.println(">>>");

        // in kết quả chạy thử hàm sau khi đã hoàn thiện phần TODO
        System.out.println("Longest string in list");
        String longestString = findMaxLength(listString);
        System.out.println(longestString); // "typesetting"

        System.out.println("Total length of strings in list");
        int totalLength = findTotalLength(listString);
        System.out.println(totalLength); // 58
    }
}