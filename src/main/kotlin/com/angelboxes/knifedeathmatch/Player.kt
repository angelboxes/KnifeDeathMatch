package com.angelboxes.knifedeathmatch

import com.angelboxes.knifedeathmatch.enums.*
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.random.Random

class Player {
    private val playerId: Int
    private val character: Character
    private var state: WarriorState
    private var hp: Int

    constructor(playerNumber: Int, character: Character) {
        this.playerId = playerNumber
        this.character = character
        this.state = WarriorState.STANDBY
        this.hp = 100
    }

    fun getState(): WarriorState {
        return this.state
    }

    fun getHP(): Int {
        return this.hp
    }

    fun getPlayerId(): Int {
        return this.playerId
    }

    suspend fun executeRandomCommand(target: Player) {
        this.executeCommand(Command.getRandom(), target)
    }


    private suspend fun executeCommand(command: Command, target: Player) {
        when (command) {
            Command.ATTACK -> {
                attack(target)
            }
            Command.DEFEND -> {
                defend()
            }
            Command.DODGE -> {
                dodge()
            }

        }
    }

    private fun getSpeedBump(): Int {
        return (1 - (this.character.speed / 100))
    }

    private suspend fun attack(target: Player) {
        val move: Move = this.character.getRandomMove()
        println("Player$playerId ${character.displayName} used ${move.name}")
        attack(move, target)
        this.state = WarriorState.RECOVERY
        delay(1000L * move.recovery * getSpeedBump())
        this.state = WarriorState.STANDBY
    }

    private fun attack(move: Move, target: Player) {
        var failed = applyMoveAccuracy(move)
        if (target.isDodging()) {
            failed = Random.nextInt(100) + 1 > 66
        }
        if (failed) {
            println(" ${this.character.displayName}'s ${move.name} failed")
            return
        }
        val damage: Int = calculateDamage(this, move, target)
        target.takeDamage(damage)
        if (target.isKO()) {
            this.state = WarriorState.NONE
        }

    }

    private fun applyMoveAccuracy(move: Move): Boolean {
        return ((Random.nextInt(100) + 1) > move.accuracy)
    }

    fun takeDamage(damage: Int) {
        var totalDamage = damage;
        if (totalDamage > this.hp) {
            totalDamage = hp
        }
        this.hp = hp - totalDamage;
        println("${character.displayName} took $totalDamage HP of damage. HP: $hp / 100")
    }

    private fun calculateDamage(attacker: Player, move: Move, target: Player): Int {
        var advantage: Double = WarriorClass.getDamage(attacker.character.warriorClass, target.character.warriorClass)
        var attackTotal = attacker.character.attack * advantage
        var defensePower: Double = 1.00
        if (target.isDefending()) {
            defensePower = 1.5
        }
        var defenseTotal = target.character.defense * defensePower
        var damage = ((attackTotal / defenseTotal) * move.power) / 25
        if (damage.equals(0.00)) {
            damage = 1.00
        }
        return damage.roundToInt()
    }

    private suspend fun defend() {
        println("${character.displayName} is defending")
        this.state = WarriorState.DEFENSE
        delay(2000)
        this.state = WarriorState.STANDBY
    }

    private suspend fun dodge() {
        println("${character.displayName} is ready to dodge attacks")
        this.state = WarriorState.DODGE
        delay(1500)
        this.state = WarriorState.STANDBY
    }

    fun isKO(): Boolean {
        return (hp == 0)
    }

    fun isStanding(): Boolean {
        return (this.state == WarriorState.STANDBY)
    }

    fun isRecovering(): Boolean {
        return (this.state == WarriorState.RECOVERY)
    }

    fun isDodging(): Boolean {
        return (this.state == WarriorState.DODGE)
    }

    fun isDefending(): Boolean {
        return (this.state == WarriorState.DEFENSE)
    }

}