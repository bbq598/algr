import java.util.*;

public class TwoSumIIIDatastructuredesign607 {

  Map<Integer, Integer> data = new HashMap<>();

  public void add(int numbers) {
      data.put(numbers, data.getOrDefault(numbers, 0) +1);
  }

  public boolean find(int value) {
      for (Integer n : data.keySet()){
          if(data.containsKey( value - n)){
              if(value == n * 2){
                  if(data.get(n) >= 2){
                      return true;
                  }else{
                      continue;
                  }
              }
              return true;
          }
      }
      return false;
  }

  public static void main(String[] args) {
    TwoSumIIIDatastructuredesign607 t = new TwoSumIIIDatastructuredesign607();
    t.add(1);
    t.add(3);
    t.add(5);
    System.out.println(t.find(7));
    System.out.println(t.find(4));
  }
}
