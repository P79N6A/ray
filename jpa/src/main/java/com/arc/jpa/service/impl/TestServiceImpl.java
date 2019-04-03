package com.arc.jpa.service.impl;

import com.arc.jpa.model.domain.SysUser;
import com.arc.jpa.repository.SysUserRepository;
import com.arc.jpa.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.*;
import java.util.*;

/**
 * @author 叶超
 * @since 2019/3/25 17:30
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public SysUser get(Long id) {
//        Optional<SysUser> byId = userRepository.findById(id);
//        ResponseEntity<S> error = userRepository.findOne(id).map(g -> ResponseEntity.ok(g)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR"));
//        return userRepository.findById(id).get();//orElseThrow(EntityNotFoundException::new);
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public Object queryByQuery(SysUser user) {
        return null;
    }

    /**
     * 条件查询
     *
     * @param model
     * @param pageable
     * @return
     */
    @Override
    public Page<SysUser> queryPage(SysUser model, Pageable pageable) {
        //封装查询对象Specification
        Specification<SysUser> specifications = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //获取客户端查询条件
                String nickname = model.getNickname();
                String avatar = model.getAvatar();

                //定义集合来确定Predicate[] 的长度，因为CriteriaBuilder的or方法需要传入的是断言数组
                List<Predicate> predicates = new ArrayList<>();


                //对客户端查询条件进行判断,并封装Predicate断言对象
                if (nickname != null && !"".equals(nickname)) {
                    //root.get("company")获取字段名
                    //company客户端请求的字段值
                    //as(String.class)指定该字段的类型
                    Path<Object> nicknamePath = root.get("nickname");
                    Predicate predicate = cb.equal(nicknamePath, nickname);
                    predicates.add(predicate);
                }
                if (null != avatar && !"".equals(avatar)) {
                    if (StringUtils.isEmpty(avatar)) {
                        Predicate predicate = cb.equal(root.get("avatar"), avatar);
                        predicates.add(predicate);
                    }
                }
                //判断结合中是否有数据
                if (predicates.size() == 0) {
                    return null;
                }

                //将集合转化为CriteriaBuilder所需要的Predicate[]
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return query.getRestriction();
            }
        };
        //调用Dao方法进行条件查询
        Page<SysUser> page = userRepository.findAll(specifications, pageable);
        System.out.println(page);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        return page;
    }


    public Page<SysUser> queryPage2(SysUser model, Pageable pageable) {
        System.out.println("#########################");
        System.out.println(model.getNickname());
        System.out.println(model.getNickname());
        System.out.println(model.getNickname());
        System.out.println(model.getAvatar());
        System.out.println(model.getAvatar());
        System.out.println(model.getAvatar());
        //封装查询对象Specification
        Specification<SysUser> specifications = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //获取客户端查询条件
                String nickname = model.getNickname();
                String avatar = model.getAvatar();

                //定义集合来确定Predicate[] 的长度，因为CriteriaBuilder的or方法需要传入的是断言数组
                List<Predicate> predicates = new ArrayList<>();


                //对客户端查询条件进行判断,并封装Predicate断言对象
                if (nickname != null && !"".equals(nickname)) {
                    //root.get("company")获取字段名
                    //company客户端请求的字段值
                    //as(String.class)指定该字段的类型
                    Path<Object> nicknamePath = root.get("nickname");
                    Predicate predicate = cb.equal(nicknamePath, nickname);
                    predicates.add(predicate);
                }
                if (null != avatar && !"".equals(avatar)) {
                    if (StringUtils.isEmpty(avatar)) {
                        Predicate predicate = cb.equal(root.get("avatar"), avatar);
                        predicates.add(predicate);
                    }
                }
                //判断结合中是否有数据
                if (predicates.size() == 0) {
                    return null;
                }

                //将集合转化为CriteriaBuilder所需要的Predicate[]
                Predicate[] predicateArr = new Predicate[predicates.size()];
                predicateArr = predicates.toArray(predicateArr);

                System.out.println("---------------------------------");
                System.out.println(predicateArr);
                System.out.println(predicateArr.length);
                System.out.println("---------------------------------");
                // 返回所有获取的条件： 条件 or 条件 or 条件 or 条件
                return cb.or(predicateArr);
            }
        };
        //调用Dao方法进行条件查询
        Page<SysUser> page = userRepository.findAll(specifications, pageable);
        System.out.println(page);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        return page;
    }

    //--------

    //back

//    public static Specification<SysUser> queryPage(SysUser user) {
    //lambda表达式
//        return (Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
    //开始
//            Predicate finalConditions = criteriaBuilder.conjunction();
//
//                //提取参数
//                String taskFast = MapUtils.getString(params, "taskFast");
//
//                //lile 和join 用法 join可跟,JoinType.LEFT等
//                if (StringUtils.isNotBlank(taskFast)) {
//                    Predicate taskFastPre = criteriaBuilder.like(root.join("taskType",JoinType.LEFT).<String>get("id"), "%" + taskFast + "%");
//                    finalConditions = criteriaBuilder.and(finalConditions, taskFastPre);
//                }
    //between用法
//                if ((null != createBegin) && (null != createEnd)) {
//                    Predicate datePredicate = null;
//                    if (createBegin.after(createEnd)) {
//                        datePredicate = criteriaBuilder.between(root.get("gmtCreate"), createEnd, createBegin);
//                    } else {
//                        datePredicate = criteriaBuilder.between(root.get("gmtCreate"), createBegin, createEnd);
//                    }
//                    finalConditions = criteriaBuilder.and(finalConditions, datePredicate);
//                }
//                //equale
//                if (null != emergency && 0 != emergency) {
//                    finalConditions = criteriaBuilder.and(finalConditions, criteriaBuilder.equal(root.get("emergencyLevel"), emergency));
//                }
//                //大于 不等于
//                if (status != null) {
//                    finalConditions = criteriaBuilder.and(finalConditions, criteriaBuilder.greaterThan(root.get("startDate"), new Date()));
//                    finalConditions = criteriaBuilder.and(finalConditions, criteriaBuilder.notEqual(root.get("status"), 1));
//                }
//                // or
//                if (StringUtils.isNotBlank(keyword)) {
//                    finalConditions = criteriaBuilder.and(finalConditions, criteriaBuilder.or(
//                            criteriaBuilder.like(root.get("taskName"), "%" + keyword + "%"),
//                            criteriaBuilder.like(root.join("project").get("name"), "%" + keyword + "%"))
//                    );
//                }
//                //in
//                if (taskIds.size() > 0) {
//                    CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get("id"));
//                    for (String id : taskIds) {
//                        in.value(id);
//                    }
//                    finalConditions = criteriaBuilder.and(finalConditions, in);
//                }

//            return query.where(finalConditions).getRestriction();
//        };
//    }


    //---
//        public  Specification<SysUser> where(String keyword, Date createdAtBegin, Date createdAtEnd, List<String> userIds) {
//            return (Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
//                List<Predicate> predicates = new ArrayList<>();
//
//                if (!StringUtils.isEmpty(keyword)) {
//                    List<Predicate> temp = new ArrayList<>();
//                    Set<String> keywordCopyStr = StringUtil.cutToArray(keyword);
//                    for (String oneKeyword : keywordCopyStr) {
//                        temp.add(cb.like(root.<String>get("mobile"), "%" + oneKeyword + "%"));
//                        temp.add(cb.like(root.<String>get("trueName"), "%" + oneKeyword + "%"));
//                    }
//                    predicates.add(cb.or(temp.toArray(new Predicate[temp.size()])));
//                }
//                //未删除
////                predicates.add(cb.equal(root.get("isDelete"), Constant.NOT_DELETED));
//                query.where(predicates.toArray(new Predicate[predicates.size()]));
//                return query.getRestriction();
//            };
//            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
//        }


    public List<InvoiceInfo> findByCondition(InvoiceListVo vo){
        List<InvoiceInfo> resultList = null;
        Specification querySpecifi = new Specification<InvoiceInfo>() {
            @Override
            public Predicate toPredicate(Root<InvoiceInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(!vo.getPhone().equals("0")){
                    predicates.add(criteriaBuilder.equal(root.get("phone"), vo.getPhone()));
                }
                if(0 != vo.getTitleType()){
                    predicates.add(criteriaBuilder.equal(root.get("titleType"), vo.getTitleType()));
                }
                if(null != vo.getInvoiceTitle()){
                    predicates.add(criteriaBuilder.equal(root.get("invoiceTitle"), "%"+vo.getInvoiceTitle()+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  this.invoiceInfoRepository.findAll(querySpecifi);
        return resultList;
    }


}
