package com.shiroapache.service.impl;

import com.shiroapache.mapper.ResourcesMapper;
import com.shiroapache.pojo.Resources;
import com.shiroapache.service.ResourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Resource
    private ResourcesMapper resourcesMapper;

    @Override
    public List<Resources> selectAllByStatusAndSortNumAsc() {
        return resourcesMapper.selectAllByStatusAndSortNumAsc();
    }
}
