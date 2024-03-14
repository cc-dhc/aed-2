import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exs {
  public static void main(String[] args) {
    List<String> Lstring = new ArrayList<String>();

    for(int i=100; i>0; i--)
      Lstring.add(String.format("%03d", i));

    Lstring.sort(null);

    ex02(Lstring);
    assert ex03(Lstring, "030");
    assert ex04(Lstring, "073");

    ex05(Lstring, "030");
    assert !ex03(Lstring, "030");
    ex06(Lstring, "073");
    assert !ex04(Lstring, "073");
  }

  public static void ex01(List<String> list) {
    Scanner sc = new Scanner(System.in);
    String input;

    do {
      input = sc.nextLine();
      list.add(input);
    } while (!input.equals("STOP"));

    sc.close();
  }

  public static void ex02(List<String> list) {
    for (String str : list) {
      System.out.println(str);
    }
  }

  public static boolean ex03(List<String> list, String name) {
    for (String str : list) {
      if (str.equals(name)) return true;
    }
    return false;
  }

  public static boolean ex04(List<String> list, String name) {
    int i=0, j=list.size() - 1;

    do {
      int idx = (j+i)/2;
      int res = list.get(idx).compareTo(name);
      if (res == 0) {
        return true;
      } else if(res < 0) {
        i = idx + 1;
      } else {
        j = idx - 1;
      }

    } while(j-i > 0);

    return false;
  }

  public static void ex05(List<String> list, String name) {
    if(ex03(list, name)) {
      list.remove(name);
    }
  }

  public static void ex06(List<String> list, String name) {
    if(ex04(list, name)) {
      list.remove(name);
    }
  }
}
