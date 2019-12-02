package com.angelboxes.knifedeathmatch

import com.angelboxes.knifedeathmatch.enums.Character

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println("PRESS START")
        printCharacterMenu()
        var player1Option = readLine()!!.toInt()
        var player1Character = Character.values()[player1Option - 1]
        println("Choose player 2")
        printCharacterMenu()
        var player2Option = readLine()!!.toInt()
        var player2Character = Character.values()[player2Option - 1]
        var player1 = Player(1, player1Character)
        var player2 = Player(2, player2Character)
        var battle: Battle = Battle(player1, player2)
        battle.start()
    }

    fun printCharacterMenu() {
        for ((index, character) in Character.values().withIndex()) {
            println("${index + 1}. ${character.name}")
        }
    }

}


