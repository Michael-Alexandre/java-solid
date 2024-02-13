/** implemented without ocp - filters problem */
import java.util.List;
import java.util.stream.Stream;

enum Colors {
  red, green, blue
}

enum Sizes {
  small, medium, large, huge
}

class Product{
  public String name;
  public Colors color;
  public Sizes size;

  public Product(String name, Colors color, Sizes size) {
    this.name = name;
    this.color = color;
    this.size = size;
  }
}

class ProductFilter {
  public Stream<Product> filterByColor(List<Product> products, Colors color)
  {
    return products.stream().filter(p -> p.color == color);
  }

  public Stream<Product> filterBySize(List<Product> products, Sizes size)
  {
    return products.stream().filter(p -> p.size == size);
  }
}

class Show {
  public static void main(String[] args){
    Product apple = new Product("Apple", Colors.green, Sizes.small);
    Product tree = new Product("Tree", Colors.green, Sizes.large);
    Product house = new Product("House", Colors.blue, Sizes.huge);
    
    List<Product> products = List.of(apple, tree, house);

    ProductFilter pf = new ProductFilter();
    System.out.println("(old) Green products:");
    pf.filterByColor(products, Colors.green)
              .forEach(p -> System.out.println(
                " - " + p.name + " is green"));
  }
}