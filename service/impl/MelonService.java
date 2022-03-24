package kopo.poly.service.impl;

import kopo.poly.dto.MelonDTO;
import kopo.poly.persistance.mongodb.IMelonMapper;
import kopo.poly.service.IMelonService;
import kopo.poly.util.CmmUtil;
import kopo.poly.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("MelonService")
public class MelonService implements IMelonService {

    @Resource(name = "MelonMapper")
    private IMelonMapper melonMapper;


    @Override
    public int collectMelonSong() throws Exception {
        log.info(this.getClass().getName() + ".collectMelonRank Start");

        int res = 0;

        List<MelonDTO> pList = new LinkedList<>();

        String url = "https://www.melon.com/chart/index.htm";

        Document doc = Jsoup.connect(url).get();

        Elements element = doc.select("div.service_list_song");

        for (Element songInfo : element.select("div.wrap_song_info")) {

            String song  = CmmUtil.nvl(songInfo.select("div.ellipsis.rank01 a").text());
            String singer = CmmUtil.nvl(songInfo.select("div.ellipsis.rank02 a").eq(0).text());

            log.info("song : "  + song);
            log.info("singer: " + singer);

            if ((song.length() > 0) && (singer.length() > 0)) {

                    MelonDTO pDTO = new MelonDTO();
                    pDTO.setCollectTime(DateUtil.getDateTime("yyyyMMddhhmmss"));
                    pDTO.setSong(song);
                    pDTO.setSinger(singer);

                    pList.add(pDTO);
            }
        }
        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        res = melonMapper.insertSong(pList, colNm);

        log.info(this.getClass().getName() + ".collectMelonSong End");

        return res;
    }

    @Override
    public List<MelonDTO> getSongList() throws Exception {
        log.info(this.getClass().getName() + ".getSongList Start");

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        List<MelonDTO> rList =  new LinkedList<>();

        rList = melonMapper.getSongList(colNm);

        if (rList == null){
            rList = new LinkedList<>();
        }
        log.info(this.getClass().getName() + ".getSongList End");

        return rList;
    }

    @Override
    public List<Map<String, Object>> getSingerSongCnt() throws Exception {

        log.info(this.getClass().getName() + ".getSingerSongCnt Start");

        String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        List<Map<String, Object>> rList = melonMapper.getSingerSongCnt(colNm);

        if (rList == null) {
            rList = new LinkedList<>();
        }
        log.info(this.getClass().getName()+ ".getSingerSongCnt End");

        return rList;
    }
}
