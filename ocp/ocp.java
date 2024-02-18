/**
 * OPEN-CLOSED PRINCIPLE
 * classes should be open for extension but 
 * closed for modification
 */

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

interface Specification<T> {
  boolean isSatisfied(T item);
}

interface Filter<T> {
  Stream<T> filter(List<T> items, Specification<T> spec);
}

class BetterFilter implements Filter<Product> {
  @Override
  public Stream<Product> filter(List<Product> items,
                                Specification<Product> spec){
    return items.stream().filter(p -> spec.isSatisfied(p));
  }
}

class ColorSpecification implements Specification<Product>{
  private Colors color;

  public ColorSpecification(Colors color){
    this.color = color;
  }

  @Override
  public boolean isSatisfied(Product item){
    return item.color == color;
  }
}

class SizeSpecification implements Specification<Product>{
  private Sizes size;

  public SizeSpecification(Sizes size){
    this.size = size;
  }

  @Override
  public boolean isSatisfied(Product item){
    return item.size == size;
  }
}

class AndSpecification<T> implements Specification<T>{

  private Specification<T> first, second;

  public AndSpecification(Specification<T> first, Specification<T>
    second) {
      this.first = first;
      this.second = second;
    }

  @Override
  public boolean isSatisfied(Product item){
    return first.isSatisfied(item) && second.isSatisfied(item);
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
    
    BetterFilter bf = new BetterFilter();
    System.out.println("(New) Green products:");
    bf.filter(products, new ColorSpecification(Colors.green))
      .forEach(p -> System.out.println(
        " - " + p.name + " is GReen"));

    System.out.println("Huge blue items: ");
    bf.filter(products, 
      new AndSpecification<>(
        new ColorSpecification(Colors.blue), 
        new SizeSpecification(Sizes.huge) 
          )).forEach(p -> System.out.println(
            " - " + p.name + " is Blue and Huge"));
  }
}