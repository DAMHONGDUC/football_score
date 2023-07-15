package com.football_score.utils

import com.football_score.domain.model.League
import com.football_score.domain.model.Match

import java.util.*

class Helper {
    companion object {
        fun getListLeagues(listLiveMatch: List<Match>): HashMap<Int, League> {
            val hashMap = hashMapOf<Int, League>();

            for (match in listLiveMatch) {
                hashMap.put(match.league.id, match.league)
            }

            return hashMap;
        }
    }
}