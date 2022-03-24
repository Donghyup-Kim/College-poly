package kopo.poly.service.impl;

import kopo.poly.dto.MongoDTO;
import kopo.poly.persistance.mongodb.IMongoMapper;
import kopo.poly.service.IMongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("MongoService")
public class MongoService implements IMongoService {

    @Resource(name = "MongoMapper")
    private IMongoMapper mongoMapper;

    @Override
    public  void mongoTest() throws Exception{
        //로그 찍기
        log.info(this.getClass().getName() + ".mongoTest Start!");

        // 생성할 컬렉션명
        String colNm = "MONGODB_TEST";

        MongoDTO pDTO = new MongoDTO();
        pDTO.setUser_nm("신대현");
        pDTO.setAddr("제주도");
        pDTO.setEmail("style0986@naver.com");

        // MongoDB에 데이터 저장하기
        mongoMapper.insertData(pDTO, colNm);

        // 로그 찍기
        log.info(this.getClass().getName() + ".mongoTest END!");


    }


}
