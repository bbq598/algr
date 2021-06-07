import java.util.HashMap;
import java.util.Map;

public class Fibonacci366 {

  public int fibonacci2(int n) {
      if(n <= 2){
          return n - 1;
      }
    return fibonacci2(n - 1) + fibonacci2(n - 2);
  }

    public int fibonacci(int n, Map<Integer, Integer> result) {
        if(n <= 2){
            return n - 1;
        }
        if(result.containsKey(n)){
            return result.get(n);
        }
        int m = fibonacci(n - 1, result) + fibonacci(n - 2, result);
        result.put(n, m);
        return m;
    }

    int solve(int x) {
        if (x == 1) {
            return x;
        }
        return solve(x - 1) + 1;
    }

  public static void main(String[] args) {
    int n = 30;
    Map<Integer, Integer> result = new HashMap<>();
    System.out.println(new Fibonacci366().fibonacci(n, result));
    System.out.println(new Fibonacci366().solve(5));
  }
}
