
import java.util.Scanner;

public class SecretAgent {

	String inMessage;
  String outMessage;
  LookUpTable luTable;

  public SecretAgent() {
    luTable = new LookUpTable();
    String[] code =   {"pastrami","tail", "shankle", "sausage", "ribeye", "bresaola","spicy", "jalapeno", "cow", "capicola", "pork","bacon", "picanha", "cupim", "hamburger", "kevin","beef"};
    String[] decode = {"the","secret","keep","it","porky","police","this", "is", "a","message","from","Hello","it","is","top","that","way"};
    for (int i = 0; i < 17; i++) {
      luTable.insert(code[i],decode[i]);
    }
    System.out.println(luTable.table[0].left + ":" + luTable.table[0].right);

  }

	public String decode(String messageIn) {
    outMessage = "";
    inMessage = messageIn;
    Scanner in = new Scanner(messageIn);
    while (in.hasNext()) {
      String decoded = luTable.lookUp(in.next());
      outMessage += decoded + " ";
    }
		return outMessage;
	}

  private class CodePair {
    String left;
    String right;

    public CodePair(String first, String second) {
      left = first;
      right = second;
    }
  }

  private class LookUpTable {
    int size;
    int capacity;
    CodePair[] table;

    public LookUpTable() {
      size = 0;
      capacity = 100;
      table = new CodePair[100];
    }

    public void insert(String first, String second) {
      CodePair pair = new CodePair(first,second);
      table[size] = pair;
      size++;
      if (size >= capacity) {
        size = 0;
        capacity = capacity * 2;
        CodePair[] babyTable = new CodePair[capacity * 2];
        for (CodePair babyPair : table) {
          babyTable[size] = pair;
          size++;
        }
        table = babyTable;
      }

    }

    public String lookUp(String what) {
      for (CodePair pair : table) {
        if (pair == null) break;
        if (pair.left.equals(what)) {
          return pair.right;
        }
        if (pair.right.equals(what)) return pair.left;
      }
      System.out.println(what);
      throw new NullPointerException();
    }


  }


}
