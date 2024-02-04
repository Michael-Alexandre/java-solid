/**
 * SOLID - Single Responsibility Principle
 */
import java.util.ArrayList;
import java.util.List;

class Journal
{
  private final List<String> entries = new ArrayList<>();
  private static int index =0;

  public void inputEntry(String textString) {
    entries.add("" + (++index) + textString);
  }

  public void deleteEntry(int index){
    entries.remove(index);
  }

  @Override
  public String toString(){
    return String.join(System.lineSeparator(), entries);
  }
}

class Demonstration {

    public static void main(String[] argStrings) {
      Journal j = new Journal();
      j.inputEntry("I ate a bug");
      j.inputEntry("It was a delicious bug");
    }
  
}