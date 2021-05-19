package com.javarush.task.task37.task3713.space.crew;

public abstract class AbstractCrewMember {
    public enum CompetencyLevel {
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
     //   if (nextCrewMember.competencyLevel == CompetencyLevel.EXPERT) {

        if (this.competencyLevel == competencyLevel) {
            doTheJob(request);
            return;
        } if (this.competencyLevel.ordinal() < competencyLevel.ordinal()) {
            nextCrewMember.handleRequest(competencyLevel, request);
        }
    }

    protected abstract void doTheJob(String request);
}
/*
The request ATTACK will be handled by first mate, let's not bother the captain with it.
-----------------------------------------
The request WASH THE FLOOR will be handled by first mate, let's not bother the captain with it.
-----------------------------------------
The request CHECK ENGINE will be handled by first mate, let's not bother the captain with it.
-----------------------------------------
The request SET ROUTE will be handled by first mate, let's not bother the captain with it.

Запрос ATTACK будет обработан первым помощником, давайте не будем беспокоить его.
-----------------------------------------
Первым помощником будет обработан запрос «МОЙ ЭТАЖ», давайте не будем беспокоить его.
-----------------------------------------
Запрос CHECK ENGINE будет обработан первым помощником, давайте не будем беспокоить его.
-----------------------------------------
Запрос SET ROUTE будет обработан первым помощником, давайте не будем беспокоить его.
 */