package com.dreammakerteam.ss.core.sdk.snowflake;

/**
 * id中心，发号器
 *
 * @author xy
 */
public class IdCenter {
    private static IdCenter instance;
    private static Sequence sequence;
    public static IdCenter getInstance() {
        if(instance == null) {
            synchronized(IdCenter.class) {
                if (instance == null) {
                    instance = new IdCenter();
                }
            }
        }
        return instance;
    }
    private IdCenter() {
        sequence = new Sequence(1);
    }
    public Long nextId() {
        return sequence.nextId();
    }
}
