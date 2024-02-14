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