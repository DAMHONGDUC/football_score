package com.football_score.utils

import com.football_score.data.remote.model.League
import com.football_score.data.remote.model.Match

class Helper {
    companion object {
        fun getListLeagues(listLiveMatch: List<Match>): HashMap<Int, League>
        {
            val hashMap = hashMapOf<Int, League>();

            for (match in listLiveMatch) {
                hashMap.put(match.league.id ,match.league)
            }

            return hashMap;
        }
    }

}