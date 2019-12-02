package com.angelboxes.knifedeathmatch.enums

import kotlin.random.Random

enum class Command {
    ATTACK,
    DEFEND,
    DODGE;

    companion object {
        fun getRandom(): Command {
            val randomIndex = Random.nextInt(values().size)
            return values()[randomIndex]
        }
    }
}
