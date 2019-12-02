package com.angelboxes.knifedeathmatch.enums

import kotlin.random.Random

enum class Character(
    val displayName: String,
    val attack: Int, val defense: Int,
    val speed: Int, val warriorClass: WarriorClass, val moves: Array<Move>
) {
    BUTCHER("The Butcher", 50, 30, 20, WarriorClass.BERSERKER, arrayOf(Move.CHOPPING_KNIFE, Move.SLAUGHTERHOUSE)),
    LANCE("Kain", 45, 40, 25, WarriorClass.LANCER, arrayOf(Move.IMPALE, Move.SLASH)),
    ARROW("William T.", 35, 30, 35, WarriorClass.ARCHER, arrayOf(Move.APPLE_SHOT, Move.VERY_SHARP_FLAME_ARROW)),
    CHEF("Gordon R.", 30, 35, 35, WarriorClass.FOREIGNER, arrayOf(Move.KNIFE_IN_GUTS_OUT, Move.BLENDER_BLADE)),
    CHILD("Ness", 45, 20, 35, WarriorClass.CASTER, arrayOf(Move.CUT, Move.PSYCHO_KNIFE, Move.FALLING_KNIVES)),
    CIRCUS(
        "Circus Man",
        30,
        35,
        35,
        WarriorClass.ASSASIN,
        arrayOf(Move.THE_GREATES_KNIFE_MAN, Move.KNIFE_TOSS, Move.LAST_LAUGH_LAST_KNIFE)
    ),
    GIRL("The Boss", 40, 30, 30, WarriorClass.ALTEREGO, arrayOf(Move.CUT, Move.FEELING_SLICER, Move.SQUAD_ATTACK)),
    SHIELD("Gardna", 30, 60, 10, WarriorClass.SHIELDER, arrayOf(Move.CUT, Move.LIVING_MACE, Move.MOVING_WALLS)),
    WEATHER_CASTER(
        "Weather Woman",
        40,
        20,
        40,
        WarriorClass.CASTER,
        arrayOf(Move.CUTTING_WORDS, Move.CLOUDY_WITH_CHANCE_KNIFES)
    ),
    MUSICIAN("Punk", 30, 20, 50, WarriorClass.RULER, arrayOf(Move.STREET_KNIFE, Move.BLEEDING_EARS)),
    RACER(
        "Racer X",
        15,
        25,
        60,
        WarriorClass.RIDER,
        arrayOf(Move.QUICK_CUT, Move.RUN_INTO_MY_KNIFE, Move.KNIVES_FLOOR)
    );

    fun getRandomMove(): Move {
        val randomIndex = Random.nextInt(moves.size)
        return moves[randomIndex]
    }

}