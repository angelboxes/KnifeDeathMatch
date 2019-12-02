package com.angelboxes.knifedeathmatch.enums

enum class WarriorClass() {
    SHIELDER,
    SABER,
    ARCHER,
    LANCER,
    RIDER,
    ASSASIN,
    CASTER,
    RULER,
    MOONCANCER,
    AVENGER,
    ALTEREGO,
    FOREIGNER,
    BERSERKER,
    ;


    companion object {
        fun getDamage(attacker: WarriorClass, target: WarriorClass): Double {
            var damage = 1.0;

            return applyStrength(damage, attacker, target)

        }

        fun applyStrength(damage: Double, attacker: WarriorClass, target: WarriorClass): Double {
            var totalDamage = damage
            when (attacker) {
                SABER -> {
                    when (target) {
                        LANCER, BERSERKER -> {
                            totalDamage += 1
                        }
                        ARCHER, RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                ARCHER -> {
                    when (target) {
                        SABER, BERSERKER -> {
                            totalDamage += 1
                        }
                        LANCER, RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                LANCER -> {
                    when (target) {
                        ARCHER, BERSERKER -> {
                            totalDamage += 1
                        }
                        SABER, RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                RIDER -> {
                    when (target) {
                        CASTER, BERSERKER -> {
                            totalDamage += 1
                        }
                        ASSASIN, RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                ASSASIN -> {
                    when (target) {
                        RIDER, BERSERKER -> {
                            totalDamage += 1
                        }
                        CASTER, RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                CASTER -> {
                    when (target) {
                        ASSASIN, BERSERKER -> {
                            totalDamage += 1
                        }
                        RIDER, RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                RULER -> {
                    when (target) {
                        BERSERKER, MOONCANCER -> {
                            totalDamage += 1
                        }
                        AVENGER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                MOONCANCER -> {
                    when (target) {
                        BERSERKER, AVENGER -> {
                            totalDamage += 1
                        }
                        RULER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                AVENGER -> {
                    when (target) {
                        BERSERKER, RULER -> {
                            totalDamage += 1
                        }
                        MOONCANCER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                ALTEREGO -> {
                    when (target) {
                        RIDER, CASTER, ASSASIN, BERSERKER, FOREIGNER -> {
                            totalDamage += 1
                        }
                        SABER, ARCHER, LANCER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                FOREIGNER -> {
                    when (target) {
                        BERSERKER -> {
                            totalDamage += 1
                        }
                        ALTEREGO -> {
                            totalDamage -= 0.5
                        }
                    }
                }
                BERSERKER -> {
                    when (target) {
                        SABER, ARCHER, LANCER, RIDER, ASSASIN, CASTER, RULER, MOONCANCER, AVENGER, ALTEREGO -> {
                            totalDamage += 1
                        }
                        FOREIGNER -> {
                            totalDamage -= 0.5
                        }
                    }
                }
            }
            return totalDamage
        }

    }
}