package model;

import java.sql.Timestamp;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/20/16.
 * Resit SpA.
 * All rights reserved
 */
public class Checklist {

    int id, executive_in_charge, venture_in_charge, stage;
    String privacy;
    Timestamp created;

    public Checklist(int id, int executive_in_charge, int venture_in_charge, int stage, String privacy, Timestamp created) {
        this.id = id;
        this.executive_in_charge = executive_in_charge;
        this.venture_in_charge = venture_in_charge;
        this.stage = stage;
        this.privacy = privacy;
        this.created = created;
    }
}
