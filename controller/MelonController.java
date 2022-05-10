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
    public List<MelonDTO> getSingerSongCnt()
        throws Exception{

        log.info(this.getClass().getName() + ".getSingerSongCnt Start");

        List<MelonDTO> rList =  melonService.getSingerSongCnt();

        log.info(this.getClass().getName() + ".getSingerSongCnt End");

        return rList;
    }
    @GetMapping(value = "melon/getSingerSong")
    public List<MelonDTO> getSingersong() throws Exception{

        log.info(this.getClass().getName() + ".getSingerSonger Start");

        List<MelonDTO> rList = melonService.getSingerSong();

        log.info(this.getClass().getName() + ".getSingerSong End");

        return rList;
    }
    @GetMapping(value = "melon/collectMelonSongMany")
    public String collectMelonSongMany() throws Exception{

        log.info(this.getClass().getName() + ".collectMelonSongMany Start");

        String msg;
        int res = melonService.collectMelonSongMany();

        if(res == 1){
            msg = "success";

        }else{
            msg = "fail";
        }
        log.info(this.getClass().getName() + "collectMelonSongMany End");

        return msg;

    }
    @GetMapping(value = "melon/updateBTSName")
    public String btsAddField() throws Exception{

        log.info(this.getClass().getName() + ".btsAddNickname Start");

        String msg;

        int res = melonService.updateBTSName();

        if(res == 1){
            msg = "success";
        }else{
            msg = "fail";
        }
        log.info(this.getClass().getName() + ".btsAddNickname End");

        return msg;
    }

    @GetMapping(value = "melon/btsAddNickname")
    public String updateAddBTSNickname() throws Exception{

        log.info(this.getClass().getName() + ".btsAddNickname Start");

        String msg;

        int res = melonService.updateAddBTSNickname();

        if(res == 1){
            msg = "success";

        }else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".btsAddNickname End");

        return msg;
    }

    @GetMapping(value = "melon/btsAddMember")
    public String btsAddMember() throws Exception{

        log.info(this.getClass().getName() + ".btsAddMember Start");

        String msg;

        int res = melonService.updateAddBTSMember();

        if(res == 1){
            msg = "success";

        }else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".btsAddMember End");

        return msg;
    }
    @GetMapping(value = "melon/deleteSong")
    public String deleteSong() throws Exception{

        log.info(this.getClass().getName() + ".deleteSong Start");

        String msg;

        int res = melonService.deleteSong();

        if (res == 1){

            msg = "success";
        }else {
            msg =  "fail";
        }
        log.info(this.getClass().getName() + ".deleteSong End");

        return msg;
    }
    @GetMapping(value = "melon/updateManySong")
    public String updateManySong() throws Exception{

        log.info(this.getClass().getName() + ".updateManySong Start");

        String msg;

        int res = melonService.updateManySong();

        if (res == 1){

            msg = "success";
        }else {
            msg =  "fail";
        }
        log.info(this.getClass().getName() + ".updateManySong End");

        return msg;
    }

}

