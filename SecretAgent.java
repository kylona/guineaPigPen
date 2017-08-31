
import java.util.Scanner;

public class SecretAgent {

	String inMessage;
  String outMessage;
  LookUpTable luTable;

  public SecretAgent() {
    luTable = new LookUpTable();
    luTable.insert("bacon","Hello");
    System.out.println(luTable.table[0].left + ":" + luTable.table[0].right);

  }

	public String decode(String messageIn) {
	  inMessage = messageIn;
		return inMessage;
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
        if (pair.left == what) return pair.right;
        if (pair.right == what) return pair.left;
      }
      return "ERROR: Not in Table";
    }


  }


}
