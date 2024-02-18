/**Interface Segregation Principle
 * don't put too much into an interface, split into separate interfaces
 * YAGNI - You Ain't Going to Need It
 */

class Document {

}

interface Machine
{
  void print(Document d);
  void fax(Document d);
  void scan(Document d);
}

class MultiFunctionPrinter implements Machine 
{

  @Override
  public void print(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'print'");
  }

  @Override
  public void fax(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'fax'");
  }

  @Override
  public void scan(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'scan'");
  }

}

class OldFashionPrinter implements Machine
{
  @Override
  public void print(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'print'");
  }

  @Override
  public void fax(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'fax'");
  }

  @Override
  public void scan(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'scan'");
  }
}
// YAGNI You Ain't Going Need It
interface Printer
{
 void print(Document d); 
}

interface Scanner
{
  void scan(Document d);
}

class Photocopier implements Printer, Scanner
{
  @Override
  public void scan(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'scan'");
  }

  @Override
  public void print(Document d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'print'");
  }
 //decorator pattern 
}