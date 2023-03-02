package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService { //itemRepository 위임하는 클래스

    private final ItemRepository itemRepository;

    @Transactional
    //상품 등록, 수정
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto itemDto) {
        Item findItem = itemRepository.findOne(itemId); //findItem은 영속성 엔티티이므로 set만 해주면 jpa가 commit 시점에 db에 쿼리 날려줌(변경 감지)
        // commit하면 jpa는 flush: 영속성 컨텍스트에 있는 엔티티중에 변경된 애를 모두 찾은 후 업데이트 쿼리를 db에 날림
//        findItem.setPrice(param.getPrice());
//        findItem.setName(param.getName());
//        findItem.setStockQuantity(param.getStockQuantity());
        //merge 동작 방식
        findItem.change(itemDto);
    }

    //상품 목록 조회
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }

}
