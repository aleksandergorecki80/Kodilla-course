package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class InvoiceDaoTests {
  @Autowired
  private InvoiceDao invoiceDao;

  @Test
  void testInvoiceDaoSave(){
    // Given
    Product bike = new Product("Bike");
    Product bread = new Product("Bread");
    Product milk = new Product("Milk");
    Product car = new Product("Car");
    Product hammer = new Product("Hammer");

    Invoice invoice1 = new Invoice("INV-01", new ArrayList<>());
    Invoice invoice2 = new Invoice("INV-02", new ArrayList<>());

    Item item1inv1 = new Item(bike, BigDecimal.valueOf(1000), 2, BigDecimal.valueOf(2000), invoice1);
    Item item2inv1 = new Item(bread, BigDecimal.valueOf(10), 4, BigDecimal.valueOf(40), invoice1);
    Item item3inv1 = new Item(milk, BigDecimal.valueOf(100), 3, BigDecimal.valueOf(300), invoice1);

    Item item1inv2 = new Item(car, BigDecimal.valueOf(200), 2, BigDecimal.valueOf(400), invoice2);
    Item item2inv2 = new Item(hammer, BigDecimal.valueOf(50), 4, BigDecimal.valueOf(200), invoice2);
    Item item3inv2 = new Item(milk, BigDecimal.valueOf(100), 5, BigDecimal.valueOf(500), invoice2);

    // When
    item1inv1.setInvoice(invoice1);
    item2inv1.setInvoice(invoice1);
    item3inv1.setInvoice(invoice1);
    invoice1.getItems().add(item1inv1);
    invoice1.getItems().add(item2inv1);
    invoice1.getItems().add(item3inv1);
    invoiceDao.save(invoice1);

    item1inv2.setInvoice(invoice2);
    item2inv2.setInvoice(invoice2);
    item3inv2.setInvoice(invoice2);
    invoice2.getItems().add(item1inv2);
    invoice2.getItems().add(item2inv2);
    invoice2.getItems().add(item3inv2);
    invoiceDao.save(invoice2);

    // Then
    assertTrue(invoice1.getItems().contains(item1inv1));
    assertTrue(invoice1.getItems().contains(item2inv1));
    assertTrue(invoice1.getItems().contains(item3inv1));
    assertNotEquals(0, item1inv1.getId());
    assertNotEquals(0, item2inv1.getId());
    assertNotEquals(0, item3inv1.getId());

    assertTrue(invoice2.getItems().contains(item1inv2));
    assertTrue(invoice2.getItems().contains(item2inv2));
    assertTrue(invoice2.getItems().contains(item3inv2));
    assertNotEquals(0, item1inv2.getId());
    assertNotEquals(0, item2inv2.getId());
    assertNotEquals(0, item3inv2.getId());

    // Clean Up
    int invoice1Id = invoice1.getId();
    int invoice2Id = invoice2.getId();
    try {
      invoiceDao.deleteById(invoice1Id);
      invoiceDao.deleteById(invoice2Id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
