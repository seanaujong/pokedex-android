package com.seanaujong.pokedex.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Pokemon(
    val abilities: List<Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    val forms: List<Form>,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerializedName("past_abilities")
    val pastAbilities: List<Any>,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {
    data class Ability(
        val ability: Ability,
        @SerializedName("is_hidden")
        val isHidden: Boolean,
        val slot: Int
    ) {
        data class Ability(
            val name: String,
            val url: String
        )
    }

    data class Form(
        val name: String,
        val url: String
    )

    data class GameIndice(
        @SerializedName("game_index")
        val gameIndex: Int,
        val version: Version
    ) {
        data class Version(
            val name: String,
            val url: String
        )
    }

    data class Move(
        val move: Move,
        @SerializedName("version_group_details")
        val versionGroupDetails: List<VersionGroupDetail>
    ) {
        data class Move(
            val name: String,
            val url: String
        )

        data class VersionGroupDetail(
            @SerializedName("level_learned_at")
            val levelLearnedAt: Int,
            @SerializedName("move_learn_method")
            val moveLearnMethod: MoveLearnMethod,
            @SerializedName("version_group")
            val versionGroup: VersionGroup
        ) {
            data class MoveLearnMethod(
                val name: String,
                val url: String
            )

            data class VersionGroup(
                val name: String,
                val url: String
            )
        }
    }

    data class Species(
        val name: String,
        val url: String
    )

    data class Sprites(
        @SerializedName("back_default")
        val backDefault: String,
        @SerializedName("back_female")
        val backFemale: Any,
        @SerializedName("back_shiny")
        val backShiny: String,
        @SerializedName("back_shiny_female")
        val backShinyFemale: Any,
        @SerializedName("front_default")
        val frontDefault: String,
        @SerializedName("front_female")
        val frontFemale: Any,
        @SerializedName("front_shiny")
        val frontShiny: String,
        @SerializedName("front_shiny_female")
        val frontShinyFemale: Any,
        val other: Other,
        val versions: Versions
    ) {
        data class Other(
            @SerializedName("dream_world")
            val dreamWorld: DreamWorld,
            val home: Home,
            @SerializedName("official-artwork")
            val officialArtwork: OfficialArtwork
        ) {
            data class DreamWorld(
                @SerializedName("front_default")
                val frontDefault: String,
                @SerializedName("front_female")
                val frontFemale: Any
            )

            data class Home(
                @SerializedName("front_default")
                val frontDefault: String,
                @SerializedName("front_female")
                val frontFemale: Any,
                @SerializedName("front_shiny")
                val frontShiny: String,
                @SerializedName("front_shiny_female")
                val frontShinyFemale: Any
            )

            data class OfficialArtwork(
                @SerializedName("front_default")
                val frontDefault: String,
                @SerializedName("front_shiny")
                val frontShiny: String
            )
        }

        data class Versions(
            @SerializedName("generation-i")
            val generationI: GenerationI,
            @SerializedName("generation-ii")
            val generationIi: GenerationIi,
            @SerializedName("generation-iii")
            val generationIii: GenerationIii,
            @SerializedName("generation-iv")
            val generationIv: GenerationIv,
            @SerializedName("generation-v")
            val generationV: GenerationV,
            @SerializedName("generation-vi")
            val generationVi: GenerationVi,
            @SerializedName("generation-vii")
            val generationVii: GenerationVii,
            @SerializedName("generation-viii")
            val generationViii: GenerationViii
        ) {
            data class GenerationI(
                @SerializedName("red-blue")
                val redBlue: RedBlue,
                val yellow: Yellow
            ) {
                data class RedBlue(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_gray")
                    val backGray: String,
                    @SerializedName("back_transparent")
                    val backTransparent: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_gray")
                    val frontGray: String,
                    @SerializedName("front_transparent")
                    val frontTransparent: String
                )

                data class Yellow(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_gray")
                    val backGray: String,
                    @SerializedName("back_transparent")
                    val backTransparent: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_gray")
                    val frontGray: String,
                    @SerializedName("front_transparent")
                    val frontTransparent: String
                )
            }

            data class GenerationIi(
                val crystal: Crystal,
                val gold: Gold,
                val silver: Silver
            ) {
                data class Crystal(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("back_shiny_transparent")
                    val backShinyTransparent: String,
                    @SerializedName("back_transparent")
                    val backTransparent: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_transparent")
                    val frontShinyTransparent: String,
                    @SerializedName("front_transparent")
                    val frontTransparent: String
                )

                data class Gold(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_transparent")
                    val frontTransparent: String
                )

                data class Silver(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_transparent")
                    val frontTransparent: String
                )
            }

            data class GenerationIii(
                val emerald: Emerald,
                @SerializedName("firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen,
                @SerializedName("ruby-sapphire")
                val rubySapphire: RubySapphire
            ) {
                data class Emerald(
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_shiny")
                    val frontShiny: String
                )

                data class FireredLeafgreen(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_shiny")
                    val frontShiny: String
                )

                data class RubySapphire(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_shiny")
                    val frontShiny: String
                )
            }

            data class GenerationIv(
                @SerializedName("diamond-pearl")
                val diamondPearl: DiamondPearl,
                @SerializedName("heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver,
                val platinum: Platinum
            ) {
                data class DiamondPearl(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_female")
                    val backFemale: Any,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                )

                data class HeartgoldSoulsilver(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_female")
                    val backFemale: Any,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                )

                data class Platinum(
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_female")
                    val backFemale: Any,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                )
            }

            data class GenerationV(
                @SerializedName("black-white")
                val blackWhite: BlackWhite
            ) {
                data class BlackWhite(
                    val animated: Animated,
                    @SerializedName("back_default")
                    val backDefault: String,
                    @SerializedName("back_female")
                    val backFemale: Any,
                    @SerializedName("back_shiny")
                    val backShiny: String,
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any,
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                ) {
                    data class Animated(
                        @SerializedName("back_default")
                        val backDefault: String,
                        @SerializedName("back_female")
                        val backFemale: Any,
                        @SerializedName("back_shiny")
                        val backShiny: String,
                        @SerializedName("back_shiny_female")
                        val backShinyFemale: Any,
                        @SerializedName("front_default")
                        val frontDefault: String,
                        @SerializedName("front_female")
                        val frontFemale: Any,
                        @SerializedName("front_shiny")
                        val frontShiny: String,
                        @SerializedName("front_shiny_female")
                        val frontShinyFemale: Any
                    )
                }
            }

            data class GenerationVi(
                @SerializedName("omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire,
                @SerializedName("x-y")
                val xY: XY
            ) {
                data class OmegarubyAlphasapphire(
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                )

                data class XY(
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                )
            }

            data class GenerationVii(
                val icons: Icons,
                @SerializedName("ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any
                )

                data class UltraSunUltraMoon(
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any,
                    @SerializedName("front_shiny")
                    val frontShiny: String,
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any
                )
            }

            data class GenerationViii(
                val icons: Icons
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    val frontDefault: String,
                    @SerializedName("front_female")
                    val frontFemale: Any
                )
            }
        }
    }

    data class Stat(
        @SerializedName("base_stat")
        val baseStat: Int,
        val effort: Int,
        val stat: Stat
    ) {
        data class Stat(
            val name: String,
            val url: String
        )
    }

    data class Type(
        val slot: Int,
        val type: Type
    ) {
        data class Type(
            val name: String,
            val url: String
        )
    }
}