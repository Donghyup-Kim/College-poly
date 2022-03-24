package kopo.poly.service;

import kopo.poly.dto.MelonDTO;

import java.util.List;
import java.util.Map;

public interface IMelonService {

    int collectMelonSong() throws Exception;

    List<MelonDTO> getSongList() throws Exception;

    List<Map<String, Object>> getSingerSongCnt() throws Exception;
}
