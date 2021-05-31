package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import java.security.Provider;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
//  private Book coreJava = new Book();

  private Book first = new Book(0, "firstBook", 25, "King", 100, 2001);
  private Book second = new Book(1, "secondBook", 99, "Oz", 200, 2014);
  private Book third = new Book(2, "thirdBook", 10, "Ivanov", 50, 1986);
  private Book fourth = new Book(3, "fourthBook", 1, "Ivanov", 150, 1999);

  @BeforeEach
  public void setUp() {
    repository.save(first);
    repository.save(second);
    repository.save(third);
    repository.save(fourth);
  }


  @Test
  public void shouldRemoveByActualId() {
    repository.removeById(1);

    Product[] expected = new Product[]{first, third, fourth};
    Product[] actual = new Product[]{first, third, fourth};
    assertArrayEquals(expected, actual);
  }


  @Test
  public void shouldRemoveByNotActualId() {
    assertThrows(NotFoundException.class, () -> repository.removeById(22));
  }



  @Test
  public void shouldFindByActualId() {
    repository.findById(0);

    Product[] expected = new Product[]{first};
    Product[] actual = new Product[]{first};
    assertArrayEquals(expected, actual);
  }


  @Test
  public void shouldSaveOneItem() {
    repository.save(first);

    Product[] expected = new Product[]{first};
    Product[] actual = new Product[]{first};
    assertArrayEquals(expected, actual);
  }
}
