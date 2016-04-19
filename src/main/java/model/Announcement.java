package model;

import java.sql.Timestamp;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/18/16.
 * Resit SpA.
 * All rights reserved
 */
public class Announcement {

    int id, board, executive;
    int[] document;
    Timestamp created;
    String message;
    boolean technical_check, venture_check;

    public Announcement(int id, int board, int executive, int[] document,
                        Timestamp created, String message, boolean technical_check, boolean venture_check) {
        this.id = id;
        this.board = board;
        this.executive = executive;
        this.document = document;
        this.created = created;
        this.message = message;
        this.technical_check = technical_check;
        this.venture_check = venture_check;
    }
}
