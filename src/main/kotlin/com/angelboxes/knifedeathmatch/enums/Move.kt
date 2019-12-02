package com.angelboxes.knifedeathmatch.enums

enum class Move(val power: Int, val accuracy: Int, val recovery: Int) {
    QUICK_CUT(50, 100, 1),
    CUT(50, 100, 2),
    SLASH(50, 100, 2),
    BLENDER_BLADE(50, 90, 2),
    STREET_KNIFE(70, 100, 2),
    BLEEDING_EDGE(90, 85, 4),
    KNIFE_TOSS(90, 90, 4),
    LIVING_MACE(90, 80, 4),
    CHOPPING_KNIFE(90, 90, 4),
    RUN_INTO_MY_KNIFE(90, 100, 2),
    SHARP_CHAIN(90, 90, 4),
    PSYCHO_KNIFE(100, 90, 4),
    APPLE_SHOT(110, 90, 4),
    DOUBLE_CHOP(100, 80, 4),
    LAUGHING_KNIFE(100, 90, 4),
    KNIFE_AND_CHAIN(100, 90, 4),
    THE_GREATES_KNIFE_MAN(100, 90, 3),
    KNIFE_IN_GUTS_OUT(100, 90, 3),
    FEELING_SLICER(100, 90, 3),
    CUTTING_WORDS(100, 90, 3),
    FALLING_KNIVES(200, 80, 6),
    MOVING_WALLS(210, 70, 6),
    VERY_SHARP_FLAME_ARROW(180, 90, 5),
    SLAUGHTERHOUSE(220, 65, 6),
    SQUAD_ATTACK(170, 90, 6),
    KNIVES_RAIN(180, 70, 5),
    BLEEDING_EARS(190, 70, 5),
    LAST_LAUGH_LAST_KNIFE(180, 80, 7),
    IMPALE(210, 70, 6),
    CLOUDY_WITH_CHANCE_KNIFES(200, 80, 6),
    KNIVES_FLOOR(180, 100, 3),
}
