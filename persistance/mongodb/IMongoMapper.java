package kopo.poly.persistance.mongodb;


import kopo.poly.dto.MongoDTO;

public interface IMongoMapper {

    /**
     * 간단한 데이터 저장하기
     *
     * @param pDTO 저장될 정보
     * @param colNm
     * @return 저장 결과
     */
    int insertData(MongoDTO pDTO, String colNm) throws Exception;

}
