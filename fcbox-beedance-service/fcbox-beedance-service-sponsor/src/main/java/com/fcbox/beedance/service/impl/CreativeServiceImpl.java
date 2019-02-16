package com.fcbox.beedance.service.impl;

import com.fcbox.beedance.dao.CreativeRepository;
import com.fcbox.beedance.entity.Creative;
import com.fcbox.beedance.vo.CreativeRequest;
import com.fcbox.beedance.vo.CreativeResponse;
import com.fcbox.beedance.service.ICreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sss
 * @date 2019/2/10
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}

