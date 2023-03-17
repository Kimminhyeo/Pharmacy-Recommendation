package com.min.pharmacyrecommendation.pharmacy.service;

import com.min.pharmacyrecommendation.api.dto.DocumentDto;
import com.min.pharmacyrecommendation.api.dto.KakaoApiResponseDto;
import com.min.pharmacyrecommendation.api.service.KakaoAddressSearchService;
import com.min.pharmacyrecommendation.direction.entity.Direction;
import com.min.pharmacyrecommendation.direction.service.DirectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyRecommendationService {

    private final KakaoAddressSearchService kakaoAddressSearchService;
    private final DirectionService directionService;

    public void recommendPharmacyList(String address){

        KakaoApiResponseDto kakaoApiResponseDto = kakaoAddressSearchService.requestAddressSearch(address);

        if(Objects.isNull(kakaoApiResponseDto) || CollectionUtils.isEmpty(kakaoApiResponseDto.getDocumentList())){
            log.error("[PharmacyRecommendationService recommendPharmacyList fail] Input address: {}", address);
            return;
        }

        DocumentDto documentDto = kakaoApiResponseDto.getDocumentList().get(0);

        //List<Direction> directionList = directionService.buildDirectionList(documentDto);
        List<Direction> directionList = directionService.buildDirectionListByCategoryApi(documentDto);

        directionService.saveAll(directionList);

    }
}
