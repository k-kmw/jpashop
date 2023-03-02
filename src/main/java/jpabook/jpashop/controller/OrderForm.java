package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderForm {

    private List<Member> members;
    private List<Item> items;
    private int count;
}
