package umc.easyexcel.service.FunctionsService;

import umc.easyexcel.domain.Functions;

import java.util.List;

public interface FunctionsQueryService {

    List<Functions> getFunctionsSortingList(String firstSorting, String lastSorting); // sort 타입(A-H,I-P)에 따라 정렬 조회

    List<Functions> getFunctionsSearchList(String keyword); // 함수 검색
}
