package com.football_score.utils

import com.football_score.domain.model.League
import com.football_score.domain.model.Match

class Helper {
    companion object {
        fun getListLeagues(listLiveMatch: List<com.football_score.domain.model.Match>): HashMap<Int, com.football_score.domain.model.League>
        {
            val hashMap = hashMapOf<Int, com.football_score.domain.model.League>();

            for (match in listLiveMatch) {
                hashMap.put(match.league.id ,match.league)
            }

            return hashMap;
        }
    }

}