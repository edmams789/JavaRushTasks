package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable {

    private static int hitCount;
    private String name;


    public String getName() {
        return name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;


        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 2;


        return defendedBodyPart;
    }


}
