package kopo.poly.controller;


import kopo.poly.dto.MelonDTO;
import kopo.poly.service.IMelonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class MelonController {

    @Resource(name = "MelonService")
    private IMelonService melonService;

    @GetMapping(value = "melon/collectMelonSong")
    public String collectMelonRank() throws Exception{

        log.info(this.getClass().getName() + ".collectMelonSong Start");

        String msg;

        int res = melonService.collectMelonSong();

        if (res == 1){
            msg = "success";
        }else {
            msg = "fail";
        }
        log.info(this.getClass().getName() + ".collectMelonSong End");

        return msg;
    }
    @GetMapping(value = "melon/getSongList")
    public List<MelonDTO> getSongList() throws Exception{
        log.info(this.getClass().getName() + ".getSongList Start");

        List<MelonDTO> rList = melonService.getSongList();

        log.info(this.getClass().getName() + ".getSongList End");

        return rList;
    }
    @GetMapping(value = "melon/getSingerSongCnt")
    public List<Map<String, Object>> getSingerSongCnt()
        throws Exception{

        log.info(this.getClass().getName() + ".getSingerSongCnt Start");

        List<Map<String, Object>> rList =  melonService.getSingerSongCnt();

        log.info(this.getClass().getName() + ".getSingerSongCnt End");

        return rList;
    }
}
