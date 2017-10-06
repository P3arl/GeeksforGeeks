/*
Print the elements of an array in the decreasing frequency 
if 2 numbers have same frequency then print the one which came first.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

   public static void main(String[] args) {
      int []a = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
      Map<Integer,List<Integer>> m = new HashMap<>();
      for(int i=0;i<a.length;i++) {
         int n = a[i];
         if(m.containsKey(n)) {
            List<Integer> list = m.get(n);
            list.add(i);
            m.put(a[i], list);
         }else {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            m.put(a[i], list);
         }
      }
      System.out.println(m);
      ArrayList<Entry<Integer, List<Integer>>> entryList = new ArrayList<>(m.entrySet());
      Collections.sort(entryList, new Comparator<Entry<Integer, List<Integer>>>() {

         @Override
         public int compare(Entry<Integer, List<Integer>> e1, Entry<Integer, List<Integer>> e2) {
            int n1 = e1.getValue().size();
            int n2 = e2.getValue().size();
            return n1 == n2 ? (e1.getValue().get(0)<e2.getValue().get(0)?-1:1):(n1>n2?-1:1);
         }
         
      });
      System.out.println(entryList);
      LinkedHashMap<Integer,List<Integer>> linkedMap = new LinkedHashMap<>(entryList.size());
      for(Entry<Integer, List<Integer>> e:entryList) {
         linkedMap.put(e.getKey(), e.getValue());
      }
      System.out.println(linkedMap);
      int i=0;
      for(Entry<Integer, List<Integer>> e:linkedMap.entrySet()) {
         for(int j=0;j<e.getValue().size();j++) {
            a[i] = e.getKey();
            i++;
         }
      }
      System.out.println(Arrays.toString(a));
   }
}
