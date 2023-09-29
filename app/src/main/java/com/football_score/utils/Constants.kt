package com.football_score.utils

object Constants {

    const val BASE_URL: String = "https://v3.football.api-sports.io"
//    const val BASE_URL: String = "https://3f5c-42-118-236-202.ngrok.io"
    const val X_RAPIDAPI_HOST: String = "v3.football.api-sports.io"
    const val X_RAPIDAPI_KEY: String = "3e7eee2b95455986556d8ecbe37b78f7"
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
