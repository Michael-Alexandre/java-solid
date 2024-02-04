import java.util.ArrayList;
import java.util.List;

class Journal
{
  private final List<String> entries = new ArrayList<>();
  private static int index =0;

  public void inputEntry(String texString) {
    entries.add("" + (++index) + texString);
  }

  public void deleteEntry(int index){
    entries.remove(index);
  }

  @Override
  
}