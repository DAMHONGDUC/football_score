package com.football_score.utils

object EndPoint {
    const val GET_ALL_LIVE_MATCH: String = "/fixtures?live=all"

    const val GET_ALL_HOT_MATCH: String = "/fixtures?live=all"
}

// Premier League -> leagues = 39

/* GET all team of Premier League season 2022
    curl --location --request POST 'https://v3.football.api-sports.io/teams?league=39&season=2022&country=England' \
    --header 'x-rapidapi-host: v3.football.api-sports.io' \
    --header 'x-rapidapi-key: 3e7eee2b95455986556d8ecbe37b78f7'
 */


/* GET all match of Premier League season 2022 with some params
    curl --location --request POST 'https://v3.football.api-sports.io/fixtures?league=39&season=2022&team=50&from=2023-05-19&to=2023-06-19' \
    --header 'x-rapidapi-host: v3.football.api-sports.io' \
    --header 'x-rapidapi-key: 3e7eee2b95455986556d8ecbe37b78f7'
 */

