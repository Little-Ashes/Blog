package com.ggl;

import com.alibaba.fastjson.JSON;
import com.ggl.dao.TypeRepository;
import com.ggl.domain.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private TypeRepository typeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testTypeFindAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1,5,sort);
        Page<Type> page =  typeRepository.findAll(pageable);
        List<Type> types = typeRepository.findAll();
//        System.out.println(JSON.toJSONString(page,true));
    }

}
