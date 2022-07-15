package com.sfreiburg.services.network

import com.squareup.moshi.JsonClass

/*
{
      "adult":false,
      "backdrop_path":"/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
      "genre_ids":[
        14,
        28,
        12
      ],
      "id":453395,
      "media_type":"movie",
      "title":"Doctor Strange in the Multiverse of Madness",
      "original_language":"en",
      "original_title":"Doctor Strange in the Multiverse of Madness",
      "overview":"Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
      "popularity":5940.233,
      "poster_path":"/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
      "release_date":"2022-05-04",
      "video":false,
      "vote_average":7.528,
      "vote_count":4275
    }
 */
@JsonClass(generateAdapter = true)
data class MovieJson(
    val id: Int,
    val title: String,
    val overview: String,
    val backdrop_path: String?,
    val poster_path: String?,
)
