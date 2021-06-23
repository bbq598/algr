import java.util.*;

public class ThreeSum57 {

    public List<List<Integer>> threeSum(int[] numbers){
        Map<Integer, Integer> data = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            data.put(numbers[i], data.getOrDefault(numbers[i], 0) + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length && j != i ; j++) {
                int n = 0 - numbers[i] - numbers[j];
                if (data.containsKey(n)) {
                    if (n == numbers[i] || n == numbers[j]) {

                        int count = numbers[i] == numbers[j] ? 3 : 2;
                        if (data.get(n) < count) {
                            continue;
                        }
                    }
                    List<Integer> res = new ArrayList<>();
                    res.add(numbers[i]);
                    res.add(numbers[j]);
                    res.add(n);
                    res.sort(Comparator.naturalOrder());
                    result.add(res);
                }
            }
        }
        List<List<Integer>> re = new ArrayList<>();

        for(List<Integer> list : result){
            re.add(list);
        }
        return re;
    }

  public static void main(String[] args) {
    int[] numbers = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};

    ThreeSum57 t = new ThreeSum57();

      List<List<Integer>> list = t.threeSum(numbers);
      for (int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i).toString());
      }
  }
}
