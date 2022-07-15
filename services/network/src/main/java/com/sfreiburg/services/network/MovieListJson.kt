package com.sfreiburg.services.network

import com.squareup.moshi.JsonClass

/*
{
  "page":1,
  "results":[
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
    },
    {
      "adult":false,
      "backdrop_path":"/p1F51Lvj3sMopG948F5HsBbl43C.jpg",
      "genre_ids":[
        28,
        12,
        14
      ],
      "id":616037,
      "media_type":"movie",
      "title":"Thor: Love and Thunder",
      "original_language":"en",
      "original_title":"Thor: Love and Thunder",
      "overview":"After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Mighty Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.",
      "popularity":4925.978,
      "poster_path":"/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
      "release_date":"2022-07-06",
      "video":false,
      "vote_average":6.962,
      "vote_count":595
    },
    {
      "adult":false,
      "backdrop_path":"/wo3l9p0S7pcvwlzlndtKgq0peRJ.jpg",
      "genre_ids":[
        12,
        28,
        878
      ],
      "id":507086,
      "media_type":"movie",
      "title":"Jurassic World Dominion",
      "original_language":"en",
      "original_title":"Jurassic World Dominion",
      "overview":"Four years after Isla Nublar was destroyed, dinosaurs now live—and hunt—alongside humans all over the world. This fragile balance will reshape the future and determine, once and for all, whether human beings are to remain the apex predators on a planet they now share with history’s most fearsome creatures.",
      "popularity":2651.177,
      "poster_path":"/kAVRgw7GgK1CfYEJq8ME6EvRIgU.jpg",
      "release_date":"2022-06-01",
      "video":false,
      "vote_average":6.58,
      "vote_count":1077
    },
    {
      "adult":false,
      "backdrop_path":"/wUwizGzbTk5CTiKBnE4Pq1MONwD.jpg",
      "genre_ids":[
        16,
        12,
        10751,
        14
      ],
      "id":560057,
      "media_type":"movie",
      "title":"The Sea Beast",
      "original_language":"en",
      "original_title":"The Sea Beast",
      "overview":"The life of a legendary sea monster hunter is turned upside down when a young girl stows away on his ship.",
      "popularity":135.793,
      "poster_path":"/9Zfv4Ap1e8eKOYnZPtYaWhLkk0d.jpg",
      "release_date":"2022-06-24",
      "video":false,
      "vote_average":7.4,
      "vote_count":121
    },
    {
      "adult":false,
      "backdrop_path":"/qTkJ6kbTeSjqfHCFCmWnfWZJOtm.jpg",
      "genre_ids":[
        10751,
        16,
        12,
        35,
        14
      ],
      "id":438148,
      "media_type":"movie",
      "title":"Minions: The Rise of Gru",
      "original_language":"en",
      "original_title":"Minions: The Rise of Gru",
      "overview":"A fanboy of a supervillain supergroup known as the Vicious 6, Gru hatches a plan to become evil enough to join them, with the backup of his followers, the Minions.",
      "popularity":15810.27,
      "poster_path":"/wKiOkZTN9lUUUNZLmtnwubZYONg.jpg",
      "release_date":"2022-06-29",
      "video":false,
      "vote_average":7.85,
      "vote_count":253
    },
    {
      "adult":false,
      "backdrop_path":"/5PnypKiSj2efSPqThNjTXz8jwOg.jpg",
      "genre_ids":[
        14,
        28
      ],
      "id":759175,
      "media_type":"movie",
      "title":"The Princess",
      "original_language":"en",
      "original_title":"The Princess",
      "overview":"A beautiful, strong-willed young royal refuses to wed the cruel sociopath to whom she is betrothed and is kidnapped and locked in a remote tower of her father’s castle. With her scorned, vindictive suitor intent on taking her father’s throne, the princess must protect her family and save the kingdom.",
      "popularity":775.083,
      "poster_path":"/gt9s8TtZZ36TXF1CE1y19rSpOZu.jpg",
      "release_date":"2022-06-16",
      "video":false,
      "vote_average":6.435,
      "vote_count":92
    },
    {
      "adult":false,
      "backdrop_path":"/AaV1YIdWKnjAIAOe8UUKBFm327v.jpg",
      "genre_ids":[
        28,
        18
      ],
      "id":361743,
      "media_type":"movie",
      "title":"Top Gun: Maverick",
      "original_language":"en",
      "original_title":"Top Gun: Maverick",
      "overview":"After more than thirty years of service as one of the Navy’s top aviators, and dodging the advancement in rank that would ground him, Pete “Maverick” Mitchell finds himself training a detachment of TOP GUN graduates for a specialized mission the likes of which no living pilot has ever seen.",
      "popularity":952.418,
      "poster_path":"/62HCnUTziyWcpDaBO2i1DX17ljH.jpg",
      "release_date":"2022-05-24",
      "video":false,
      "vote_average":8.36,
      "vote_count":1523
    },
    {
      "adult":false,
      "backdrop_path":"/zGLHX92Gk96O1DJvLil7ObJTbaL.jpg",
      "genre_ids":[
        14,
        12,
        28
      ],
      "id":338953,
      "media_type":"movie",
      "title":"Fantastic Beasts: The Secrets of Dumbledore",
      "original_language":"en",
      "original_title":"Fantastic Beasts: The Secrets of Dumbledore",
      "overview":"Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers.",
      "popularity":2041.714,
      "poster_path":"/8ZbybiGYe8XM4WGmGlhF0ec5R7u.jpg",
      "release_date":"2022-04-06",
      "video":false,
      "vote_average":6.836,
      "vote_count":2208
    },
    {
      "adult":false,
      "backdrop_path":"/3oTeRLZQ16HGmVXAvEnVh90PhS6.jpg",
      "genre_ids":[
        28,
        35,
        53
      ],
      "id":667739,
      "media_type":"movie",
      "title":"The Man from Toronto",
      "original_language":"en",
      "original_title":"The Man from Toronto",
      "overview":"In a case of mistaken identity, the world’s deadliest assassin, known as the Man from Toronto, and a New York City screw-up are forced to team up after being confused for each other at an Airbnb.",
      "popularity":1521.559,
      "poster_path":"/uTCfTibqtk4f90cC59bLPMOmsfc.jpg",
      "release_date":"2022-06-24",
      "video":false,
      "vote_average":6.204,
      "vote_count":311
    },
    {
      "adult":false,
      "backdrop_path":"/ocUp7DJBIc8VJgLEw1prcyK1dYv.jpg",
      "genre_ids":[
        28,
        12,
        878
      ],
      "id":634649,
      "media_type":"movie",
      "title":"Spider-Man: No Way Home",
      "original_language":"en",
      "original_title":"Spider-Man: No Way Home",
      "overview":"Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
      "popularity":1939.954,
      "poster_path":"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
      "release_date":"2021-12-15",
      "video":false,
      "vote_average":8.06,
      "vote_count":14061
    },
    {
      "adult":false,
      "backdrop_path":"/wp3vpSWAIjKSEeYb8F5NSZfONqw.jpg",
      "genre_ids":[
        28,
        12,
        878
      ],
      "id":545611,
      "media_type":"movie",
      "title":"Everything Everywhere All at Once",
      "original_language":"en",
      "original_title":"Everything Everywhere All at Once",
      "overview":"An aging Chinese immigrant is swept up in an insane adventure, where she alone can save what's important to her by connecting with the lives she could have led in other universes.",
      "popularity":310.993,
      "poster_path":"/w3LxiVYdWWRvEVdn5RYq6jIqkb1.jpg",
      "release_date":"2022-03-24",
      "video":false,
      "vote_average":8.276,
      "vote_count":927
    },
    {
      "adult":false,
      "backdrop_path":"/b0PlSFdDwbyK0cf5RxwDpaOJQvQ.jpg",
      "genre_ids":[
        80,
        9648,
        53
      ],
      "id":414906,
      "media_type":"movie",
      "title":"The Batman",
      "original_language":"en",
      "original_title":"The Batman",
      "overview":"In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.",
      "popularity":1097.508,
      "poster_path":"/74xTEgt7R36Fpooo50r9T25onhq.jpg",
      "release_date":"2022-03-01",
      "video":false,
      "vote_average":7.762,
      "vote_count":5495
    },
    {
      "adult":false,
      "backdrop_path":"/6d1mHKcozT5AaZeI76ehJrBt0hr.jpg",
      "genre_ids":[
        27
      ],
      "id":864370,
      "media_type":"movie",
      "title":"Incantation",
      "original_language":"zh",
      "original_title":"咒",
      "overview":"Inspired by a true story of a family who believed they were possessed by spirits, this film follows a woman who must protect her child from a curse.  WARNING: This is a cursed video, it might contain certain risks to watch ; For those who dares to follow, please solve the puzzle of my daughter's curse with me .",
      "popularity":80.35,
      "poster_path":"/6zltP23zLGPogsHZUazSrrwNuKs.jpg",
      "release_date":"2022-03-18",
      "video":false,
      "vote_average":7.3,
      "vote_count":27
    },
    {
      "adult":false,
      "backdrop_path":"/gG9fTyDL03fiKnOpf2tr01sncnt.jpg",
      "genre_ids":[
        28,
        878,
        14
      ],
      "id":526896,
      "media_type":"movie",
      "title":"Morbius",
      "original_language":"en",
      "original_title":"Morbius",
      "overview":"Dangerously ill with a rare blood disorder, and determined to save others suffering his same fate, Dr. Michael Morbius attempts a desperate gamble. What at first appears to be a radical success soon reveals itself to be a remedy potentially worse than the disease.",
      "popularity":1746.991,
      "poster_path":"/6JjfSchsU6daXk2AKX8EEBjO3Fm.jpg",
      "release_date":"2022-03-30",
      "video":false,
      "vote_average":6.435,
      "vote_count":2015
    },
    {
      "adult":false,
      "backdrop_path":"/tqUD26YGjKmFqOJAgbNBah1gX0N.jpg",
      "genre_ids":[
        16,
        878,
        12,
        28,
        10751
      ],
      "id":718789,
      "media_type":"movie",
      "title":"Lightyear",
      "original_language":"en",
      "original_title":"Lightyear",
      "overview":"Legendary Space Ranger Buzz Lightyear embarks on an intergalactic adventure alongside a group of ambitious recruits and his robot companion Sox.",
      "popularity":987.727,
      "poster_path":"/vpILbP9eOQEtdQgl4vgjZUNY07r.jpg",
      "release_date":"2022-06-15",
      "video":false,
      "vote_average":7.008,
      "vote_count":446
    },
    {
      "adult":false,
      "backdrop_path":"/ulkWS7Atv0vv33KVCSAmNizAmJd.jpg",
      "genre_ids":[
        878,
        53
      ],
      "id":615469,
      "media_type":"movie",
      "title":"Spiderhead",
      "original_language":"en",
      "original_title":"Spiderhead",
      "overview":"A prisoner in a state-of-the-art penitentiary begins to question the purpose of the emotion-controlling drugs he's testing for a pharmaceutical genius.",
      "popularity":1533.232,
      "poster_path":"/5hTK0J9SGPLSTFwcbU0ELlJsnAY.jpg",
      "release_date":"2022-06-15",
      "video":false,
      "vote_average":5.802,
      "vote_count":614
    },
    {
      "adult":false,
      "backdrop_path":"/fqw8nJLPRgKRyFSDC0xBsC06NGC.jpg",
      "genre_ids":[
        28,
        12,
        14
      ],
      "id":639933,
      "media_type":"movie",
      "title":"The Northman",
      "original_language":"en",
      "original_title":"The Northman",
      "overview":"Prince Amleth is on the verge of becoming a man when his father is brutally murdered by his uncle, who kidnaps the boy's mother. Two decades later, Amleth is now a Viking who's on a mission to save his mother, kill his uncle and avenge his father.",
      "popularity":1314.18,
      "poster_path":"/8p9zXB7M78nZpm215zHfqpknMeM.jpg",
      "release_date":"2022-04-07",
      "video":false,
      "vote_average":7.221,
      "vote_count":1817
    },
    {
      "adult":false,
      "backdrop_path":"/m0YjB4VfghKey8Ppsmz8qCd0v1m.jpg",
      "genre_ids":[
        28,
        35,
        80
      ],
      "id":648579,
      "media_type":"movie",
      "title":"The Unbearable Weight of Massive Talent",
      "original_language":"en",
      "original_title":"The Unbearable Weight of Massive Talent",
      "overview":"Creatively unfulfilled and facing financial ruin, Nick Cage must accept a $1 million offer to attend the birthday of a dangerous superfan. Things take a wildly unexpected turn when Cage is recruited by a CIA operative and forced to live up to his own legend, channeling his most iconic and beloved on-screen characters in order to save himself and his loved ones.",
      "popularity":1039.616,
      "poster_path":"/aqhLeieyTpTUKPOfZ3jzo2La0Mq.jpg",
      "release_date":"2022-04-20",
      "video":false,
      "vote_average":7.048,
      "vote_count":457
    },
    {
      "adult":false,
      "backdrop_path":"/p5vSYjaWGPE0lrrLXGIc3RXv0VA.jpg",
      "genre_ids":[
        53,
        28
      ],
      "id":888195,
      "media_type":"movie",
      "title":"Hot Seat",
      "original_language":"en",
      "original_title":"Hot Seat",
      "overview":"An ex-hacker is forced to break into high-level banking institutions, another man must try to penetrate the booby-trapped building to get the young man off the hot seat.",
      "popularity":192.972,
      "poster_path":"/TUmSO5EPIZAfRSOEjmbrgbTw8i.jpg",
      "release_date":"2022-07-01",
      "video":false,
      "vote_average":7.318,
      "vote_count":11
    },
    {
      "adult":false,
      "backdrop_path":"/egoyMDLqCxzjnSrWOz50uLlJWmD.jpg",
      "genre_ids":[
        28,
        12,
        10751,
        35
      ],
      "id":675353,
      "media_type":"movie",
      "title":"Sonic the Hedgehog 2",
      "original_language":"en",
      "original_title":"Sonic the Hedgehog 2",
      "overview":"After settling in Green Hills, Sonic is eager to prove he has what it takes to be a true hero. His test comes when Dr. Robotnik returns, this time with a new partner, Knuckles, in search for an emerald that has the power to destroy civilizations. Sonic teams up with his own sidekick, Tails, and together they embark on a globe-trotting journey to find the emerald before it falls into the wrong hands.",
      "popularity":2158.913,
      "poster_path":"/6DrHO1jr3qVrViUO6s6kFiAGM7.jpg",
      "release_date":"2022-03-30",
      "video":false,
      "vote_average":7.697,
      "vote_count":2435
    }
  ],
  "total_pages":1000,
  "total_results":20000
}
 */
@JsonClass(generateAdapter = true)
data class MovieListJson(
    val results: List<MovieJson>,
)
