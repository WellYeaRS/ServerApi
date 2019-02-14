package com.springcloud.serverApi.service.impl;

import com.springcloud.serverApi.entity.Comment;
import com.springcloud.serverApi.repository.BookRepository;
import com.springcloud.serverApi.repository.CommentRepository;
import com.springcloud.serverApi.repository.UserRepository;
import com.springcloud.serverApi.service.CommentService;
import com.springcloud.serverApi.vo.CommentVo;
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
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    /**
     * 添加评论
     *
     * @param bookId
     * @param userId
     * @param content
     * @return
     */
    @Override
    public Result addComment(long bookId, long userId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setBookId(bookId);
        comment.setComment(content);
        comment.setUpdateTime(new Date());
        commentRepository.save(comment);
        return Result.success();
    }

    /**
     * 获取评论
     *
     * @param bookId
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo getComments(long bookId, int page, int size) {
        //规格定义
        Specification<Comment> specification = new Specification<Comment>() {
            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                Predicate eqBookId = cb.equal(root.get("bookId"),bookId);
                predicates.add(eqBookId);
                return cb.and(predicates.toArray(new Predicate[1]));
            }
        };
        Pageable pageable = PageRequest.of(page - 1,size);
        Page<Comment> all = commentRepository.findAll(specification, pageable);
        PageInfo<CommentVo> pageInfo = new PageInfo<>();
        pageInfo.setNowPage(page);
        pageInfo.setSize(size);
        List<CommentVo> datas = new ArrayList<>();
        for(Comment comment : all.getContent()){
            CommentVo commentVo = new CommentVo();
            commentVo.setCommentId(comment.getCommentId());
            commentVo.setComment(comment.getComment());
            commentVo.setCommentUser(userRepository.getOne(comment.getUserId()));
            commentVo.setBook(bookRepository.getOne(comment.getBookId()));
            commentVo.setUpdateTime(comment.getUpdateTime());
            datas.add(commentVo);
        }
        pageInfo.setDatas(datas);
        pageInfo.setTotal(all.getTotalElements());
        return pageInfo;
    }
}
