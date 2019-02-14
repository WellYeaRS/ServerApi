package com.springcloud.serverApi.service.impl;

import com.springcloud.serverApi.entity.Borrow;
import com.springcloud.serverApi.entity.Comment;
import com.springcloud.serverApi.repository.BookRepository;
import com.springcloud.serverApi.repository.BorrowRepository;
import com.springcloud.serverApi.repository.UserRepository;
import com.springcloud.serverApi.service.BorrowService;
import com.springcloud.serverApi.vo.PageInfo;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService{
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    /**
     * 借阅书籍
     *
     * @param bookId
     * @param userId
     * @return
     */
    @Override
    public Result borrowBook(long bookId, long userId) {
        Borrow borrow = new Borrow();
        borrow.setBookId(bookId);
        borrow.setUserId(userId);
        borrow.setLendTime(new Date());
        borrowRepository.save(borrow);
        return Result.success();
    }

    /**
     * 查看借阅记录
     *
     * @param bookId
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo getBorrowRecords(long bookId, int page, int size,Integer state, Date begDate, Date endDate) {
        //规格定义
        Specification<Borrow> specification = new Specification<Borrow>() {
            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<Borrow> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                Predicate eqBookId = cb.equal(root.get("bookId"),bookId);
                predicates.add(eqBookId);
                if(state != null){
                    Predicate eqState = cb.equal(root.get("state"),state);
                    predicates.add(eqState);
                }
                if(begDate != null){
                    Predicate begDateCon = cb.greaterThanOrEqualTo(root.get("lendTime"),begDate);
                    predicates.add(begDateCon);
                }
                if(endDate != null){
                    Predicate endDateCon = cb.lessThanOrEqualTo(root.get("lendTime"),endDate);
                    predicates.add(endDateCon);
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = PageRequest.of(page - 1,size);
        Page<Borrow> all = borrowRepository.findAll(specification, pageable);
        PageInfo<Borrow> pageInfo = new PageInfo<>();
        pageInfo.setNowPage(page);
        pageInfo.setSize(size);
        for(Borrow borrow : all.getContent()){
            borrow.setBorrowUser(userRepository.getOne(borrow.getUserId()));
            borrow.setBook(bookRepository.getOne(borrow.getBookId()));
        }
        pageInfo.setDatas(all.getContent());
        pageInfo.setTotal(all.getTotalElements());
        return pageInfo;
    }
}
