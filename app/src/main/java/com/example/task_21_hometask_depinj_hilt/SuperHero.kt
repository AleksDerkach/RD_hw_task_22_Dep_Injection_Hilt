package com.example.task_21_hometask_depinj_hilt

data class SuperHero(
    var id: Int = 0,
    var name: String = "",
    var slug: String = "",
    var powerstats: PowerStats,
    var appearance: Appearance,
    var biography: Biography,
    var work: Work,
    var connections: Connections,
    var images: Images
)

data class Appearance(
    var gender: String = "",
    var race: String = "",
    var height: List<String>,
    var weight: List<String>,
    var eyeColor: String = "",
    var hairColor: String = ""
)

data class Biography(
    var fullName: String = "",
    var alterEgos: String = "",
    var aliases: List<String>,
    var placeOfBirth: String = "",
    var firstAppearance: String = "",
    var publisher: String = "",
    var alignment: String = ""
)

data class Connections(
    var groupAffiliation: String = "",
    var relatives: String = ""
)

data class Images(
    var xs: String = "",
    var sm: String = "",
    var md: String = "",
    var lg: String = ""
)

data class PowerStats(
    var intelligence: Int = 0,
    var strength: Int = 0,
    var speed: Int = 0,
    var durability: Int = 0,
    var power: Int = 0,
    var combat: Int = 0
)

data class Work(
    var occupation: String = "",
    var base: String = ""
)