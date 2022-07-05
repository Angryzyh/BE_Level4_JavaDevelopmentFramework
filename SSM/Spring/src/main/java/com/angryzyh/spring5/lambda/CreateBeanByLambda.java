package com.angryzyh.spring5.lambda;

import com.angryzyh.spring5.lambda.model.Book;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

public class CreateBeanByLambda {
    @Test
    public void demo() {
        GenericApplicationContext app = new GenericApplicationContext();
        app.refresh();
        app.registerBean("book", Book.class, () -> new Book());
        Book book = (Book) app.getBean("book");
        book.setBid(1);
        book.setBname("《java葵花宝典》");
        System.out.println("book = " + book);
    }
}
